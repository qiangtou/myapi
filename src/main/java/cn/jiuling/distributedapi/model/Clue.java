package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblClue entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_clue")
public class Clue implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;
	private Short classified;
	private Long caseId;
	private String description;
	private Timestamp editTime;
	private Long editorId;

	// Constructors

	/** default constructor */
	public Clue() {
	}

	/** full constructor */
	public Clue(String title, Short classified, Long caseId, String description, Timestamp editTime, Long editorId) {
		this.title = title;
		this.classified = classified;
		this.caseId = caseId;
		this.description = description;
		this.editTime = editTime;
		this.editorId = editorId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "classified", nullable = false)
	public Short getClassified() {
		return this.classified;
	}

	public void setClassified(Short classified) {
		this.classified = classified;
	}

	@Column(name = "CaseID", nullable = false)
	public Long getCaseId() {
		return this.caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "EditTime", nullable = false, length = 19)
	public Timestamp getEditTime() {
		return this.editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

	@Column(name = "EditorID", nullable = false)
	public Long getEditorId() {
		return this.editorId;
	}

	public void setEditorId(Long editorId) {
		this.editorId = editorId;
	}

}