package cn.jiuling.distributedapi.Vo;

public enum Status {
	LOGIN_SUCCESS("login success!!"),
	LOGIN_FAIL(1001, "login fail!!"),
	LOGOUT_SUCCESS("logout success"),
	PARAMETER_ERROR(1003, "parameter error!!"),
	SERVER_ERROR(500, "server error!!"),

	GROUPID_IS_EMPTY(1002, "groupid is empty!!"),
	NAME_ERROR(1002, "name is empty or length larger than 250!!"),

	ADD_SUCCESS("add success!!"),
	DEL_SUCCESS("delete success!!"),
	MODIFY_SUCCESS("modify success!!"),
	QUERY_SUCCESS("query success!!"),
	SEARCH_SUCCESS("search success!!"),

	ADD_ERROR(1010, "add error!!"),
	DEL_ERROR(1011, "delete error!!"),
	MODIFY_ERROR(1012, "modify error!!"),
	QUERY_ERROR(1013, "query error!!"),

	CREATOR_IS_NULL(1021, "creator_is_null"),
	DISK_SPACE_IS_NOT_ENOUGHT(1022, "disk space is not enought"),
	FILE_NOT_EXIST(1023, "file_not_exist"),
	OBJECT_IS_NOT_EXIST(9901, "object is not exist"),
	SRCFILE_IS_NOT_EXIST(5, "srcFile isn't exist"),
	SRCFILE_ISNOT_VALID(6, "srcFile isn't valid"),
	TASK_REPEAT(-3, "a repeat task not finish!"),
	INVALID_VALUE(1, "invalid value!!"),
	NO_RESULT(1001, "no result"),
	TASK_TYPE_ERRER(1021, "TASK_TYPE_ERRER")

	;

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
