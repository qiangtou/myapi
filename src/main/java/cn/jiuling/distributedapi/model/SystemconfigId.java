package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SystemconfigId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class SystemconfigId implements java.io.Serializable {

	// Fields

	private String uploadDirectory;
	private String transcodedDirectory;
	private Short summaryResolution;
	private Short isExternalAccessAllow;
	private Short isAllowAssignTask;

	// Constructors

	/** default constructor */
	public SystemconfigId() {
	}

	/** minimal constructor */
	public SystemconfigId(String uploadDirectory, String transcodedDirectory, Short summaryResolution) {
		this.uploadDirectory = uploadDirectory;
		this.transcodedDirectory = transcodedDirectory;
		this.summaryResolution = summaryResolution;
	}

	/** full constructor */
	public SystemconfigId(String uploadDirectory, String transcodedDirectory, Short summaryResolution, Short isExternalAccessAllow, Short isAllowAssignTask) {
		this.uploadDirectory = uploadDirectory;
		this.transcodedDirectory = transcodedDirectory;
		this.summaryResolution = summaryResolution;
		this.isExternalAccessAllow = isExternalAccessAllow;
		this.isAllowAssignTask = isAllowAssignTask;
	}

	// Property accessors

	@Column(name = "UploadDirectory", nullable = false, length = 1024)
	public String getUploadDirectory() {
		return this.uploadDirectory;
	}

	public void setUploadDirectory(String uploadDirectory) {
		this.uploadDirectory = uploadDirectory;
	}

	@Column(name = "TranscodedDirectory", nullable = false, length = 1024)
	public String getTranscodedDirectory() {
		return this.transcodedDirectory;
	}

	public void setTranscodedDirectory(String transcodedDirectory) {
		this.transcodedDirectory = transcodedDirectory;
	}

	@Column(name = "SummaryResolution", nullable = false)
	public Short getSummaryResolution() {
		return this.summaryResolution;
	}

	public void setSummaryResolution(Short summaryResolution) {
		this.summaryResolution = summaryResolution;
	}

	@Column(name = "IsExternalAccessAllow")
	public Short getIsExternalAccessAllow() {
		return this.isExternalAccessAllow;
	}

	public void setIsExternalAccessAllow(Short isExternalAccessAllow) {
		this.isExternalAccessAllow = isExternalAccessAllow;
	}

	@Column(name = "IsAllowAssignTask")
	public Short getIsAllowAssignTask() {
		return this.isAllowAssignTask;
	}

	public void setIsAllowAssignTask(Short isAllowAssignTask) {
		this.isAllowAssignTask = isAllowAssignTask;
	}

}