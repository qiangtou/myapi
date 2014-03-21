package cn.jiuling.distributedapi.Vo;

public class StatusInfoVo {
	private long ftpSpace;
	private long summarySpace;
	private long transcoding;
	private long waitingTranscoding;
	private long analysising;
	private long waitinganAlysising;

	public StatusInfoVo() {
		super();
	}

	public StatusInfoVo(long transcoding, long waitingTranscoding, long analysising, long waitinganAlysising) {
		super();
		this.transcoding = transcoding;
		this.waitingTranscoding = waitingTranscoding;
		this.analysising = analysising;
		this.waitinganAlysising = waitinganAlysising;
	}

	public long getFtpSpace() {
		return ftpSpace;
	}

	public void setFtpSpace(long ftpSpace) {
		this.ftpSpace = ftpSpace;
	}

	public long getSummarySpace() {
		return summarySpace;
	}

	public void setSummarySpace(long summarySpace) {
		this.summarySpace = summarySpace;
	}

	public long getTranscoding() {
		return transcoding;
	}

	public void setTranscoding(long transcoding) {
		this.transcoding = transcoding;
	}

	public long getWaitingTranscoding() {
		return waitingTranscoding;
	}

	public void setWaitingTranscoding(long waitingTranscoding) {
		this.waitingTranscoding = waitingTranscoding;
	}

	public long getAnalysising() {
		return analysising;
	}

	public void setAnalysising(long analysising) {
		this.analysising = analysising;
	}

	public long getWaitinganAlysising() {
		return waitinganAlysising;
	}

	public void setWaitinganAlysising(long waitinganAlysising) {
		this.waitinganAlysising = waitinganAlysising;
	}
}
