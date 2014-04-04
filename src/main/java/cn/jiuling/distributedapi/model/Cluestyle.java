package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cluestyle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_cluestyle")
public class Cluestyle implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;

	// Constructors

	/** default constructor */
	public Cluestyle() {
	}

	/** full constructor */
	public Cluestyle(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}