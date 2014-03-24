package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Autoanalyseparam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_autoanalyseparam")
public class Autoanalyseparam implements java.io.Serializable {

	// Fields

	private Long id;
	private Long caseid;
	private Long userid;
	private Short taskType;
	private Short runTimeSpeed;
	private Short thickness;
	private Integer sensitivity;
	private Short objEnable;
	private Short objType;
	private Short enableAvgcolor;
	private Integer retrieveAvgcolor;
	private Short enableUppercolor;
	private Integer retrieveUppercolor;
	private Short enableLowercolor;
	private Integer retrieveLowercolor;
	private Short enableCarnum;
	private String retrieveCarnum;
	private Integer taskPriority;
	private Short enableSearchByImage;
	private String requestImageUrl;
	private String requestImageData;
	private String requestMaskUrl;
	private String requestMaskData;

	// Constructors

	/** default constructor */
	public Autoanalyseparam() {
	}

	/** minimal constructor */
	public Autoanalyseparam(Long caseid, Long userid) {
		this.caseid = caseid;
		this.userid = userid;
	}

	/** full constructor */
	public Autoanalyseparam(Long caseid, Long userid, Short taskType, Short runTimeSpeed, Short thickness, Integer sensitivity, Short objEnable, Short objType,
			Short enableAvgcolor, Integer retrieveAvgcolor, Short enableUppercolor, Integer retrieveUppercolor, Short enableLowercolor,
			Integer retrieveLowercolor, Short enableCarnum, String retrieveCarnum, Integer taskPriority, Short enableSearchByImage, String requestImageUrl,
			String requestImageData, String requestMaskUrl, String requestMaskData) {
		this.caseid = caseid;
		this.userid = userid;
		this.taskType = taskType;
		this.runTimeSpeed = runTimeSpeed;
		this.thickness = thickness;
		this.sensitivity = sensitivity;
		this.objEnable = objEnable;
		this.objType = objType;
		this.enableAvgcolor = enableAvgcolor;
		this.retrieveAvgcolor = retrieveAvgcolor;
		this.enableUppercolor = enableUppercolor;
		this.retrieveUppercolor = retrieveUppercolor;
		this.enableLowercolor = enableLowercolor;
		this.retrieveLowercolor = retrieveLowercolor;
		this.enableCarnum = enableCarnum;
		this.retrieveCarnum = retrieveCarnum;
		this.taskPriority = taskPriority;
		this.enableSearchByImage = enableSearchByImage;
		this.requestImageUrl = requestImageUrl;
		this.requestImageData = requestImageData;
		this.requestMaskUrl = requestMaskUrl;
		this.requestMaskData = requestMaskData;
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

	@Column(name = "caseid", nullable = false)
	public Long getCaseid() {
		return this.caseid;
	}

	public void setCaseid(Long caseid) {
		this.caseid = caseid;
	}

	@Column(name = "userid", nullable = false)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "taskType")
	public Short getTaskType() {
		return this.taskType;
	}

	public void setTaskType(Short taskType) {
		this.taskType = taskType;
	}

	@Column(name = "run_time_speed")
	public Short getRunTimeSpeed() {
		return this.runTimeSpeed;
	}

	public void setRunTimeSpeed(Short runTimeSpeed) {
		this.runTimeSpeed = runTimeSpeed;
	}

	@Column(name = "thickness")
	public Short getThickness() {
		return this.thickness;
	}

	public void setThickness(Short thickness) {
		this.thickness = thickness;
	}

	@Column(name = "sensitivity")
	public Integer getSensitivity() {
		return this.sensitivity;
	}

	public void setSensitivity(Integer sensitivity) {
		this.sensitivity = sensitivity;
	}

	@Column(name = "obj_enable")
	public Short getObjEnable() {
		return this.objEnable;
	}

	public void setObjEnable(Short objEnable) {
		this.objEnable = objEnable;
	}

	@Column(name = "obj_type")
	public Short getObjType() {
		return this.objType;
	}

	public void setObjType(Short objType) {
		this.objType = objType;
	}

	@Column(name = "enable_avgcolor")
	public Short getEnableAvgcolor() {
		return this.enableAvgcolor;
	}

	public void setEnableAvgcolor(Short enableAvgcolor) {
		this.enableAvgcolor = enableAvgcolor;
	}

	@Column(name = "retrieve_avgcolor")
	public Integer getRetrieveAvgcolor() {
		return this.retrieveAvgcolor;
	}

	public void setRetrieveAvgcolor(Integer retrieveAvgcolor) {
		this.retrieveAvgcolor = retrieveAvgcolor;
	}

	@Column(name = "enable_uppercolor")
	public Short getEnableUppercolor() {
		return this.enableUppercolor;
	}

	public void setEnableUppercolor(Short enableUppercolor) {
		this.enableUppercolor = enableUppercolor;
	}

	@Column(name = "retrieve_uppercolor")
	public Integer getRetrieveUppercolor() {
		return this.retrieveUppercolor;
	}

	public void setRetrieveUppercolor(Integer retrieveUppercolor) {
		this.retrieveUppercolor = retrieveUppercolor;
	}

	@Column(name = "enable_lowercolor")
	public Short getEnableLowercolor() {
		return this.enableLowercolor;
	}

	public void setEnableLowercolor(Short enableLowercolor) {
		this.enableLowercolor = enableLowercolor;
	}

	@Column(name = "retrieve_lowercolor")
	public Integer getRetrieveLowercolor() {
		return this.retrieveLowercolor;
	}

	public void setRetrieveLowercolor(Integer retrieveLowercolor) {
		this.retrieveLowercolor = retrieveLowercolor;
	}

	@Column(name = "enable_carnum")
	public Short getEnableCarnum() {
		return this.enableCarnum;
	}

	public void setEnableCarnum(Short enableCarnum) {
		this.enableCarnum = enableCarnum;
	}

	@Column(name = "retrieve_carnum", length = 32)
	public String getRetrieveCarnum() {
		return this.retrieveCarnum;
	}

	public void setRetrieveCarnum(String retrieveCarnum) {
		this.retrieveCarnum = retrieveCarnum;
	}

	@Column(name = "task_priority")
	public Integer getTaskPriority() {
		return this.taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	@Column(name = "enable_search_by_image")
	public Short getEnableSearchByImage() {
		return this.enableSearchByImage;
	}

	public void setEnableSearchByImage(Short enableSearchByImage) {
		this.enableSearchByImage = enableSearchByImage;
	}

	@Column(name = "request_image_url", length = 65535)
	public String getRequestImageUrl() {
		return this.requestImageUrl;
	}

	public void setRequestImageUrl(String requestImageUrl) {
		this.requestImageUrl = requestImageUrl;
	}

	@Column(name = "request_image_data")
	public String getRequestImageData() {
		return this.requestImageData;
	}

	public void setRequestImageData(String requestImageData) {
		this.requestImageData = requestImageData;
	}

	@Column(name = "request_mask_url", length = 65535)
	public String getRequestMaskUrl() {
		return this.requestMaskUrl;
	}

	public void setRequestMaskUrl(String requestMaskUrl) {
		this.requestMaskUrl = requestMaskUrl;
	}

	@Column(name = "request_mask_data")
	public String getRequestMaskData() {
		return this.requestMaskData;
	}

	public void setRequestMaskData(String requestMaskData) {
		this.requestMaskData = requestMaskData;
	}

}