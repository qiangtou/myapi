package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AstTblEnhanceTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ast_tbl_enhance_task")
public class EnhanceTask implements java.io.Serializable {

	// Fields

	private Long taskId;
	private String enhanceType;
	private Long stateFlag;
	private Short progress;
	private String sourceUrl;
	private Float density;
	private Integer iwidth;
	private Integer iheight;
	private Short iwtdering;
	private Short iwtdenoise;
	private Short iuseGpu;
	private Timestamp createTime;
	private Short priority;
	private String resultPath;
	private String resultUrl;
	private Long videoid;
	private Short srcType;

	// Constructors

	/** default constructor */
	public EnhanceTask() {
	}

	/** minimal constructor */
	public EnhanceTask(Float density, Timestamp createTime) {
		this.density = density;
		this.createTime = createTime;
	}

	/** full constructor */
	public EnhanceTask(String enhanceType, Long stateFlag, Short progress, String sourceUrl, Float density, Integer iwidth, Integer iheight,
			Short iwtdering, Short iwtdenoise, Short iuseGpu, Timestamp createTime, Short priority, String resultPath, String resultUrl, Long videoid,
			Short srcType) {
		this.enhanceType = enhanceType;
		this.stateFlag = stateFlag;
		this.progress = progress;
		this.sourceUrl = sourceUrl;
		this.density = density;
		this.iwidth = iwidth;
		this.iheight = iheight;
		this.iwtdering = iwtdering;
		this.iwtdenoise = iwtdenoise;
		this.iuseGpu = iuseGpu;
		this.createTime = createTime;
		this.priority = priority;
		this.resultPath = resultPath;
		this.resultUrl = resultUrl;
		this.videoid = videoid;
		this.srcType = srcType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taskID", unique = true, nullable = false)
	public Long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	@Column(name = "enhanceType", length = 256)
	public String getEnhanceType() {
		return this.enhanceType;
	}

	public void setEnhanceType(String enhanceType) {
		this.enhanceType = enhanceType;
	}

	@Column(name = "stateFlag")
	public Long getStateFlag() {
		return this.stateFlag;
	}

	public void setStateFlag(Long stateFlag) {
		this.stateFlag = stateFlag;
	}

	@Column(name = "progress")
	public Short getProgress() {
		return this.progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	@Column(name = "sourceUrl", length = 256)
	public String getSourceUrl() {
		return this.sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	@Column(name = "density", nullable = false, precision = 12, scale = 0)
	public Float getDensity() {
		return this.density;
	}

	public void setDensity(Float density) {
		this.density = density;
	}

	@Column(name = "iWidth")
	public Integer getIwidth() {
		return this.iwidth;
	}

	public void setIwidth(Integer iwidth) {
		this.iwidth = iwidth;
	}

	@Column(name = "iHeight")
	public Integer getIheight() {
		return this.iheight;
	}

	public void setIheight(Integer iheight) {
		this.iheight = iheight;
	}

	@Column(name = "iWTDering")
	public Short getIwtdering() {
		return this.iwtdering;
	}

	public void setIwtdering(Short iwtdering) {
		this.iwtdering = iwtdering;
	}

	@Column(name = "iWTDenoise")
	public Short getIwtdenoise() {
		return this.iwtdenoise;
	}

	public void setIwtdenoise(Short iwtdenoise) {
		this.iwtdenoise = iwtdenoise;
	}

	@Column(name = "iUseGPU")
	public Short getIuseGpu() {
		return this.iuseGpu;
	}

	public void setIuseGpu(Short iuseGpu) {
		this.iuseGpu = iuseGpu;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "priority")
	public Short getPriority() {
		return this.priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	@Column(name = "resultPath", length = 256)
	public String getResultPath() {
		return this.resultPath;
	}

	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}

	@Column(name = "resultUrl", length = 256)
	public String getResultUrl() {
		return this.resultUrl;
	}

	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}

	@Column(name = "videoid")
	public Long getVideoid() {
		return this.videoid;
	}

	public void setVideoid(Long videoid) {
		this.videoid = videoid;
	}

	@Column(name = "srcType")
	public Short getSrcType() {
		return this.srcType;
	}

	public void setSrcType(Short srcType) {
		this.srcType = srcType;
	}

}