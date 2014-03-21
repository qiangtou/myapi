package cn.jiuling.distributedapi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegUtils {

	private static final String REG_SETTING = "HKEY_CLASSES_ROOT\\SOFTWARE\\ASTRI\\VideoSummary\\Settings\\";

	public static String getValue(String reg) {
		String value = "";
		try {
			Process ps = null;
			ps = Runtime.getRuntime().exec("reg query " + reg);
			ps.getOutputStream().close();
			InputStreamReader i = new InputStreamReader(ps.getInputStream());
			String line;
			BufferedReader ir = new BufferedReader(i);
			ir.readLine();
			ir.readLine();
			String[] regs;
			while ((line = ir.readLine()) != null) {
				regs = line.split("\\s+");
				value = regs[regs.length - 1];
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 从注册表取ftpPath
	 * 
	 * @return
	 */
	public static String getFtpPath() {
		return RegUtils.getValue(getRegSetting("FtpPath"));
	}

	/**
	 * 从注册表取VistaDataPath
	 * 
	 * @return
	 */
	public static String getDataPath() {
		return RegUtils.getValue(getRegSetting("VistaDataPath"));
	}

	private static String getRegSetting(String name) {
		return REG_SETTING + name;
	}

	public static void main(String[] args) {
		String v = RegUtils.getValue(getFtpPath());
		System.out.println(v);
	}
}
