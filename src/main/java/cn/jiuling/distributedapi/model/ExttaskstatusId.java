package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ExttaskstatusId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ExttaskstatusId implements java.io.Serializable {

	// Fields

	private String flowNumber;
	private Short downloadStatus;
	private Integer taskId;
	private Long analyFlag;
	private Long genFlag;
	private Double progress;
	private String filename;
	private Long generateId;
	private Long analysisId;

	// Constructors

	/** default constructor */
	public ExttaskstatusId() {
	}

	/** minimal constructor */
	public ExttaskstatusId(Long generateId, Long analysisId) {
		this.generateId = generateId;
		this.analysisId = analysisId;
	}

	/** full constructor */
	public ExttaskstatusId(String flowNumber, Short downloadStatus, Integer taskId, Long analyFlag, Long genFlag, Double progress, String filename,
			Long generateId, Long analysisId) {
		this.flowNumber = flowNumber;
		this.downloadStatus = downloadStatus;
		this.taskId = taskId;
		this.analyFlag = analyFlag;
		this.genFlag = genFlag;
		this.progress = progress;
		this.filename = filename;
		this.generateId = generateId;
		this.analysisId = analysisId;
	}

	// Property accessors

	@Column(name = "flowNumber", length = 51)
	public String getFlowNumber() {
		return this.flowNumber;
	}

	public void setFlowNumber(String flowNumber) {
		this.flowNumber = flowNumber;
	}

	@Column(name = "downloadStatus")
	public Short getDownloadStatus() {
		return this.downloadStatus;
	}

	public void setDownloadStatus(Short downloadStatus) {
		this.downloadStatus = downloadStatus;
	}

	@Column(name = "taskID")
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Column(name = "analyFlag")
	public Long getAnalyFlag() {
		return this.analyFlag;
	}

	public void setAnalyFlag(Long analyFlag) {
		this.analyFlag = analyFlag;
	}

	@Column(name = "genFlag")
	public Long getGenFlag() {
		return this.genFlag;
	}

	public void setGenFlag(Long genFlag) {
		this.genFlag = genFlag;
	}

	@Column(name = "progress", precision = 18, scale = 1)
	public Double getProgress() {
		return this.progress;
	}

	public void setProgress(Double progress) {
		this.progress = progress;
	}

	@Column(name = "filename")
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "GenerateID", nullable = false)
	public Long getGenerateId() {
		return this.generateId;
	}

	public void setGenerateId(Long generateId) {
		this.generateId = generateId;
	}

	@Column(name = "AnalysisID", nullable = false)
	public Long getAnalysisId() {
		return this.analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}
}