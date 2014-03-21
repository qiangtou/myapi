package cn.jiuling.distributedapi.utils;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 读取
 * 
 * @author jiuling
 * 
 */
public class ConfigUtils {
	private static String DEFAULT_FILE = "config.xml";

	/**
	 * 通过类路径下的xml文件名取属性
	 * 
	 * @param fileName
	 *            xml文件名,必须放在类路径下,如aaa.xml
	 * @param key
	 *            属性名
	 * @return 属性的值
	 */
	public static String getValue(String fileName, String key) {
		String value = "";
		try {
			SAXReader r = new SAXReader();
			InputStream fis = ConfigUtils.class.getClassLoader().getResourceAsStream(fileName);
			Document doc = r.read(fis);
			Element root = doc.getRootElement();
			Node n = root.selectSingleNode("//" + key);
			value = n.getStringValue();
		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * 读取默认配置文件的属性
	 * 
	 * @param key
	 *            属性名
	 * @return 属性的值
	 */
	public static String getValue(String key) {
		return getValue(DEFAULT_FILE, key);
	}

	public static void main(String[] args) {
		String s = ConfigUtils.getValue("tokensrv");
		System.out.println(s);
		String s2 = ConfigUtils.getValue("tokensrv");
		System.out.println(s2);
	}

}