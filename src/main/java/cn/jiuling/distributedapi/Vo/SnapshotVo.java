package cn.jiuling.distributedapi.Vo;

public class SnapshotVo {
	/*&$isObjSnapReady,         //OUT True:  Object detection and retrieval were done. All objects are ready with snapshot
	&$numOfSnapshots,         //OUT Number of snapshots
	&$snapshotID,						 //OUT Unique snapshot ID
	&$snapshotFilename,       //OUT Array[$numOfSnapshots]: Snapshot filename (Note: Its memory will be allocated in this function)
	&$snapshotStFrm,		       //OUT Array[$numOfSnapshots]: Object starting frame of the reference snapshot
	&$snapshotNumOfFrm,        //OUT Array[$numOfSnapshots]: Object total number of frame of the reference snapshot
	&$snapshotDspFrm,
	&$enable_carnum,
	&$Licenses	 */

	private Short isObjSnapReady;
	private Object numOfSnapshots;
	private Object snapshotID;
	private Object snapshotFilename;
	private Object snapshotNumOfFrm;
	private Object snapshotDspFrm;
	private Object enableCarnum;
	private Object licenses;

	public Short getIsObjSnapReady() {
		return isObjSnapReady;
	}

	public void setIsObjSnapReady(Short isObjSnapReady) {
		this.isObjSnapReady = isObjSnapReady;
	}

	public Object getNumOfSnapshots() {
		return numOfSnapshots;
	}

	public void setNumOfSnapshots(Object numOfSnapshots) {
		this.numOfSnapshots = numOfSnapshots;
	}

	public Object getSnapshotID() {
		return snapshotID;
	}

	public void setSnapshotID(Object snapshotID) {
		this.snapshotID = snapshotID;
	}

	public Object getSnapshotFilename() {
		return snapshotFilename;
	}

	public void setSnapshotFilename(Object snapshotFilename) {
		this.snapshotFilename = snapshotFilename;
	}

	public Object getSnapshotNumOfFrm() {
		return snapshotNumOfFrm;
	}

	public void setSnapshotNumOfFrm(Object snapshotNumOfFrm) {
		this.snapshotNumOfFrm = snapshotNumOfFrm;
	}

	public Object getSnapshotDspFrm() {
		return snapshotDspFrm;
	}

	public void setSnapshotDspFrm(Object snapshotDspFrm) {
		this.snapshotDspFrm = snapshotDspFrm;
	}

	public Object getEnableCarnum() {
		return enableCarnum;
	}

	public void setEnableCarnum(Object enableCarnum) {
		this.enableCarnum = enableCarnum;
	}

	public Object getLicenses() {
		return licenses;
	}

	public void setLicenses(Object licenses) {
		this.licenses = licenses;
	}

}
