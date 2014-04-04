package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VlprTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vlpr_task")
public class VlprTask implements java.io.Serializable {

	// Fields

	private Long taskId;
	private String filePath;
	private Short progress;
	private Long videoid;
	private Short status;
	private Short taskFlag;
	private Timestamp createtime;
	private String vlrpnumber;
	private String plateColor;
	private String belongPlace;

	// Constructors

	/** default constructor */
	public VlprTask() {
	}

	/** minimal constructor */
	public VlprTask(String filePath, Short progress, Long videoid, Short status, Short taskFlag, Timestamp createtime) {
		this.filePath = filePath;
		this.progress = progress;
		this.videoid = videoid;
		this.status = status;
		this.taskFlag = taskFlag;
		this.createtime = createtime;
	}

	/** full constructor */
	public VlprTask(String filePath, Short progress, Long videoid, Short status, Short taskFlag, Timestamp createtime, String vlrpnumber, String plateColor,
			String belongPlace) {
		this.filePath = filePath;
		this.progress = progress;
		this.videoid = videoid;
		this.status = status;
		this.taskFlag = taskFlag;
		this.createtime = createtime;
		this.vlrpnumber = vlrpnumber;
		this.plateColor = plateColor;
		this.belongPlace = belongPlace;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaskID", unique = true, nullable = false)
	public Long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	@Column(name = "filePath", nullable = false, length = 1024)
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "progress", nullable = false)
	public Short getProgress() {
		return this.progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	@Column(name = "videoid", nullable = false)
	public Long getVideoid() {
		return this.videoid;
	}

	public void setVideoid(Long videoid) {
		this.videoid = videoid;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "task_flag", nullable = false)
	public Short getTaskFlag() {
		return this.taskFlag;
	}

	public void setTaskFlag(Short taskFlag) {
		this.taskFlag = taskFlag;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Column(name = "vlrpnumber", length = 32)
	public String getVlrpnumber() {
		return this.vlrpnumber;
	}

	public void setVlrpnumber(String vlrpnumber) {
		this.vlrpnumber = vlrpnumber;
	}

	@Column(name = "PlateColor", length = 32)
	public String getPlateColor() {
		return this.plateColor;
	}

	public void setPlateColor(String plateColor) {
		this.plateColor = plateColor;
	}

	@Column(name = "belongPlace", length = 32)
	public String getBelongPlace() {
		return this.belongPlace;
	}

	public void setBelongPlace(String belongPlace) {
		this.belongPlace = belongPlace;
	}

}