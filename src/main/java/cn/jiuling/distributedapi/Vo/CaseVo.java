package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;

public class CaseVo {
	@Node("caseid")
	private Long id;
	@Node("parenid")
	private Long parentId;
	@Node("groupid")
	private Long caseGroupId;
	@Node("casetitle")
	private String title;
	private Timestamp occurredtime;
	private Timestamp createtime;
	private String location;
	@Node("casestyle")
	private Integer style;
	private String description;
	@Node("class")
	private String class_;
	private String serialnumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getCaseGroupId() {
		return caseGroupId;
	}

	public void setCaseGroupId(Long caseGroupId) {
		this.caseGroupId = caseGroupId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getOccurredtime() {
		return occurredtime;
	}

	public void setOccurredtime(Timestamp occurredtime) {
		this.occurredtime = occurredtime;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getStyle() {
		return style;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class1) {
		class_ = class1;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

}
