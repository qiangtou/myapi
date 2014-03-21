package cn.jiuling.distributedapi.utils;

import java.io.File;

public class DiskSpaceUtils {

	private static final String USER_DIR = System.getProperty("user.dir");
	private static final String DISK = USER_DIR.substring(0, 2);
	private static final long M2B = 1048576L;

	/**
	 * 检查生成摘要视频的磁盘是否有可用空间
	 * 
	 * @return
	 */
	public static boolean IsSummarySpaceEnough() {
		return checkSpace("summarySpace");
	}

	/**
	 * 检查转码的磁盘是否有可用空间
	 * 
	 * @return
	 */
	public static boolean IsTranscodeSpaceEnough() {
		return checkSpace("transcodeSpace");
	}

	private static boolean checkSpace(String name) {
		String value = ConfigUtils.getValue(name);
		value = "".equals(value) ? "0" : value;
		Long expectSpace = Long.valueOf(value);
		long usableSpace = getUsableSpace();
		return expectSpace < usableSpace;
	}

	/**
	 * 获取当前工作目录所在盘的可用空间
	 * 
	 * @return Mb
	 */
	public static long getUsableSpace() {
		File root = new File(DISK);
		long usableSpace = root.getUsableSpace();
		return usableSpace / M2B;
	}

	/**
	 * 获取可用空间
	 * 
	 * @param path
	 *            一个路径
	 * @return 传入路径盘的可用空间Mb
	 */
	public static long getUsableSpace(String path) {
		// 取得分区
		File root = new File(path.substring(0, 2));
		long usableSpace = root.getUsableSpace();
		return usableSpace / M2B;
	}

}
