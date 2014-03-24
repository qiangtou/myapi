package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Tubesuminfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tubesuminfo")
public class Tubesuminfo implements java.io.Serializable {

	// Fields

	private Long tubeSumInfoId;
	private Generatevideo generatevideo;
	private Integer tubeId;
	private Long startFrmIdSum;
	private Long numFrmSum;

	// Constructors

	/** default constructor */
	public Tubesuminfo() {
	}

	/** minimal constructor */
	public Tubesuminfo(Generatevideo generatevideo, Integer tubeId) {
		this.generatevideo = generatevideo;
		this.tubeId = tubeId;
	}

	/** full constructor */
	public Tubesuminfo(Generatevideo generatevideo, Integer tubeId, Long startFrmIdSum, Long numFrmSum) {
		this.generatevideo = generatevideo;
		this.tubeId = tubeId;
		this.startFrmIdSum = startFrmIdSum;
		this.numFrmSum = numFrmSum;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TubeSumInfoID", unique = true, nullable = false)
	public Long getTubeSumInfoId() {
		return this.tubeSumInfoId;
	}

	public void setTubeSumInfoId(Long tubeSumInfoId) {
		this.tubeSumInfoId = tubeSumInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GenerateID", nullable = false)
	public Generatevideo getGeneratevideo() {
		return this.generatevideo;
	}

	public void setGeneratevideo(Generatevideo generatevideo) {
		this.generatevideo = generatevideo;
	}

	@Column(name = "tube_id", nullable = false)
	public Integer getTubeId() {
		return this.tubeId;
	}

	public void setTubeId(Integer tubeId) {
		this.tubeId = tubeId;
	}

	@Column(name = "start_frm_id_sum")
	public Long getStartFrmIdSum() {
		return this.startFrmIdSum;
	}

	public void setStartFrmIdSum(Long startFrmIdSum) {
		this.startFrmIdSum = startFrmIdSum;
	}

	@Column(name = "num_frm_sum")
	public Long getNumFrmSum() {
		return this.numFrmSum;
	}

	public void setNumFrmSum(Long numFrmSum) {
		this.numFrmSum = numFrmSum;
	}

}