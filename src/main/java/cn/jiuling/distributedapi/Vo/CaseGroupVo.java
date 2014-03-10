package cn.jiuling.distributedapi.Vo;

public class CaseGroupVo {
	private Long groupid;
	private String grouptitle;
	private String desc;
	private Long creator;

	public CaseGroupVo(Long groupid, String grouptitle, String desc, Long creator) {
		super();
		this.groupid = groupid;
		this.grouptitle = grouptitle;
		this.desc = desc;
		this.creator = creator;
	}

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public String getGrouptitle() {
		return grouptitle;
	}

	public void setGrouptitle(String grouptitle) {
		this.grouptitle = grouptitle;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

}
