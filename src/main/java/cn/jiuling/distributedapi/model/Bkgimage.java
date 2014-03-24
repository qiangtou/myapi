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
 * Bkgimage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bkgimage")
public class Bkgimage implements java.io.Serializable {

	// Fields

	private Long bkgImageId;
	private Analysisvideo analysisvideo;
	private Long bkgimgStartFrmIdx;
	private Long bkgimgStartFrmIdxRef;
	private Long bkgimgStartFrmPts;
	private Long bkgimgEndFrmIdx;
	private Long bkgimgEndFrmIdxRef;
	private Long bkgimgEndFrmPts;
	private Long bkgimgOffset;
	private Integer bkgimgLen;

	// Constructors

	/** default constructor */
	public Bkgimage() {
	}

	/** minimal constructor */
	public Bkgimage(Analysisvideo analysisvideo) {
		this.analysisvideo = analysisvideo;
	}

	/** full constructor */
	public Bkgimage(Analysisvideo analysisvideo, Long bkgimgStartFrmIdx, Long bkgimgStartFrmIdxRef, Long bkgimgStartFrmPts, Long bkgimgEndFrmIdx,
			Long bkgimgEndFrmIdxRef, Long bkgimgEndFrmPts, Long bkgimgOffset, Integer bkgimgLen) {
		this.analysisvideo = analysisvideo;
		this.bkgimgStartFrmIdx = bkgimgStartFrmIdx;
		this.bkgimgStartFrmIdxRef = bkgimgStartFrmIdxRef;
		this.bkgimgStartFrmPts = bkgimgStartFrmPts;
		this.bkgimgEndFrmIdx = bkgimgEndFrmIdx;
		this.bkgimgEndFrmIdxRef = bkgimgEndFrmIdxRef;
		this.bkgimgEndFrmPts = bkgimgEndFrmPts;
		this.bkgimgOffset = bkgimgOffset;
		this.bkgimgLen = bkgimgLen;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BkgImageID", unique = true, nullable = false)
	public Long getBkgImageId() {
		return this.bkgImageId;
	}

	public void setBkgImageId(Long bkgImageId) {
		this.bkgImageId = bkgImageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AnalysisID", nullable = false)
	public Analysisvideo getAnalysisvideo() {
		return this.analysisvideo;
	}

	public void setAnalysisvideo(Analysisvideo analysisvideo) {
		this.analysisvideo = analysisvideo;
	}

	@Column(name = "bkgimg_start_frm_idx")
	public Long getBkgimgStartFrmIdx() {
		return this.bkgimgStartFrmIdx;
	}

	public void setBkgimgStartFrmIdx(Long bkgimgStartFrmIdx) {
		this.bkgimgStartFrmIdx = bkgimgStartFrmIdx;
	}

	@Column(name = "bkgimg_start_frm_idx_ref")
	public Long getBkgimgStartFrmIdxRef() {
		return this.bkgimgStartFrmIdxRef;
	}

	public void setBkgimgStartFrmIdxRef(Long bkgimgStartFrmIdxRef) {
		this.bkgimgStartFrmIdxRef = bkgimgStartFrmIdxRef;
	}

	@Column(name = "bkgimg_start_frm_pts")
	public Long getBkgimgStartFrmPts() {
		return this.bkgimgStartFrmPts;
	}

	public void setBkgimgStartFrmPts(Long bkgimgStartFrmPts) {
		this.bkgimgStartFrmPts = bkgimgStartFrmPts;
	}

	@Column(name = "bkgimg_end_frm_idx")
	public Long getBkgimgEndFrmIdx() {
		return this.bkgimgEndFrmIdx;
	}

	public void setBkgimgEndFrmIdx(Long bkgimgEndFrmIdx) {
		this.bkgimgEndFrmIdx = bkgimgEndFrmIdx;
	}

	@Column(name = "bkgimg_end_frm_idx_ref")
	public Long getBkgimgEndFrmIdxRef() {
		return this.bkgimgEndFrmIdxRef;
	}

	public void setBkgimgEndFrmIdxRef(Long bkgimgEndFrmIdxRef) {
		this.bkgimgEndFrmIdxRef = bkgimgEndFrmIdxRef;
	}

	@Column(name = "bkgimg_end_frm_pts")
	public Long getBkgimgEndFrmPts() {
		return this.bkgimgEndFrmPts;
	}

	public void setBkgimgEndFrmPts(Long bkgimgEndFrmPts) {
		this.bkgimgEndFrmPts = bkgimgEndFrmPts;
	}

	@Column(name = "bkgimg_offset")
	public Long getBkgimgOffset() {
		return this.bkgimgOffset;
	}

	public void setBkgimgOffset(Long bkgimgOffset) {
		this.bkgimgOffset = bkgimgOffset;
	}

	@Column(name = "bkgimg_len")
	public Integer getBkgimgLen() {
		return this.bkgimgLen;
	}

	public void setBkgimgLen(Integer bkgimgLen) {
		this.bkgimgLen = bkgimgLen;
	}

}