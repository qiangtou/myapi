package cn.jiuling.distributedapi.Vo;

public enum Status {
	LOGIN_SUCCESS("login success!!"),
	LOGIN_FAIL(1001, "login fail!!"),
	LOGOUT_SUCCESS("LOGOUT_SUCCESS"),
	PARAMETER_ERROR(1003, "parameter_error!!"),
	SERVER_ERROR(500, "server error!!"),

	GROUPID_IS_EMPTY(1002, "groupid is empty!!"),
	NAME_ERROR(1002, "name is empty or length larger than 250!!"),

	USERGROUP_ADD_SUCCESS("add user group success!!"),
	USERGROUP_DEL_SUCCESS("delete user group success!!"),
	USERGROUP_MODIFY_SUCCESS("modify_usergroup_success!!"),
	USERGROUP_QUERY_SUCCESS("query_usergroup_success!!"),

	USERGROUP_ADD_ERROR(1010, "add user group error!!"),
	USERGROUP_DEL_ERROR(1011, "delete user group error!!"),
	USERGROUP_MODIFY_ERROR(1012, "modify_usergroup_error!!"),
	USERGROUP_QUERY_ERROR(1013, "query_usergroup_error!!"),

	USER_ADD_SUCCESS("ADD_USER_SUCCESS"),
	USER_DEL_SUCCESS("DEL_USER_SUCCESS"),
	USER_MODIFY_SUCCESS("MODIFY_USER_SUCCESS"),
	USER_QUERY_SUCCESS("QUERY_USER_SUCCESS"),

	CASE_ADD_SUCCESS("CASE_ADD_SUCCESS"),
	CASE_DEL_SUCCESS("CASE_DEL_SUCCESS"),
	CASE_MODIFY_SUCCESS("CASE_MODIFY_SUCCESS!!"),
	CASE_QUERY_SUCCESS("CASE_QUERY_SUCCESS!!"),

	CASE_ADD_ERROR(1022, "CASE_ADD_ERROR"),
	CASE_DEL_ERROR(1024, "CASE_DEL_ERROR"),
	CASE_MODIFY_ERROR(1023, "CASE_MODIFY_ERROR"),
	CASE_QUERY_ERROR(1025, "CASE_QUERY_ERROR"),

	CASEGROUP_ADD_SUCCESS("CASEGROUP_ADD_SUCCESS"),
	CASEGROUP_DEL_SUCCESS("CASEGROUP_DEL_SUCCESS"),
	CASEGROUP_MODIFY_SUCCESS("CASEGROUP_MODIFY_SUCCESS!!"),
	CASEGROUP_QUERY_SUCCESS("CASEGROUP_QUERY_SUCCESS!!"),

	CASEGROUP_ADD_ERROR(1026, "CASEGROUP_ADD_ERROR"),
	CASEGROUP_DEL_ERROR(1027, "CASEGROUP_DEL_ERROR"),
	CASEGROUP_MODIFY_ERROR(1028, "CASEGROUP_UPDATE_ERROR"),
	CASEGROUP_QUERY_ERROR(1029, "QUERYCASEGROUP_ERROR"),

	CREATOR_IS_NULL(1021, "CREATOR_IS_NULL"),
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