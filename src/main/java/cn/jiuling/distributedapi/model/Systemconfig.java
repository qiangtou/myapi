package cn.jiuling.distributedapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Systemconfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_systemconfig")
public class Systemconfig implements java.io.Serializable {

	// Fields

	private SystemconfigId id;

	// Constructors

	/** default constructor */
	public Systemconfig() {
	}

	/** full constructor */
	public Systemconfig(SystemconfigId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "uploadDirectory", column = @Column(name = "UploadDirectory", nullable = false, length = 1024)),
			@AttributeOverride(name = "transcodedDirectory", column = @Column(name = "TranscodedDirectory", nullable = false, length = 1024)),
			@AttributeOverride(name = "summaryResolution", column = @Column(name = "SummaryResolution", nullable = false)),
			@AttributeOverride(name = "isExternalAccessAllow", column = @Column(name = "IsExternalAccessAllow")),
			@AttributeOverride(name = "isAllowAssignTask", column = @Column(name = "IsAllowAssignTask")) })
	public SystemconfigId getId() {
		return this.id;
	}

	public void setId(SystemconfigId id) {
		this.id = id;
	}

}