package cn.jiuling.distributedapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Object entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "object")
public class Object implements java.io.Serializable {

	// Fields

	private Long objectId;
	private Tube tube;
	private Integer objectId_1;
	private Short objType;
	private Long startFrmIdx;
	private Long startFrmIdxRef;
	private Long startFrmPts;
	private Long endFrmIdx;
	private Long endFrmIdxRef;
	private Long endFrmPts;
	private Integer avgMotionVectorSize;
	private String avgMotionVector;
	private Float avgColorMeanB;
	private Float avgColorMeanG;
	private Float avgColorMeanR;
	private Float avgUpperBodyMeanB;
	private Float avgUpperBodyMeanG;
	private Float avgUpperBodyMeanR;
	private Float avgLowerBodyMeanB;
	private Float avgLowerBodyMeanG;
	private Float avgLowerBodyMeanR;
	private Float phyHeight;
	private String dimension3d;
	private Float scale3d;
	private Integer vehicle3dTemplate;
	private Integer vehicleType;
	private Float averageSpeed;
	private String vehicleLicensePlate;
	private Integer highestQFrmId;
	private String snapshotFilename;
	private Short snapshotWidth;
	private Short snapshotHeight;
	private Integer snapshotFrmIdx;
	private Integer snapshotFrmIdxRef;
	private Integer snapshotFrmPts;
	private Set<Objectsearchresult> objectsearchresults = new HashSet<Objectsearchresult>(0);
	private Set<Objectframe> objectframes = new HashSet<Objectframe>(0);

	// Constructors

	/** default constructor */
	public Object() {
	}

	/** minimal constructor */
	public Object(Tube tube, Integer objectId_1) {
		this.tube = tube;
		this.objectId_1 = objectId_1;
	}

