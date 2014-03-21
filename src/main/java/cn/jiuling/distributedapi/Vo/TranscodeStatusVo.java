package cn.jiuling.distributedapi.Vo;

public class TranscodeStatusVo {
	/*$resultArray['status'] = $row['status'];
	  $resultArray['srcURI'] = $row['srcURL'];
	  $resultArray['destURI'] = $row['destURL'];
	  $resultArray['downloadURI'] = $row['downloadURI'];
	  $resultArray['progress'] = $row['progress'];
	  $resultArray['submit'] = $submit;
	  $resultArray['resolution'] = $row['resolution'];
	  $resultArray['duration'] = $row['duration'];
	  $resultArray['space'] = $row['space'];
	  $resultArray['frame_rate'] = $row['frame_rate'];*/

	private Short status;
	private String srcURI;
	private String destURI;
	private String downloadURI;
	private Short progress;
	private Short submit;
	private String resolution;
	private Integer duration;
	private Integer space;
	private Integer frame_rate;

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getSrcURI() {
		return srcURI;
	}

	public void setSrcURI(String srcURI) {
		this.srcURI = srcURI;
	}

	public String getDestURI() {
		return destURI;
	}

	public void setDestURI(String destURI) {
		this.destURI = destURI;
	}

	public String getDownloadURI() {
		return downloadURI;
	}

	public void setDownloadURI(String downloadURI) {
		this.downloadURI = downloadURI;
	}

	public Short getProgress() {
		return progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	public Short getSubmit() {
		return submit;
	}

	public void setSubmit(Short submit) {
		this.submit = submit;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getSpace() {
		return space;
	}

	public void setSpace(Integer space) {
		this.space = space;
	}

	public Integer getFrame_rate() {
		return frame_rate;
	}

	public void setFrame_rate(Integer frameRate) {
		frame_rate = frameRate;
	}

}
