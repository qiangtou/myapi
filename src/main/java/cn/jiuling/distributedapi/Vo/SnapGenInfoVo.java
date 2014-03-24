package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;
import java.util.Date;

public class SnapGenInfoVo {

	private String snapshotFolder;
	private Short outputWidth;
	private Short outputHeight;
	private Float frmRate;
	private Timestamp recordTime;
	private Short objType;

	public SnapGenInfoVo(String snapshotFolder, Short outputWidth, Short outputHeight, Float frmRate, Timestamp recordTime, Short objType) {
		super();
		this.snapshotFolder = snapshotFolder;
		this.outputWidth = outputWidth;
		this.outputHeight = outputHeight;
		this.frmRate = frmRate;
		this.recordTime = recordTime;
		this.objType = objType;
	}

	public SnapGenInfoVo(String snapshotFolder, Short outputWidth, Short outputHeight, Float frmRate, Date recordTime, Short objType, Short taskType) {
		this(snapshotFolder, outputWidth, outputHeight, frmRate, new Timestamp(recordTime.getTime()), objType);
		if (taskType == 2) {
			this.objType = 0;
		}
	}

	public String getSnapshotFolder() {
		return snapshotFolder;
	}

	public void setSnapshotFolder(String snapshotFolder) {
		this.snapshotFolder = snapshotFolder;
	}

	public Short getOutputWidth() {
		return outputWidth;
	}

	public void setOutputWidth(Short outputWidth) {
		this.outputWidth = outputWidth;
	}

	public Short getOutputHeight() {
		return outputHeight;
	}

	public void setOutputHeight(Short outputHeight) {
		this.outputHeight = outputHeight;
	}

	public Float getFrmRate() {
		return frmRate;
	}

	public void setFrmRate(Float frmRate) {
		this.frmRate = frmRate;
	}

	public Timestamp getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public Short getObjType() {
		return objType;
	}

	public void setObjType(Short objType) {
		this.objType = objType;
	}
}
