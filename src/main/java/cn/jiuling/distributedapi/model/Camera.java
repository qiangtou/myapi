package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Camera entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_camera")
public class Camera implements java.io.Serializable {

	// Fields
	private static final Short UNDELETED = 0;
	private static final Short DELETED = 1;

	// cameratitle, cameratype, serialnumber, location,
	// direction, longitude, latitude, description, null,
	// calibration, video_type

	private Long id;
	private Long caseId;
	private String title;
	private String location;
	private Float direction;
	private Short type;
	private String serialnumber;
	private Timestamp servicetime;
	private Float longitude;
	private Float latitude;
	private String description;
	private Long ownerid;
	private Timestamp createtime;
	private Short isDeleted;
	private Integer calibration;
	private Short videoType;

	// Constructors

	/** default constructor */
	public Camera() {
	}

	/**
	 * 
	 * @param caseId
	 *            案件id
	 * @param title
	 *            摄像头名称
	 * @param type
	 *            摄像头类型
	 * @param serialnumber
	 *            摄像头编号
	 * @param location
	 *            摄像头位置
	 * @param direction
	 *            摄像头方位
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param description
	 *            摄像头描述
	 * @param createtime
	 *            创建时间
	 * @param calibration
	 *            校准因子
	 * @param videoType
	 *            视频转码类型
	 */
	public Camera(Long caseId, String title, Short type, String serialnumber, String location, Float direction, Float longitude, Float latitude,
			String description, Timestamp createtime, Integer calibration, Short videoType) {
		this.caseId = caseId;
		this.title = title;
		this.direction = direction;
		this.type = type;
		this.serialnumber = serialnumber;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
		this.createtime = createtime;
		this.calibration = calibration;
		this.videoType = videoType;

		// 一些默认设置
		this.isDeleted = UNDELETED;
		this.ownerid = Long.valueOf(0xffffffff);
		this.servicetime = new Timestamp(0L);
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

	@Column(name = "CaseID", nullable = false)
	public Long getCaseId() {
		return this.caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	@Column(name = "title", nullable = false, length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "location", nullable = false, length = 256)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "direction", precision = 12, scale = 0)
	public Float getDirection() {
		return this.direction;
	}

	public void setDirection(Float direction) {
		this.direction = direction;
	}

	@Column(name = "type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "serialnumber", nullable = false, length = 256)
	public String getSerialnumber() {
		return this.serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	@Column(name = "servicetime", nullable = false, length = 19)
	public Timestamp getServicetime() {
		return this.servicetime;
	}

	public void setServicetime(Timestamp servicetime) {
		this.servicetime = servicetime;
	}

	@Column(name = "longitude", nullable = false, precision = 12, scale = 0)
	public Float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", nullable = false, precision = 12, scale = 0)
	public Float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ownerid", nullable = false)
	public Long getOwnerid() {
		return this.ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Column(name = "is_deleted", nullable = false)
	public Short getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "calibration", nullable = false)
	public Integer getCalibration() {
		return this.calibration;
	}

	public void setCalibration(Integer calibration) {
		this.calibration = calibration;
	}

	@Column(name = "video_type", nullable = false)
	public Short getVideoType() {
		return this.videoType;
	}

	public void setVideoType(Short videoType) {
		this.videoType = videoType;
	}

}