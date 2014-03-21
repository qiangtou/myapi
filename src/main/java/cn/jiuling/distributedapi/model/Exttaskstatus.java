package cn.jiuling.distributedapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Exttaskstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "exttaskstatus")
public class Exttaskstatus implements java.io.Serializable {

	// Fields

	private ExttaskstatusId id;

	// Constructors

	/** default constructor */
	public Exttaskstatus() {
	}

	/** full constructor */
	public Exttaskstatus(ExttaskstatusId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "flowNumber", column = @Column(name = "flowNumber", length = 51)),
			@AttributeOverride(name = "downloadStatus", column = @Column(name = "downloadStatus")),
			@AttributeOverride(name = "taskId", column = @Column(name = "taskID")),
			@AttributeOverride(name = "analyFlag", column = @Column(name = "analyFlag")),
			@AttributeOverride(name = "genFlag", column = @Column(name = "genFlag")),
			@AttributeOverride(name = "progress", column = @Column(name = "progress", precision = 18, scale = 1)),
			@AttributeOverride(name = "filename", column = @Column(name = "filename")),
			@AttributeOverride(name = "generateId", column = @Column(name = "GenerateID", nullable = false)),
			@AttributeOverride(name = "analysisId", column = @Column(name = "AnalysisID", nullable = false)) })
	public ExttaskstatusId getId() {
		return this.id;
	}

	public void setId(ExttaskstatusId id) {
		this.id = id;
	}

}