package cn.jiuling.distributedapi.Vo;

public class QueryTaskVo {
	/*<element>
	<flownumber></flownumber>//用这个flownumber查询分析状态
	<status></status>
	<type><type>
	<SummarySrcURI>< SummarySrcURI />//浓缩视频点播路径
	<SummaryDownLoadURI>< SummaryDownLoadURI />//浓缩视频下载路径
	< DatDownLoadURI >< DatDownLoadURI />//dat文件下载路径
	<progress><progress>
	< taskName>< taskName>
	<element>*/

	private String flownumber;
	private Long status;
	private Short type;
	private String SummarySrcURI;
	private String SummaryDownLoadURI;
	private String DatDownLoadURI;
	private Float progress;
	private String taskName;

	public QueryTaskVo() {
		super();
	}

	/*flownumber        BIGINT,
	status            INT,
	type              INT,
	SummarySrcURL     VARCHAR(1024), 
	SummaryDownLoadURL VARCHAR(1024), 
	DatDownLoadURL    VARCHAR(1024), 
	progress          FLOAT,
	taskName          VARCHAR(56)*/
	// e.flowNumber,s.id.genFlag,e.taskType,s.id.filename,s.id.progress,e.taskName
	public QueryTaskVo(String flownumber, Long status, Short type, String fileName, Float progress, String taskName) {
		super();
	}

	public QueryTaskVo(Object flownumber, Object status, Object type, Object fileName, Object progress, Object taskName) {
		super();

		if (null == fileName) {
			fileName = "";
		}
		this.flownumber = (String) flownumber;
		this.status = (Long) status;
		this.type = (Short) type;
		this.SummarySrcURI = (String) fileName;// 要在外面改一下
		fileName = ((String) fileName).replace("\\AstVS_1v2", "");
		this.SummaryDownLoadURI = (String) fileName;
		this.SummarySrcURI = ((String) fileName).replace(".avi", ".dat");;
		this.progress = (Float) progress;
		this.taskName = (String) taskName;
	}

	public String getFlownumber() {
		return flownumber;
	}

	public void setFlownumber(String flownumber) {
		this.flownumber = flownumber;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getSummarySrcURI() {
		return SummarySrcURI;
	}

	public void setSummarySrcURI(String summarySrcURI) {
		SummarySrcURI = summarySrcURI;
	}

	public String getSummaryDownLoadURI() {
		return SummaryDownLoadURI;
	}

	public void setSummaryDownLoadURI(String summaryDownLoadURI) {
		SummaryDownLoadURI = summaryDownLoadURI;
	}

	public String getDatDownLoadURI() {
		return DatDownLoadURI;
	}

	public void setDatDownLoadURI(String datDownLoadURI) {
		DatDownLoadURI = datDownLoadURI;
	}

	public Float getProgress() {
		return progress;
	}

	public void setProgress(Float progress) {
		this.progress = progress;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
}
