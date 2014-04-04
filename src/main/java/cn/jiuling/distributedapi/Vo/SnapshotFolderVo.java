package cn.jiuling.distributedapi.Vo;

public class SnapshotFolderVo {
	private String orglfolderpath;
	private String localFilename;

	public String getOrglfolderpath() {
		return orglfolderpath;
	}

	public void setOrglfolderpath(String orglfolderpath) {
		this.orglfolderpath = orglfolderpath;
	}

	public String getLocalFilename() {
		return localFilename;
	}

	public void setLocalFilename(String localFilename) {
		this.localFilename = localFilename;
	}

	public SnapshotFolderVo(String orglfolderpath, String localFilename) {
		super();
		this.orglfolderpath = orglfolderpath;
		this.localFilename = localFilename;
	}

}
