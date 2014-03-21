package cn.jiuling.distributedapi.Vo;

public enum Status {
	LOGIN_SUCCESS("login success!!"),
	LOGIN_FAIL(1001, "login fail!!"),
	LOGOUT_SUCCESS("LOGOUT_SUCCESS"),
	PARAMETER_ERROR(1003, "parameter_error!!"),
	SERVER_ERROR(500, "server error!!"),

	GROUPID_IS_EMPTY(1002, "groupid is empty!!"),
	NAME_ERROR(1002, "name is empty or length larger than 250!!"),

	ADD_SUCCESS("add success!!"),
	DEL_SUCCESS("delete success!!"),
	MODIFY_SUCCESS("modify_success!!"),
	QUERY_SUCCESS("query_success!!"),
	SEARCH_SUCCESS("SEARCH_SUCCESS!!"),

	ADD_ERROR(1010, "add error!!"),
	DEL_ERROR(1011, "delete error!!"),
	MODIFY_ERROR(1012, "modify_error!!"),
	QUERY_ERROR(1013, "query_error!!"),

	CREATOR_IS_NULL(1021, "CREATOR_IS_NULL"),
	DISK_SPACE_IS_NOT_ENOUGHT(1022, "disk space is not enought"),
	FILE_NOT_EXIST(1023, "FILE_NOT_EXIST"),
	OBJECT_IS_NOT_EXIST(9901, "OBJECT_IS_NOT_EXIST");

	private Integer code;
	private String desc;

	private Status(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private Status(String desc) {
		this.code = 0;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
