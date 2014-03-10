package cn.jiuling.distributedapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer userId;
	@Column(name = "name")
	private String userName;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "GroupID")
	private Integer groupId;
	private Byte blocked;
	@Column(name = "create_id")
	private Integer creatorId;
	@Column(name = "create_time")
	private Timestamp createTime;
	@Column(name = "task_priority")
	private Integer taskPriority;
	@Column(name = "update_time_regular")
	private Byte updateTimeRegular;
	@Column(name = "md5pwd")
	private String passWord;
	@Column(name = "last_update_password_time")
	private Timestamp lastUpdatePasswordTime;
	@Column(name = "last_login_time")
	private Timestamp lastLoginTime;
	@Column(name = "total_login_duration")
	private Integer totalLoginDuration;
	@Column(name = "login_count")
	private Integer loginCount;

	public User(String userName, String password, String fullName, Integer groupId) {
		this(userName, password);
		this.fullName = fullName;
		this.groupId = groupId;
	}

	public User() {
	}

	public User(Integer userId, String userName, String fullName, Byte blocked, Integer groupId, Byte updateTimeRegular, String md5pwd) {
		this(userName, md5pwd, fullName, groupId);
		this.userId = userId;
		this.blocked = blocked;
		this.updateTimeRegular = updateTimeRegular;
	}

	public User(String username, String password) {
		this.userName = username;
		this.passWord = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Byte getBlocked() {
		return blocked;
	}

	public void setBlocked(Byte blocked) {
		this.blocked = blocked;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	public Byte getUpdateTimeRegular() {
		return updateTimeRegular;
	}

	public void setUpdateTimeRegular(Byte updateTimeRegular) {
		this.updateTimeRegular = updateTimeRegular;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Timestamp getLastUpdatePasswordTime() {
		return lastUpdatePasswordTime;
	}

	public void setLastUpdatePasswordTime(Timestamp lastUpdatePasswordTime) {
		this.lastUpdatePasswordTime = lastUpdatePasswordTime;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getTotalLoginDuration() {
		return totalLoginDuration;
	}

	public void setTotalLoginDuration(Integer totalLoginDuration) {
		this.totalLoginDuration = totalLoginDuration;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	@Override
	public String toString() {
		return "User [blocked=" + blocked + ", createTime=" + createTime + ", creatorId=" + creatorId + ", fullName=" + fullName + ", groupId=" + groupId
				+ ", lastLoginTime=" + lastLoginTime + ", lastUpdatePasswordTime=" + lastUpdatePasswordTime + ", loginCount=" + loginCount + ", passWord="
				+ passWord + ", taskPriority=" + taskPriority + ", totalLoginDuration=" + totalLoginDuration + ", updateTimeRegular=" + updateTimeRegular
				+ ", userId=" + userId + ", userName=" + userName + "]";
	}

}
