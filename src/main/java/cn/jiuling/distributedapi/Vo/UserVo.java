package cn.jiuling.distributedapi.Vo;

public class UserVo {
	private Integer id;
	private String name;
	private String fullname;
	private Integer groupid;

	public UserVo(Integer id, String name, String fullname, Integer groupid) {
		super();
		this.id = id;
		this.name = name;
		this.fullname = fullname;
		this.groupid = groupid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

}
