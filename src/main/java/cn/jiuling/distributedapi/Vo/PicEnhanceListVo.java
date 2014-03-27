package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.util.StringUtils;

public class PicEnhanceListVo {
	/*<id>7</id>
	   <status>0</status>
	   <progress>0</progress>
	    <enhance_type>1</enhance_type>
	    <iWidth>0</iWidth>
	    <iHeight>0</iHeight>
	    <iWTDering>0</iWTDering>
	    <iWTDenoise>0</iWTDenoise>
	    <iUseGPU>0</iUseGPU>
	    <createTime>2012-12-12 12:12:12</createTime>
	    <density>0.2</density>
	    <priority>1</priority>
	    <resultPath>D:\VideoInvestigation\VIServer
	       \DAT\AstVS_1v2\orgpics\1(1).jpg</resultPath>
	    <resultUrl>orgpics\1(1).jpg</resultUrl>
	<orgUrl>orgpics\1(1).jpg</orgUrl>
	<orgPath>orgpics\1(1).jpg</orgPath>*/

	private Long id;
	private Long status;
	private Short progress;
	private Integer iWidth;
	private Integer iHeight;
	private Short iWTDering;
	private Short iWTDenoise;
	private Short iUseGPU;
	private Timestamp createTime;
	private Float density;
	private Short priority;
	private String resultPath;
	private String resultUrl;
	private String orgUrl;
	private String orgPath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Short getProgress() {
		return progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	public Integer getiWidth() {
		return iWidth;
	}

	public void setiWidth(Integer iWidth) {
		this.iWidth = iWidth;
	}

	public Integer getiHeight() {
		return iHeight;
	}

	public void setiHeight(Integer iHeight) {
		this.iHeight = iHeight;
	}

	public Short getiWTDering() {
		return iWTDering;
	}

	public void setiWTDering(Short iWTDering) {
		this.iWTDering = iWTDering;
	}

	public Short getiWTDenoise() {
		return iWTDenoise;
	}

	public void setiWTDenoise(Short iWTDenoise) {
		this.iWTDenoise = iWTDenoise;
	}

	public Short getiUseGPU() {
		return iUseGPU;
	}

	public void setiUseGPU(Short iUseGPU) {
		this.iUseGPU = iUseGPU;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Float getDensity() {
		return density;
	}

	public void setDensity(Float density) {
		this.density = density;
	}

	public Short getPriority() {
		return priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	public String getResultPath() {
		return resultPath;
	}

	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}

	public String getResultUrl() {
		return resultUrl;
	}

	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}

	public String getOrgUrl() {
		return orgUrl;
	}

	public void setOrgUrl(String orgUrl) {
		this.orgUrl = orgUrl;
	}

	public String getOrgPath() {
		return orgPath;
	}

	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}

	public PicEnhanceListVo(Long id, Long status, Short progress, Integer iWidth, Integer iHeight, Short iWTDering, Short iWTDenoise, Short iUseGPU,
			Date createTime, Float density, Short priority, String sourceUrl, String resultUrl, String resultPath, String dataPath) {
		super();
		this.id = id;
		this.status = status;
		this.progress = progress;
		this.iWidth = iWidth;
		this.iHeight = iHeight;
		this.iWTDering = iWTDering;
		this.iWTDenoise = iWTDenoise;
		this.iUseGPU = iUseGPU;
		this.createTime = createTime != null ? new Timestamp(createTime.getTime()) : null;
		this.density = density;
		this.priority = priority;
		/*	resultPath:	IF(CHAR_LENGTH(d.resultPath)!=0,d.resultPath,d.sourceUrl), 
			resultUrl:	IF(CHAR_LENGTH(d.resultUrl)!=0,RIGHT(d.resultUrl, CHAR_LENGTH(d.resultUrl)-2),RIGHT(sourceUrl, CHAR_LENGTH(sourceUrl)- CHAR_LENGTH(data_path)-11)),
			orgPath:	sourceUrl,
			orgUrl:	RIGHT(sourceUrl, CHAR_LENGTH(sourceUrl)- CHAR_LENGTH(data_path)-11)*/

		this.resultPath = StringUtils.isEmpty(resultPath) ? sourceUrl : resultPath;
		this.orgUrl = sourceUrl;

		// 下面的和datapath相关的
		int dataPathIndex = dataPath.length() + 11;
		String _orgPath;
		String _resultUrl;
		if (StringUtils.isEmpty(resultUrl)) {
			_resultUrl = getUrl(sourceUrl, dataPathIndex);
		} else {
			_resultUrl = resultUrl.substring(2);
		}
		this.resultUrl = _resultUrl;
		_orgPath = getUrl(sourceUrl, dataPathIndex);
		this.orgPath = _orgPath;
	}

	private String getUrl(String sourceUrl, int dataPathIndex) {
		return sourceUrl.length() > dataPathIndex ? sourceUrl.substring(dataPathIndex) : sourceUrl;
	}
}
