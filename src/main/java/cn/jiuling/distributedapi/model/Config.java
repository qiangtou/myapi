package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Config entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "config")
public class Config implements java.io.Serializable {

	// Fields

	private Short idconfig;
	private String dataFolder;
	private String resultFolder;
	private String dataFileExt;
	private String resumeFileExt;
	private String bkgimgFileExt;
	private String subobjFileExt;
	private String logFileExt;
	private String sumvideoFileExt;
	private String tubeBasicInfoFileExt;
	private String dataPath;

	// Constructors

	/** default constructor */
	public Config() {
	}

	/** full constructor */
	public Config(String dataFolder, String resultFolder, String dataFileExt, String resumeFileExt, String bkgimgFileExt, String subobjFileExt,
			String logFileExt, String sumvideoFileExt, String tubeBasicInfoFileExt, String dataPath) {
		this.dataFolder = dataFolder;
		this.resultFolder = resultFolder;
		this.dataFileExt = dataFileExt;
		this.resumeFileExt = resumeFileExt;
		this.bkgimgFileExt = bkgimgFileExt;
		this.subobjFileExt = subobjFileExt;
		this.logFileExt = logFileExt;
		this.sumvideoFileExt = sumvideoFileExt;
		this.tubeBasicInfoFileExt = tubeBasicInfoFileExt;
		this.dataPath = dataPath;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idconfig", unique = true, nullable = false)
	public Short getIdconfig() {
		return this.idconfig;
	}

	public void setIdconfig(Short idconfig) {
		this.idconfig = idconfig;
	}

	@Column(name = "data_folder")
	public String getDataFolder() {
		return this.dataFolder;
	}

	public void setDataFolder(String dataFolder) {
		this.dataFolder = dataFolder;
	}

	@Column(name = "result_folder")
	public String getResultFolder() {
		return this.resultFolder;
	}

	public void setResultFolder(String resultFolder) {
		this.resultFolder = resultFolder;
	}

	@Column(name = "data_file_ext", length = 45)
	public String getDataFileExt() {
		return this.dataFileExt;
	}

	public void setDataFileExt(String dataFileExt) {
		this.dataFileExt = dataFileExt;
	}

	@Column(name = "resume_file_ext", length = 45)
	public String getResumeFileExt() {
		return this.resumeFileExt;
	}

	public void setResumeFileExt(String resumeFileExt) {
		this.resumeFileExt = resumeFileExt;
	}

	@Column(name = "bkgimg_file_ext", length = 45)
	public String getBkgimgFileExt() {
		return this.bkgimgFileExt;
	}

	public void setBkgimgFileExt(String bkgimgFileExt) {
		this.bkgimgFileExt = bkgimgFileExt;
	}

	@Column(name = "subobj_file_ext", length = 45)
	public String getSubobjFileExt() {
		return this.subobjFileExt;
	}

	public void setSubobjFileExt(String subobjFileExt) {
		this.subobjFileExt = subobjFileExt;
	}

	@Column(name = "log_file_ext", length = 45)
	public String getLogFileExt() {
		return this.logFileExt;
	}

	public void setLogFileExt(String logFileExt) {
		this.logFileExt = logFileExt;
	}

	@Column(name = "sumvideo_file_ext", length = 45)
	public String getSumvideoFileExt() {
		return this.sumvideoFileExt;
	}

	public void setSumvideoFileExt(String sumvideoFileExt) {
		this.sumvideoFileExt = sumvideoFileExt;
	}

	@Column(name = "tube_basic_info_file_ext", length = 45)
	public String getTubeBasicInfoFileExt() {
		return this.tubeBasicInfoFileExt;
	}

	public void setTubeBasicInfoFileExt(String tubeBasicInfoFileExt) {
		this.tubeBasicInfoFileExt = tubeBasicInfoFileExt;
	}

	@Column(name = "data_path")
	public String getDataPath() {
		return this.dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

}