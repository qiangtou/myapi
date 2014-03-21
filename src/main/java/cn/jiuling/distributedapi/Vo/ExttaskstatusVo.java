package cn.jiuling.distributedapi.Vo;

public class ExttaskstatusVo {
	/*	<status></ status >   //返回状态，状态目前有：
	    0: 任务在等待处理的队列中；
	    1: 任务处理完毕，处理结果：成功；
	    2：任务正在处理中；
	    3: 任务处于暂停状态；
	    4:任务需要删除，或正在删除中；
	    5:任务处理完毕，处理结果：失败；
	    6: 任务正在重试中；<description></description> //对上述状态的说明
	<process></ process >  //当状态为处理中时，返回百分比的进度，0-100
	<summaryurl></summaryurl>  //浓缩视频的下载路径        
	<daturl></daturl>//浓缩视频dat的下载路径
	<summaryPath></summaryPath>//浓缩视频的点播路径（绝对路径）
	*/
	private Long status;
	private String description;
	private Double process;
	private String summaryurl;
	private String daturl;
	private String summaryPath;

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getProcess() {
		return process;
	}

	public void setProcess(Double process) {
		this.process = process;
	}

	public String getSummaryurl() {
		return summaryurl;
	}

	public void setSummaryurl(String summaryurl) {
		this.summaryurl = summaryurl;
	}

	public String getDaturl() {
		return daturl;
	}

	public void setDaturl(String daturl) {
		this.daturl = daturl;
	}

	public String getSummaryPath() {
		return summaryPath;
	}

	public void setSummaryPath(String summaryPath) {
		this.summaryPath = summaryPath;
	}

}
