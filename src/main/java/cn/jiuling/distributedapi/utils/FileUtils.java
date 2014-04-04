package cn.jiuling.distributedapi.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

public class FileUtils {
	// 验证字符串是否为正确路径名的正则表达式
	private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";
	// 通过 sPath.matches(matches) 方法的返回值判断是否正确
	// sPath 为路径字符串
	boolean flag = false;
	File file;

	// 创建单个文件
	public static boolean createFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {// 判断文件是否存在
			System.out.println("目标文件已存在" + filePath);
			return false;
		}
		if (filePath.endsWith(File.separator)) {// 判断文件是否为目录
			System.out.println("目标文件不能为目录！");
			return false;
		}
		if (!file.getParentFile().exists()) {// 判断目标文件所在的目录是否存在
			// 如果目标文件所在的文件夹不存在，则创建父文件夹
			System.out.println("目标文件所在目录不存在，准备创建它！");
			if (!file.getParentFile().mkdirs()) {// 判断创建目录是否成功
				System.out.println("创建目标文件所在的目录失败！");
				return false;
			}
		}
		try {
			if (file.createNewFile()) {// 创建目标文件
				System.out.println("创建文件成功:" + filePath);
				return true;
			} else {
				System.out.println("创建文件失败！");
				return false;
			}
		} catch (IOException e) {// 捕获异常
			e.printStackTrace();
			System.out.println("创建文件失败！" + e.getMessage());
			return false;
		}
	}

	// 创建目录
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			System.out.println("创建目录失败，目标目录已存在！");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			System.out.println("创建目录成功！" + destDirName);
			return true;
		} else {
			System.out.println("创建目录失败！");
			return false;
		}
	}

	// 创建临时文件
	public static String createTempFile(String prefix, String suffix,
			String dirName) {
		File tempFile = null;
		if (dirName == null) {// 目录如果为空
			try {
				tempFile = File.createTempFile(prefix, suffix);// 在默认文件夹下创建临时文件
				return tempFile.getCanonicalPath();// 返回临时文件的路径
			} catch (IOException e) {// 捕获异常
				e.printStackTrace();
				System.out.println("创建临时文件失败：" + e.getMessage());
				return null;
			}
		} else {
			// 指定目录存在
			File dir = new File(dirName);// 创建目录
			if (!dir.exists()) {
				// 如果目录不存在则创建目录
				if (FileUtils.createDir(dirName)) {
					System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
					return null;
				}
			}
			try {
				tempFile = File.createTempFile(prefix, suffix, dir);// 在指定目录下创建临时文件
				return tempFile.getCanonicalPath();// 返回临时文件的路径
			} catch (IOException e) {// 捕获异常
				e.printStackTrace();
				System.out.println("创建临时文件失败!" + e.getMessage());
				return null;
			}
		}
	}

	/**
	 * 判断文件是否存在
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isExistFile(String path) {
		File f = new File(path);
		return f.exists() && f.isFile();
	}

	/**
	 * 取得扩展名(带点的)
	 * 
	 * @param name
	 * @return
	 */
	public static String getExt(String name) {
		Integer index = name.lastIndexOf(".");
		return index > -1 ? name.substring(index) : "";
	}

	public static File copy(String in, String out) throws IOException {
		File outFile = getNoRepeatFilename(out);
		FileCopyUtils.copy(new File(in), outFile);
		return outFile;
	}

	public static File getNoRepeatFilename(String out) {
		File outFile = new File(out);
		String ext = getExt(out);
		String preFix = out.substring(0, out.length() - ext.length());
		int n = 0;
		boolean flag = true;
		while (flag) {
			if (outFile.exists()) {
				out = preFix + "(" + n + ")" + ext;
				n++;
				outFile = new File(out);
			} else {
				flag = false;
			}
		}
		return outFile;
	}

	/**
	 * 从路径中取文件名
	 * 
	 * @param srcName
	 * @return
	 */
	public static String getFileName(String srcName) {
		int index = srcName.lastIndexOf(File.separator);
		return index > -1 ? srcName.substring(index + 1) : srcName;
	}

	public static void main(String[] args) throws IOException {
		FileUtils.createDir("e:\\ab\\cc");
	}

	public static double getDirSize(String string) {
		return getDirSize(new File(string));
	}

	public static double getDirSize(File file) {
		// 判断文件是否存在
		if (file.exists()) {
			// 如果是目录则递归计算其内容的总大小
			if (file.isDirectory()) {
				File[] children = file.listFiles();
				double size = 0;
				for (File f : children)
					size += getDirSize(f);
				return size;
			} else {// 如果是文件则直接返回其大小,以“兆”为单位
				double size = (double) file.length() / 1024 / 1024;
				return size;
			}
		} else {
			System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
			return 0.0;
		}
	}

	public static void deleteDirectory(String path) throws IOException {
		org.apache.commons.io.FileUtils.deleteDirectory(new File(path));
	}

	public static void deleteFile(String path) throws IOException {
		if (FileUtils.isExistFile(path)) {
			File f = new File(path);
			f.delete();
		}

	}

	public static String getDisk(String filePath) {
		String disk = "";
		if (!StringUtils.isEmpty(filePath) && filePath.length() >= 2) {
			disk = filePath.substring(0, 2);
		}
		return disk;
	}

	public static String getNoExtName(String srcName) {
		String ext = getExt(srcName);
		srcName = getFileName(srcName);
		return srcName.substring(0, srcName.length() - ext.length());
	}
}