	/** full constructor */
	public Object(Tube tube, Integer objectId_1, Short objType, Long startFrmIdx, Long startFrmIdxRef, Long startFrmPts, Long endFrmIdx, Long endFrmIdxRef,
			Long endFrmPts, Integer avgMotionVectorSize, String avgMotionVector, Float avgColorMeanB, Float avgColorMeanG, Float avgColorMeanR,
			Float avgUpperBodyMeanB, Float avgUpperBodyMeanG, Float avgUpperBodyMeanR, Float avgLowerBodyMeanB, Float avgLowerBodyMeanG,
			Float avgLowerBodyMeanR, Float phyHeight, String dimension3d, Float scale3d, Integer vehicle3dTemplate, Integer vehicleType, Float averageSpeed,
			String vehicleLicensePlate, Integer highestQFrmId, String snapshotFilename, Short snapshotWidth, Short snapshotHeight, Integer snapshotFrmIdx,
			Integer snapshotFrmIdxRef, Integer snapshotFrmPts, Set<Objectsearchresult> objectsearchresults, Set<Objectframe> objectframes) {
		this.tube = tube;
		this.objectId_1 = objectId_1;
		this.objType = objType;
		this.startFrmIdx = startFrmIdx;
		this.startFrmIdxRef = startFrmIdxRef;
		this.startFrmPts = startFrmPts;
		this.endFrmIdx = endFrmIdx;
		this.endFrmIdxRef = endFrmIdxRef;
		this.endFrmPts = endFrmPts;
		this.avgMotionVectorSize = avgMotionVectorSize;
		this.avgMotionVector = avgMotionVector;
		this.avgColorMeanB = avgColorMeanB;
		this.avgColorMeanG = avgColorMeanG;
		this.avgColorMeanR = avgColorMeanR;
		this.avgUpperBodyMeanB = avgUpperBodyMeanB;
		this.avgUpperBodyMeanG = avgUpperBodyMeanG;
		this.avgUpperBodyMeanR = avgUpperBodyMeanR;
		this.avgLowerBodyMeanB = avgLowerBodyMeanB;
		this.avgLowerBodyMeanG = avgLowerBodyMeanG;
		this.avgLowerBodyMeanR = avgLowerBodyMeanR;
		this.phyHeight = phyHeight;
		this.dimension3d = dimension3d;
		this.scale3d = scale3d;
		this.vehicle3dTemplate = vehicle3dTemplate;
		this.vehicleType = vehicleType;
		this.averageSpeed = averageSpeed;
		this.vehicleLicensePlate = vehicleLicensePlate;
		this.highestQFrmId = highestQFrmId;
		this.snapshotFilename = snapshotFilename;
		this.snapshotWidth = snapshotWidth;
		this.snapshotHeight = snapshotHeight;
		this.snapshotFrmIdx = snapshotFrmIdx;
		this.snapshotFrmIdxRef = snapshotFrmIdxRef;
		this.snapshotFrmPts = snapshotFrmPts;
		this.objectsearchresults = objectsearchresults;
		this.objectframes = objectframes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ObjectID", unique = true, nullable = false)
	public Long getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TubeID", nullable = false)
	public Tube getTube() {
		return this.tube;
	}

	public void setTube(Tube tube) {
		this.tube = tube;
	}

	@Column(name = "object_id", nullable = false)
	public Integer getObjectId_1() {
		return this.objectId_1;
	}

	public void setObjectId_1(Integer objectId_1) {
		this.objectId_1 = objectId_1;
	}

	@Column(name = "obj_type")
	public Short getObjType() {
		return this.objType;
	}

	public void setObjType(Short objType) {
		this.objType = objType;
	}

	@Column(name = "start_frm_idx")
	public Long getStartFrmIdx() {
		return this.startFrmIdx;
	}

	public void setStartFrmIdx(Long startFrmIdx) {
		this.startFrmIdx = startFrmIdx;
	}

	@Column(name = "start_frm_idx_ref")
	public Long getStartFrmIdxRef() {
		return this.startFrmIdxRef;
	}

	public void setStartFrmIdxRef(Long startFrmIdxRef) {
		this.startFrmIdxRef = startFrmIdxRef;
	}

	@Column(name = "start_frm_pts")
	public Long getStartFrmPts() {
		return this.startFrmPts;
	}

	public void setStartFrmPts(Long startFrmPts) {
		this.startFrmPts = startFrmPts;
	}

	@Column(name = "end_frm_idx")
	public Long getEndFrmIdx() {
		return this.endFrmIdx;
	}

	public void setEndFrmIdx(Long endFrmIdx) {
		this.endFrmIdx = endFrmIdx;
	}

	@Column(name = "end_frm_idx_ref")
	public Long getEndFrmIdxRef() {
		return this.endFrmIdxRef;
	}

	public void setEndFrmIdxRef(Long endFrmIdxRef) {
		this.endFrmIdxRef = endFrmIdxRef;
	}

	@Column(name = "end_frm_pts")
	public Long getEndFrmPts() {
		return this.endFrmPts;
	}

	public void setEndFrmPts(Long endFrmPts) {
		this.endFrmPts = endFrmPts;
	}

	@Column(name = "avg_motion_vector_size")
	public Integer getAvgMotionVectorSize() {
		return this.avgMotionVectorSize;
	}

	public void setAvgMotionVectorSize(Integer avgMotionVectorSize) {
		this.avgMotionVectorSize = avgMotionVectorSize;
	}

	@Column(name = "avg_motion_vector")
	public String getAvgMotionVector() {
		return this.avgMotionVector;
	}

	public void setAvgMotionVector(String avgMotionVector) {
		this.avgMotionVector = avgMotionVector;
	}

	@Column(name = "avg_color_mean_B", precision = 12, scale = 0)
	public Float getAvgColorMeanB() {
		return this.avgColorMeanB;
	}

	public void setAvgColorMeanB(Float avgColorMeanB) {
		this.avgColorMeanB = avgColorMeanB;
	}

	@Column(name = "avg_color_mean_G", precision = 12, scale = 0)
	public Float getAvgColorMeanG() {
		return this.avgColorMeanG;
	}

	public void setAvgColorMeanG(Float avgColorMeanG) {
		this.avgColorMeanG = avgColorMeanG;
	}

	@Column(name = "avg_color_mean_R", precision = 12, scale = 0)
	public Float getAvgColorMeanR() {
		return this.avgColorMeanR;
	}

	public void setAvgColorMeanR(Float avgColorMeanR) {
		this.avgColorMeanR = avgColorMeanR;
	}

	@Column(name = "avg_upper_body_mean_B", precision = 12, scale = 0)
	public Float getAvgUpperBodyMeanB() {
		return this.avgUpperBodyMeanB;
	}

	public void setAvgUpperBodyMeanB(Float avgUpperBodyMeanB) {
		this.avgUpperBodyMeanB = avgUpperBodyMeanB;
	}

	@Column(name = "avg_upper_body_mean_G", precision = 12, scale = 0)
	public Float getAvgUpperBodyMeanG() {
		return this.avgUpperBodyMeanG;
	}

	public void setAvgUpperBodyMeanG(Float avgUpperBodyMeanG) {
		this.avgUpperBodyMeanG = avgUpperBodyMeanG;
	}

	@Column(name = "avg_upper_body_mean_R", precision = 12, scale = 0)
	public Float getAvgUpperBodyMeanR() {
		return this.avgUpperBodyMeanR;
	}

	public void setAvgUpperBodyMeanR(Float avgUpperBodyMeanR) {
		this.avgUpperBodyMeanR = avgUpperBodyMeanR;
	}

	@Column(name = "avg_lower_body_mean_B", precision = 12, scale = 0)
	public Float getAvgLowerBodyMeanB() {
		return this.avgLowerBodyMeanB;
	}

	public void setAvgLowerBodyMeanB(Float avgLowerBodyMeanB) {
		this.avgLowerBodyMeanB = avgLowerBodyMeanB;
	}

	@Column(name = "avg_lower_body_mean_G", precision = 12, scale = 0)
	public Float getAvgLowerBodyMeanG() {
		return this.avgLowerBodyMeanG;
	}

	public void setAvgLowerBodyMeanG(Float avgLowerBodyMeanG) {
		this.avgLowerBodyMeanG = avgLowerBodyMeanG;
	}

	@Column(name = "avg_lower_body_mean_R", precision = 12, scale = 0)
	public Float getAvgLowerBodyMeanR() {
		return this.avgLowerBodyMeanR;
	}

	public void setAvgLowerBodyMeanR(Float avgLowerBodyMeanR) {
		this.avgLowerBodyMeanR = avgLowerBodyMeanR;
	}

	@Column(name = "phy_height", precision = 12, scale = 0)
	public Float getPhyHeight() {
		return this.phyHeight;
	}

	public void setPhyHeight(Float phyHeight) {
		this.phyHeight = phyHeight;
	}

	@Column(name = "dimension_3D")
	public String getDimension3d() {
		return this.dimension3d;
	}

	public void setDimension3d(String dimension3d) {
		this.dimension3d = dimension3d;
	}

	@Column(name = "scale_3D", precision = 12, scale = 0)
	public Float getScale3d() {
		return this.scale3d;
	}

	public void setScale3d(Float scale3d) {
		this.scale3d = scale3d;
	}

	@Column(name = "vehicle_3D_template")
	public Integer getVehicle3dTemplate() {
		return this.vehicle3dTemplate;
	}

	public void setVehicle3dTemplate(Integer vehicle3dTemplate) {
		this.vehicle3dTemplate = vehicle3dTemplate;
	}

	@Column(name = "vehicle_type")
	public Integer getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(Integer vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Column(name = "average_speed", precision = 12, scale = 0)
	public Float getAverageSpeed() {
		return this.averageSpeed;
	}

	public void setAverageSpeed(Float averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	@Column(name = "vehicle_license_plate", length = 32)
	public String getVehicleLicensePlate() {
		return this.vehicleLicensePlate;
	}

	public void setVehicleLicensePlate(String vehicleLicensePlate) {
		this.vehicleLicensePlate = vehicleLicensePlate;
	}

	@Column(name = "highest_q_frm_id")
	public Integer getHighestQFrmId() {
		return this.highestQFrmId;
	}

	public void setHighestQFrmId(Integer highestQFrmId) {
		this.highestQFrmId = highestQFrmId;
	}

	@Column(name = "snapshot_filename")
	public String getSnapshotFilename() {
		return this.snapshotFilename;
	}

	public void setSnapshotFilename(String snapshotFilename) {
		this.snapshotFilename = snapshotFilename;
	}

	@Column(name = "snapshot_width")
	public Short getSnapshotWidth() {
		return this.snapshotWidth;
	}

	public void setSnapshotWidth(Short snapshotWidth) {
		this.snapshotWidth = snapshotWidth;
	}

	@Column(name = "snapshot_height")
	public Short getSnapshotHeight() {
		return this.snapshotHeight;
	}

	public void setSnapshotHeight(Short snapshotHeight) {
		this.snapshotHeight = snapshotHeight;
	}

	@Column(name = "snapshot_frm_idx")
	public Integer getSnapshotFrmIdx() {
		return this.snapshotFrmIdx;
	}

	public void setSnapshotFrmIdx(Integer snapshotFrmIdx) {
		this.snapshotFrmIdx = snapshotFrmIdx;
	}

	@Column(name = "snapshot_frm_idx_ref")
	public Integer getSnapshotFrmIdxRef() {
		return this.snapshotFrmIdxRef;
	}

	public void setSnapshotFrmIdxRef(Integer snapshotFrmIdxRef) {
		this.snapshotFrmIdxRef = snapshotFrmIdxRef;
	}

	@Column(name = "snapshot_frm_pts")
	public Integer getSnapshotFrmPts() {
		return this.snapshotFrmPts;
	}

	public void setSnapshotFrmPts(Integer snapshotFrmPts) {
		this.snapshotFrmPts = snapshotFrmPts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "object")
	public Set<Objectsearchresult> getObjectsearchresults() {
		return this.objectsearchresults;
	}

	public void setObjectsearchresults(Set<Objectsearchresult> objectsearchresults) {
		this.objectsearchresults = objectsearchresults;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "object")
	public Set<Objectframe> getObjectframes() {
		return this.objectframes;
	}

	public void setObjectframes(Set<Objectframe> objectframes) {
		this.objectframes = objectframes;
	}

}