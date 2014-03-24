package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Objectframe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "objectframe")
public class Objectframe implements java.io.Serializable {

	// Fields

	private Long objFrmId;
	private Object object;
	private Long objFrameIdx;
	private Long objFrameIdxRef;
	private Long objFramePts;
	private Integer componentId;
	private Short objBbUlX;
	private Short objBbUlY;
	private Short objBbWidth;
	private Short objBbHeight;
	private Float hogScore;
	private Float overallColorMeanB;
	private Float overallColorMeanG;
	private Float overallColorMeanR;
	private Float humanUpperBodyColorMeanB;
	private Float humanUpperBodyColorMeanG;
	private Float humanUpperBodyColorMeanR;
	private Float humanLowerBodyColorMeanB;
	private Float humanLowerBodyColorMeanG;
	private Float humanLowerBodyColorMeanR;
	private Float vehicleCurrentSpeed;
	private Float faceQualityMeasurement;
	private Integer motionVectorSize;
	private String motionVector;
	private String shapeLabel;
	private Integer shapeLabelSize;
	private String appLabel;
	private Integer appLabelSize;

	// Constructors

	/** default constructor */
	public Objectframe() {
	}

	/** minimal constructor */
	public Objectframe(Object object, Long objFrameIdx) {
		this.object = object;
		this.objFrameIdx = objFrameIdx;
	}

