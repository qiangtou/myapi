package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AnalysisTime entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "analysis_time")
public class AnalysisTime implements java.io.Serializable {

	// Fields

	private Long taskId;
	private String flowNumber;
	private Timestamp recordTime;

	// Constructors

	/** default constructor */
	public AnalysisTime() {
	}

	/** minimal constructor */
	public AnalysisTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	/** full constructor */
	public AnalysisTime(String flowNumber, Timestamp recordTime) {
		this.flowNumber = flowNumber;
		this.recordTime = recordTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaskID", unique = true, nullable = false)
	public Long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	@Column(name = "flowNumber", length = 51)
	public String getFlowNumber() {
		return this.flowNumber;
	}

	public void setFlowNumber(String flowNumber) {
		this.flowNumber = flowNumber;
	}

	@Column(name = "record_time", nullable = false, length = 19)
	public Timestamp getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

}