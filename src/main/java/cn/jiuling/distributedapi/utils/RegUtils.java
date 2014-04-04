package cn.jiuling.distributedapi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class RegUtils {

	private static final String REG_SETTING = "HKEY_CLASSES_ROOT\\SOFTWARE\\ASTRI\\VideoSummary\\Settings\\";
	private static final Logger log = Logger.getLogger(RegUtils.class);

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
		String ftpPath = "c:\\tmp\\ftp_fold";
		try {
			ftpPath = RegUtils.getValue(getRegSetting("FtpPath"));
		} catch (Exception e) {
			log.error("get FtpPath from regeidtor fail!", e);
		}
		return ftpPath;
	}

	/**
	 * 从注册表取VistaDataPath
	 * 
	 * @return
	 */
	public static String getDataPath() {
		String dataPath = "C:\\VideoInvestigation\\VIServer\\DAT";
		try {
			dataPath = RegUtils.getValue(getRegSetting("VistaDataPath"));
		} catch (Exception e) {
			log.error("get VistaDataPath from regedit fail!", e);
		}
		return dataPath;
	}

	private static String getRegSetting(String name) {
		return REG_SETTING + name;
	}

	public static void main(String[] args) {
		String v = RegUtils.getValue(getFtpPath());
		System.out.println(v);
	}
}
