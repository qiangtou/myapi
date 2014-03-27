package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Fsrtask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_fsrtask")
public class Fsrtask implements java.io.Serializable {

	// Fields

	private Integer taskid;
	private String imagepath;
	private Integer status;
	private Integer progress;
	private String resultpath;
	private String params;

	// Constructors

	/** default constructor */
	public Fsrtask() {
	}

	/** minimal constructor */
	public Fsrtask(String imagepath, Integer status, Integer progress, String resultpath) {
		this.imagepath = imagepath;
		this.status = status;
		this.progress = progress;
		this.resultpath = resultpath;
	}

	/** full constructor */
	public Fsrtask(String imagepath, Integer status, Integer progress, String resultpath, String params) {
		this.imagepath = imagepath;
		this.status = status;
		this.progress = progress;
		this.resultpath = resultpath;
		this.params = params;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taskid", unique = true, nullable = false)
	public Integer getTaskid() {
		return this.taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	@Column(name = "imagepath", nullable = false, length = 1024)
	public String getImagepath() {
		return this.imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "progress", nullable = false)
	public Integer getProgress() {
		return this.progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	@Column(name = "resultpath", nullable = false, length = 1024)
	public String getResultpath() {
		return this.resultpath;
	}

	public void setResultpath(String resultpath) {
		this.resultpath = resultpath;
	}

	@Column(name = "params")
	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}