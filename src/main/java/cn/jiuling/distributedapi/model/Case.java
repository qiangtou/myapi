package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblCase entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_case")
public class Case implements java.io.Serializable {

	// Fields

	private Long id;
	private Long parentId;
	private Long caseGroupId;
	private String title;
	private Timestamp occurredtime;
	private Timestamp createtime;
	private String location;
	private Integer style;
	private String description;
	private String class_;
	private String serialnumber;
	private Short isDeleted;

	// Constructors

	/** default constructor */
	public Case() {
	}

	public Case(Long parentId, String title, String location, Integer style, Timestamp occurredtime,
			String description, String class_, Long caseGroupId, String serialnumber) {
		this.parentId = parentId;
		this.caseGroupId = caseGroupId;
		this.title = title;
		this.occurredtime = occurredtime;
		this.location = location;
		this.style = style;
		this.description = description;
		this.class_ = class_;
		this.serialnumber = serialnumber;
		this.createtime = new Timestamp(System.currentTimeMillis());
		this.isDeleted = 0;
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

	@Column(name = "ParentID", nullable = false)
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "CaseGroupID", nullable = false)
	public Long getCaseGroupId() {
		return this.caseGroupId;
	}

	public void setCaseGroupId(Long caseGroupId) {
		this.caseGroupId = caseGroupId;
	}

	@Column(name = "title", nullable = false, length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "occurredtime", nullable = false, length = 19)
	public Timestamp getOccurredtime() {
		return this.occurredtime;
	}

	public void setOccurredtime(Timestamp occurredtime) {
		this.occurredtime = occurredtime;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Column(name = "location", nullable = false)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "style", nullable = false)
	public Integer getStyle() {
		return this.style;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "class", nullable = false, length = 256)
	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	@Column(name = "serialnumber", nullable = false, length = 128)
	public String getSerialnumber() {
		return this.serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	@Column(name = "is_deleted", nullable = false)
	public Short getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

}