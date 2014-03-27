package cn.jiuling.distributedapi.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import cn.jiuling.distributedapi.Vo.Node;
import cn.jiuling.distributedapi.Vo.ResStatus;

public class ResponseUtils {
	private static Logger log = Logger.getLogger(ResponseUtils.class);
	public static String ROOT_ELEMENT = "element";
	public static String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	private static Boolean toJson;

	private static boolean isToJson() {
		if (null == toJson) {
			toJson = "json".equals(PropertiesUtils.get("return_type"));
		}
		return toJson;
	}

	/**
	 * @param rs
	 *            返回状态对象
	 * @return xml字符串
	 */
	public static String parse(ResStatus rs) {
		StringBuilder res = parseStatus(rs);
		wrapper(res);
		return handlerReturnType(res.toString());
	}

	private static String handlerReturnType(String res) {
		return isToJson() ? toJson(res) : res;
	}

	/**
	 * @param rs
	 *            返回状态对象
	 * @param obj
	 *            返回数据对象
	 * @return xml字符串
	 */
	public static String parse(ResStatus rs, Object obj) {
		StringBuilder res = parseStatus(rs);
		String root = getRootElement(obj);
		res.append(parse(obj, root));
		wrapper(res);
		return handlerReturnType(res.toString());
	}

	private static String getRootElement(Object obj) {
		Node n = obj.getClass().getAnnotation(Node.class);
		return null == n ? ROOT_ELEMENT : n.value();
	}

	/**
	 * @param rs
	 *            返回状态对象
	 * @param list
	 *            返回数据对象列表
	 * @return xml字符串
	 */
	public static String parse(ResStatus rs, List list) {
		StringBuilder res;
		res = parseStatus(rs);
		res.append(parse(list));
		wrapper(res);
		return handlerReturnType(res.toString());
	}

	/**
	 * @param rs
	 *            返回状态对象
	 * @param obj
	 *            返回数据对象
	 * @param wrapElement
	 *            数据对象是否需要包一层元素,true:用element包住;false:没有element包住
	 * @return xml字符串
	 */
	public static String parse(ResStatus rs, Object obj, boolean wrapElement) {
		StringBuilder res = parseStatus(rs);
		if (null != obj) {
			String root = getRootElement(obj);
			String wrap = wrapElement ? root : "";
			res.append(parse(obj, wrap));
		}
		wrapper(res);
		return handlerReturnType(res.toString());
	}

	private static StringBuilder parseStatus(ResStatus rs) {
		if (rs == null) {
			return new StringBuilder("");
		}
		Class clz = rs.getClass();
		Class superclass = clz.getSuperclass();
		StringBuilder xml = parseByClass(rs, clz);
		if (ResStatus.class == superclass) {
			xml.insert(0, parseByClass(rs, superclass));
		}
		return xml;
	}

	public static StringBuilder parse(Object obj) {
		Class<? extends Object> clz = obj.getClass();
		return parseByClass(obj, clz);
	}

	public static String parse(List list) {
		String str = "";
		if (list != null) {
			int size = list.size();
			if (size > 0) {
				String root;
				for (int i = 0; i < size; i++) {
					Object obj = list.get(i);
					root = getRootElement(obj);
					str += parse(obj, root);
				}
			}
		}
		return str;
	}

	public static StringBuilder parse(Object obj, String root) {
		Class<? extends Object> clz = obj.getClass();
		return parseByClass(root, obj, clz);
	}

	private static StringBuilder wrapper(StringBuilder sb) {
		return sb.insert(0, XML_DECLARATION + "\n<result>\n").append("</result>");
	}

	private static StringBuilder parseByClass(Object obj, Class<? extends Object> clz) {
		StringBuilder sb = new StringBuilder("");
		String field, value;
		Field fs[] = clz.getDeclaredFields();
		Node node;
		for (Field f : fs) {
			f.setAccessible(true);
			try {
				Object o = f.get(obj);
				if (o instanceof java.util.List) {
					sb.append(parse((List) o));
					continue;
				};
			} catch (Exception e) {
			}
			value = getFieldValue(obj, f);
			node = f.getAnnotation(Node.class);
			field = null == node ? f.getName() : node.value();
			sb.append("<").append(field).append(">").append(value).append("</").append(field).append(">").append("\n");
		}
		return sb;
	}

	private static StringBuilder parseByClass(String root, Object obj, Class<? extends Object> clz) {
		String startRoot;
		String endRoot;
		boolean hasRoot = !StringUtils.isEmpty(root);
		StringBuilder parseByClass = parseByClass(obj, clz);
		startRoot = "";
		endRoot = "";
		if (hasRoot) {
			startRoot = "<" + root + ">\n";
			endRoot = "</" + root + ">\n";
		}
		return parseByClass.insert(0, startRoot).append(endRoot);

	}

	/**
	 * 取得成员变量的值
	 * 
	 * @param obj
	 *            类的实例
	 * @param f
	 *            成员变量的field
	 * @return 成员变量的值
	 */
	private static String getFieldValue(Object obj, Field f) {
		String value = "";

		try {
			value = "" + f.get(obj);
			value = "null".equals(value) ? "" : value;
			// TODO 处理各种类型
		} catch (Exception e) {
			log.error("get fieldvalue error!!", e);
		}
		return value;
	}

	private static String toJson(String xml) {
		xml = xml.substring(XML_DECLARATION.length());
		xml = xml.replaceAll("</?result>", "");
		xml = xml.replaceAll("\n", "");
		String root = ROOT_ELEMENT;
		int rootIndex = xml.indexOf("<" + root);
		if (rootIndex == -1) {
			xml = handlerObj(xml);
		} else {
			String fomer = handlerObj(xml.substring(0, rootIndex));
			String latter = xml.substring(rootIndex).replaceAll("<" + root + ">", "");
			String latters[] = latter.split("</" + root + ">");
			int len = latters.length;
			boolean isList = len > 1;
			String preFix = "\"" + root + "\":" + (isList ? "[" : "");
			for (int i = 0, j = len; i < j; i++) {
				preFix = preFix + "{" + handlerObj(latters[i]) + "},";
			}
			int commaIndex = preFix.lastIndexOf(",");
			if (commaIndex > -1) {
				preFix = preFix.substring(0, commaIndex);
			}
			preFix += (isList ? "]" : "");

			xml = fomer + "," + preFix;

		}
		xml = "{\"result\":{" + xml + "}}";
		return xml;
	}

	private static String handlerObj(String xml) {
		xml = xml.replaceAll("<([^/].*?)>", "\"$1\":\"");
		xml = xml.replaceAll("<(/.*?)>", "\",");
		int comer = xml.lastIndexOf(",");
		if (comer > -1) {
			xml = xml.substring(0, comer);
		}
		return xml;
	}

	public static void main(String[] args) {
		List l = new ArrayList();
		List l2 = new ArrayList();

		l.add(new b());
		l.add(new b());
		l.add(new b());
		a aa = new a();
		aa.setList(l);
		l2.add(aa);

		String s = ResponseUtils.parse(null, l2).toString();
		log.info(s);
	}
}

@Node("Object_B")
class b {
	private String cc;
}

class a {
	private String gg;
	private List list;

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
