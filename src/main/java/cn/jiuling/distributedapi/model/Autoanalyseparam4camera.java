package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Autoanalyseparam4camera entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_autoanalyseparam4camera")
public class Autoanalyseparam4camera implements java.io.Serializable {

	// Fields

	private Long id;
	private Long cameraid;
	private Long userid;
	private Short udrExist;
	private String udrSetting;
	private Short summaryWidth;
	private Short summaryHeight;
	private Short isSetTripArea;
	private String tripArea;
	private Boolean objSearchByMov;
	private String objRequestMovVertics;
	private Integer objRequestMovVerticsNum;

	// Constructors

	/** default constructor */
	public Autoanalyseparam4camera() {
	}

	/** minimal constructor */
	public Autoanalyseparam4camera(Long cameraid, Long userid) {
		this.cameraid = cameraid;
		this.userid = userid;
	}

	/** full constructor */
	public Autoanalyseparam4camera(Long cameraid, Long userid, Short udrExist, String udrSetting, Short summaryWidth, Short summaryHeight, Short isSetTripArea,
			String tripArea, Boolean objSearchByMov, String objRequestMovVertics, Integer objRequestMovVerticsNum) {
		this.cameraid = cameraid;
		this.userid = userid;
		this.udrExist = udrExist;
		this.udrSetting = udrSetting;
		this.summaryWidth = summaryWidth;
		this.summaryHeight = summaryHeight;
		this.isSetTripArea = isSetTripArea;
		this.tripArea = tripArea;
		this.objSearchByMov = objSearchByMov;
		this.objRequestMovVertics = objRequestMovVertics;
		this.objRequestMovVerticsNum = objRequestMovVerticsNum;
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

	@Column(name = "cameraid", nullable = false)
	public Long getCameraid() {
		return this.cameraid;
	}

	public void setCameraid(Long cameraid) {
		this.cameraid = cameraid;
	}

	@Column(name = "userid", nullable = false)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "UDR_exist")
	public Short getUdrExist() {
		return this.udrExist;
	}

	public void setUdrExist(Short udrExist) {
		this.udrExist = udrExist;
	}

	@Column(name = "UDR_setting")
	public String getUdrSetting() {
		return this.udrSetting;
	}

	public void setUdrSetting(String udrSetting) {
		this.udrSetting = udrSetting;
	}

	@Column(name = "summary_width")
	public Short getSummaryWidth() {
		return this.summaryWidth;
	}

	public void setSummaryWidth(Short summaryWidth) {
		this.summaryWidth = summaryWidth;
	}

	@Column(name = "summary_height")
	public Short getSummaryHeight() {
		return this.summaryHeight;
	}

	public void setSummaryHeight(Short summaryHeight) {
		this.summaryHeight = summaryHeight;
	}

	@Column(name = "isSetTripArea")
	public Short getIsSetTripArea() {
		return this.isSetTripArea;
	}

	public void setIsSetTripArea(Short isSetTripArea) {
		this.isSetTripArea = isSetTripArea;
	}

	@Column(name = "trip_area")
	public String getTripArea() {
		return this.tripArea;
	}

	public void setTripArea(String tripArea) {
		this.tripArea = tripArea;
	}

	@Column(name = "obj_search_by_mov")
	public Boolean getObjSearchByMov() {
		return this.objSearchByMov;
	}

	public void setObjSearchByMov(Boolean objSearchByMov) {
		this.objSearchByMov = objSearchByMov;
	}

	@Column(name = "obj_request_mov_vertics")
	public String getObjRequestMovVertics() {
		return this.objRequestMovVertics;
	}

	public void setObjRequestMovVertics(String objRequestMovVertics) {
		this.objRequestMovVertics = objRequestMovVertics;
	}

	@Column(name = "obj_request_mov_vertics_num")
	public Integer getObjRequestMovVerticsNum() {
		return this.objRequestMovVerticsNum;
	}

	public void setObjRequestMovVerticsNum(Integer objRequestMovVerticsNum) {
		this.objRequestMovVerticsNum = objRequestMovVerticsNum;
	}

}