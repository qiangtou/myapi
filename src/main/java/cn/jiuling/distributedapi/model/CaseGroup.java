package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblCasegroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_casegroup")
public class CaseGroup implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;
	private String description;
	private Long creator;
	private Timestamp createtime;

	// Constructors

	/** default constructor */
	public CaseGroup() {
	}

	/** full constructor */
	public CaseGroup(String title, String description, Long creator, Timestamp createtime) {
		this.title = title;
		this.description = description;
		this.creator = creator;
		this.createtime = createtime;
	}

	public CaseGroup(Integer creator, String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.creator = Long.valueOf(creator);
		this.createtime = new Timestamp(System.currentTimeMillis());
	}

	public CaseGroup(Long id, String title, String description) {
		this.title = title;
		this.description = description;
		this.id = id;
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

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "creator", nullable = false)
	public Long getCreator() {
		return this.creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

}