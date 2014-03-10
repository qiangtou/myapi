package cn.jiuling.distributedapi.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import cn.jiuling.distributedapi.Vo.Node;
import cn.jiuling.distributedapi.Vo.ResStatus;
import cn.jiuling.distributedapi.model.User;

public class XmlUtil {
	private static Logger log = Logger.getLogger(XmlUtil.class);
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
		res.append(parse(obj, ROOT_ELEMENT));
		wrapper(res);
		return handlerReturnType(res.toString());
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
		if (null != list) {
			for (int i = 0, j = list.size(); i < j; i++) {
				res.append(parse(list.get(i), ROOT_ELEMENT));
			}
		}
		wrapper(res);
		return handlerReturnType(res.toString());
	}

	/**
	 * @param rs
	 *            返回状态对象
	 * @param obj
	 *            返回数据对象
	 * @param wrapElement
	 *            数据对象是否需要包一层元素
	 * @return xml字符串
	 */
	public static String parse(ResStatus rs, Object obj, boolean wrapElement) {
		StringBuilder res = parseStatus(rs);
		String wrap = wrapElement ? ROOT_ELEMENT : "";
		res.append(parse(obj, wrap));
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
			value = getFieldValue(obj, f);
			node = f.getAnnotation(Node.class);
			field = null == node ? f.getName().toLowerCase() : node.value();
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
		f.setAccessible(true);
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
		int rootIndex = xml.indexOf("<" + ROOT_ELEMENT);
		if (rootIndex == -1) {
			xml = handlerObj(xml);
		} else {
			String fomer = handlerObj(xml.substring(0, rootIndex));
			String latter = xml.substring(rootIndex).replaceAll("<" + ROOT_ELEMENT + ">", "");
			String latters[] = latter.split("</" + ROOT_ELEMENT + ">");
			int len = latters.length;
			boolean isList = len > 1;
			String preFix = "\"" + ROOT_ELEMENT + "\":" + (isList ? "[" : "");
			for (int i = 0, j = len; i < j; i++) {
				preFix = preFix + "{" + handlerObj(latters[i]) + "},";
			}
			int comer = preFix.lastIndexOf(",");
			if (comer > -1) {
				preFix = preFix.substring(0, comer);
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
		User u = new User();
		ResStatus rs = new ResStatus();
		rs.setCode(333);
		rs.setDesc("这是一个测试");
		String xml = XmlUtil.parse(rs);

		List l = new ArrayList<User>();
		l.add(u);
		// log.info();
		xml = toJson(XmlUtil.parse(rs, l));
		log.info(xml);

	}
}
