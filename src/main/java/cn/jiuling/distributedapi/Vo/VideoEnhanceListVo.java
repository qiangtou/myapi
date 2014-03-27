package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.util.StringUtils;

public class VideoEnhanceListVo {

	/*<id>13</id>
	<casetitle>1</casetitle>
	<cameratitle>1</cameratitle>
	<srcName>D:\VideoInvestigation\VIServer\DAT\AstVS_1v2\orgvideos\1\1\3(2).avi</srcName>
	<destName>D:\VideoInvestigation\VIServer\DAT\AstVS_1v2\orgvideos\1\1\3(2).avi</destName>
	<status>0</status>
	<progress>0</progress>
	<createTime>2012-12-12 12:12:12</createTime>
	<density>0.2</density>
	<priority>1</priority>*/
	/*e.taskId,c.title,m.title,e.sourceUrl,e.resultPath,   " +
	"e.stateFlag,e.progress,e.density,e.priority
	*/
	private Long id;
	private String casetitle;
	private String cameratitle;
	private String srcName;
	private String destName;
	private Long status;
	private Short progress;
	private Timestamp createTime;
	private Float density;
	private Short priority;

	public VideoEnhanceListVo(Long id, String casetitle, String cameratitle, String srcName, String destName, Long status, Short progress,
			Date createTime, Float density, Short priority) {
		super();

		if (StringUtils.isEmpty(destName)) {
			destName = srcName;
		}
		this.id = id;
		this.casetitle = casetitle;
		this.cameratitle = cameratitle;
		this.srcName = srcName;
		this.destName = destName;
		this.status = status;
		this.progress = progress;
		this.createTime = createTime != null ? new Timestamp(createTime.getTime()) : null;
		this.density = density;
		this.priority = priority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCasetitle() {
		return casetitle;
	}

	public void setCasetitle(String casetitle) {
		this.casetitle = casetitle;
	}

	public String getCameratitle() {
		return cameratitle;
	}

	public void setCameratitle(String cameratitle) {
		this.cameratitle = cameratitle;
	}

	public String getSrcName() {
		return srcName;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
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

}
