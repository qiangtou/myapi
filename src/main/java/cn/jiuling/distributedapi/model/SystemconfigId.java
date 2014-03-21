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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SystemconfigId))
			return false;
		SystemconfigId castOther = (SystemconfigId) other;

		return ((this.getUploadDirectory() == castOther.getUploadDirectory()) || (this.getUploadDirectory() != null && castOther.getUploadDirectory() != null && this
				.getUploadDirectory().equals(castOther.getUploadDirectory())))
				&& ((this.getTranscodedDirectory() == castOther.getTranscodedDirectory()) || (this.getTranscodedDirectory() != null
						&& castOther.getTranscodedDirectory() != null && this.getTranscodedDirectory().equals(castOther.getTranscodedDirectory())))
				&& ((this.getSummaryResolution() == castOther.getSummaryResolution()) || (this.getSummaryResolution() != null
						&& castOther.getSummaryResolution() != null && this.getSummaryResolution().equals(castOther.getSummaryResolution())))
				&& ((this.getIsExternalAccessAllow() == castOther.getIsExternalAccessAllow()) || (this.getIsExternalAccessAllow() != null
						&& castOther.getIsExternalAccessAllow() != null && this.getIsExternalAccessAllow().equals(castOther.getIsExternalAccessAllow())))
				&& ((this.getIsAllowAssignTask() == castOther.getIsAllowAssignTask()) || (this.getIsAllowAssignTask() != null
						&& castOther.getIsAllowAssignTask() != null && this.getIsAllowAssignTask().equals(castOther.getIsAllowAssignTask())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUploadDirectory() == null ? 0 : this.getUploadDirectory().hashCode());
		result = 37 * result + (getTranscodedDirectory() == null ? 0 : this.getTranscodedDirectory().hashCode());
		result = 37 * result + (getSummaryResolution() == null ? 0 : this.getSummaryResolution().hashCode());
		result = 37 * result + (getIsExternalAccessAllow() == null ? 0 : this.getIsExternalAccessAllow().hashCode());
		result = 37 * result + (getIsAllowAssignTask() == null ? 0 : this.getIsAllowAssignTask().hashCode());
		return result;
	}

}