	/** full constructor */
	public Objectframe(Object object, Long objFrameIdx, Long objFrameIdxRef, Long objFramePts, Integer componentId, Short objBbUlX, Short objBbUlY,
			Short objBbWidth, Short objBbHeight, Float hogScore, Float overallColorMeanB, Float overallColorMeanG, Float overallColorMeanR,
			Float humanUpperBodyColorMeanB, Float humanUpperBodyColorMeanG, Float humanUpperBodyColorMeanR, Float humanLowerBodyColorMeanB,
			Float humanLowerBodyColorMeanG, Float humanLowerBodyColorMeanR, Float vehicleCurrentSpeed, Float faceQualityMeasurement, Integer motionVectorSize,
			String motionVector, String shapeLabel, Integer shapeLabelSize, String appLabel, Integer appLabelSize) {
		this.object = object;
		this.objFrameIdx = objFrameIdx;
		this.objFrameIdxRef = objFrameIdxRef;
		this.objFramePts = objFramePts;
		this.componentId = componentId;
		this.objBbUlX = objBbUlX;
		this.objBbUlY = objBbUlY;
		this.objBbWidth = objBbWidth;
		this.objBbHeight = objBbHeight;
		this.hogScore = hogScore;
		this.overallColorMeanB = overallColorMeanB;
		this.overallColorMeanG = overallColorMeanG;
		this.overallColorMeanR = overallColorMeanR;
		this.humanUpperBodyColorMeanB = humanUpperBodyColorMeanB;
		this.humanUpperBodyColorMeanG = humanUpperBodyColorMeanG;
		this.humanUpperBodyColorMeanR = humanUpperBodyColorMeanR;
		this.humanLowerBodyColorMeanB = humanLowerBodyColorMeanB;
		this.humanLowerBodyColorMeanG = humanLowerBodyColorMeanG;
		this.humanLowerBodyColorMeanR = humanLowerBodyColorMeanR;
		this.vehicleCurrentSpeed = vehicleCurrentSpeed;
		this.faceQualityMeasurement = faceQualityMeasurement;
		this.motionVectorSize = motionVectorSize;
		this.motionVector = motionVector;
		this.shapeLabel = shapeLabel;
		this.shapeLabelSize = shapeLabelSize;
		this.appLabel = appLabel;
		this.appLabelSize = appLabelSize;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ObjFrmID", unique = true, nullable = false)
	public Long getObjFrmId() {
		return this.objFrmId;
	}

	public void setObjFrmId(Long objFrmId) {
		this.objFrmId = objFrmId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ObjectID", nullable = false)
	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Column(name = "objFrame_idx", nullable = false)
	public Long getObjFrameIdx() {
		return this.objFrameIdx;
	}

	public void setObjFrameIdx(Long objFrameIdx) {
		this.objFrameIdx = objFrameIdx;
	}

	@Column(name = "objFrame_idx_ref")
	public Long getObjFrameIdxRef() {
		return this.objFrameIdxRef;
	}

	public void setObjFrameIdxRef(Long objFrameIdxRef) {
		this.objFrameIdxRef = objFrameIdxRef;
	}

	@Column(name = "objFrame_pts")
	public Long getObjFramePts() {
		return this.objFramePts;
	}

	public void setObjFramePts(Long objFramePts) {
		this.objFramePts = objFramePts;
	}

	@Column(name = "component_id")
	public Integer getComponentId() {
		return this.componentId;
	}

	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}

	@Column(name = "obj_bb_ul_x")
	public Short getObjBbUlX() {
		return this.objBbUlX;
	}

	public void setObjBbUlX(Short objBbUlX) {
		this.objBbUlX = objBbUlX;
	}

	@Column(name = "obj_bb_ul_y")
	public Short getObjBbUlY() {
		return this.objBbUlY;
	}

	public void setObjBbUlY(Short objBbUlY) {
		this.objBbUlY = objBbUlY;
	}

	@Column(name = "obj_bb_width")
	public Short getObjBbWidth() {
		return this.objBbWidth;
	}

	public void setObjBbWidth(Short objBbWidth) {
		this.objBbWidth = objBbWidth;
	}

	@Column(name = "obj_bb_height")
	public Short getObjBbHeight() {
		return this.objBbHeight;
	}

	public void setObjBbHeight(Short objBbHeight) {
		this.objBbHeight = objBbHeight;
	}

	@Column(name = "hog_score", precision = 12, scale = 0)
	public Float getHogScore() {
		return this.hogScore;
	}

	public void setHogScore(Float hogScore) {
		this.hogScore = hogScore;
	}

	@Column(name = "overall_color_mean_B", precision = 12, scale = 0)
	public Float getOverallColorMeanB() {
		return this.overallColorMeanB;
	}

	public void setOverallColorMeanB(Float overallColorMeanB) {
		this.overallColorMeanB = overallColorMeanB;
	}

	@Column(name = "overall_color_mean_G", precision = 12, scale = 0)
	public Float getOverallColorMeanG() {
		return this.overallColorMeanG;
	}

	public void setOverallColorMeanG(Float overallColorMeanG) {
		this.overallColorMeanG = overallColorMeanG;
	}

	@Column(name = "overall_color_mean_R", precision = 12, scale = 0)
	public Float getOverallColorMeanR() {
		return this.overallColorMeanR;
	}

	public void setOverallColorMeanR(Float overallColorMeanR) {
		this.overallColorMeanR = overallColorMeanR;
	}

	@Column(name = "human_upper_body_color_mean_B", precision = 12, scale = 0)
	public Float getHumanUpperBodyColorMeanB() {
		return this.humanUpperBodyColorMeanB;
	}

	public void setHumanUpperBodyColorMeanB(Float humanUpperBodyColorMeanB) {
		this.humanUpperBodyColorMeanB = humanUpperBodyColorMeanB;
	}

	@Column(name = "human_upper_body_color_mean_G", precision = 12, scale = 0)
	public Float getHumanUpperBodyColorMeanG() {
		return this.humanUpperBodyColorMeanG;
	}

	public void setHumanUpperBodyColorMeanG(Float humanUpperBodyColorMeanG) {
		this.humanUpperBodyColorMeanG = humanUpperBodyColorMeanG;
	}

	@Column(name = "human_upper_body_color_mean_R", precision = 12, scale = 0)
	public Float getHumanUpperBodyColorMeanR() {
		return this.humanUpperBodyColorMeanR;
	}

	public void setHumanUpperBodyColorMeanR(Float humanUpperBodyColorMeanR) {
		this.humanUpperBodyColorMeanR = humanUpperBodyColorMeanR;
	}

	@Column(name = "human_lower_body_color_mean_B", precision = 12, scale = 0)
	public Float getHumanLowerBodyColorMeanB() {
		return this.humanLowerBodyColorMeanB;
	}

	public void setHumanLowerBodyColorMeanB(Float humanLowerBodyColorMeanB) {
		this.humanLowerBodyColorMeanB = humanLowerBodyColorMeanB;
	}

	@Column(name = "human_lower_body_color_mean_G", precision = 12, scale = 0)
	public Float getHumanLowerBodyColorMeanG() {
		return this.humanLowerBodyColorMeanG;
	}

	public void setHumanLowerBodyColorMeanG(Float humanLowerBodyColorMeanG) {
		this.humanLowerBodyColorMeanG = humanLowerBodyColorMeanG;
	}

	@Column(name = "human_lower_body_color_mean_R", precision = 12, scale = 0)
	public Float getHumanLowerBodyColorMeanR() {
		return this.humanLowerBodyColorMeanR;
	}

	public void setHumanLowerBodyColorMeanR(Float humanLowerBodyColorMeanR) {
		this.humanLowerBodyColorMeanR = humanLowerBodyColorMeanR;
	}

	@Column(name = "vehicle_current_speed", precision = 12, scale = 0)
	public Float getVehicleCurrentSpeed() {
		return this.vehicleCurrentSpeed;
	}

	public void setVehicleCurrentSpeed(Float vehicleCurrentSpeed) {
		this.vehicleCurrentSpeed = vehicleCurrentSpeed;
	}

	@Column(name = "face_quality_measurement", precision = 12, scale = 0)
	public Float getFaceQualityMeasurement() {
		return this.faceQualityMeasurement;
	}

	public void setFaceQualityMeasurement(Float faceQualityMeasurement) {
		this.faceQualityMeasurement = faceQualityMeasurement;
	}

	@Column(name = "motion_vector_size")
	public Integer getMotionVectorSize() {
		return this.motionVectorSize;
	}

	public void setMotionVectorSize(Integer motionVectorSize) {
		this.motionVectorSize = motionVectorSize;
	}

	@Column(name = "motion_vector")
	public String getMotionVector() {
		return this.motionVector;
	}

	public void setMotionVector(String motionVector) {
		this.motionVector = motionVector;
	}

	@Column(name = "shape_label")
	public String getShapeLabel() {
		return this.shapeLabel;
	}

	public void setShapeLabel(String shapeLabel) {
		this.shapeLabel = shapeLabel;
	}

	@Column(name = "shape_label_size")
	public Integer getShapeLabelSize() {
		return this.shapeLabelSize;
	}

	public void setShapeLabelSize(Integer shapeLabelSize) {
		this.shapeLabelSize = shapeLabelSize;
	}

	@Column(name = "app_label")
	public String getAppLabel() {
		return this.appLabel;
	}

	public void setAppLabel(String appLabel) {
		this.appLabel = appLabel;
	}

	@Column(name = "app_label_size")
	public Integer getAppLabelSize() {
		return this.appLabelSize;
	}

	public void setAppLabelSize(Integer appLabelSize) {
		this.appLabelSize = appLabelSize;
	}

}