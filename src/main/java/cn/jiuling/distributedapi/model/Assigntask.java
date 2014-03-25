package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Assigntask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_assigntask")
public class Assigntask implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private Long userUploadVideoId;
	private Short status;
	private String statusDesc;

	// Constructors

	/** default constructor */
	public Assigntask() {
	}

	public Assigntask(Long userId, Long userUploadVideoId) {
		super();
		this.userId = userId;
		this.userUploadVideoId = userUploadVideoId;
		this.status = 0;
		this.statusDesc = "unhandle";
	}

	/** full constructor */
	public Assigntask(Long userId, Long userUploadVideoId, Short status, String statusDesc) {
		this.userId = userId;
		this.userUploadVideoId = userUploadVideoId;
		this.status = status;
		this.statusDesc = statusDesc;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "UserID", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "UserUploadVideoId", nullable = false)
	public Long getUserUploadVideoId() {
		return this.userUploadVideoId;
	}

	public void setUserUploadVideoId(Long userUploadVideoId) {
		this.userUploadVideoId = userUploadVideoId;
	}

	@Column(name = "Status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "Status_Desc", nullable = false, length = 256)
	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}