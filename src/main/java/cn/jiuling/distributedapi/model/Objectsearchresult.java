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
 * Objectsearchresult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "objectsearchresult")
public class Objectsearchresult implements java.io.Serializable {

	// Fields

	private Long objSearchId;
	private Object object;
	private Generatevideo generatevideo;
	private Long tubeId;
	private Short componentId;
	private Float distance;
	private Boolean isMatched;
	private String snapFilename;
	private String extraInfo;

	// Constructors

	/** default constructor */
	public Objectsearchresult() {
	}

	/** minimal constructor */
	public Objectsearchresult(Generatevideo generatevideo) {
		this.generatevideo = generatevideo;
	}

	/** full constructor */
	public Objectsearchresult(Object object, Generatevideo generatevideo, Long tubeId, Short componentId, Float distance, Boolean isMatched,
			String snapFilename, String extraInfo) {
		this.object = object;
		this.generatevideo = generatevideo;
		this.tubeId = tubeId;
		this.componentId = componentId;
		this.distance = distance;
		this.isMatched = isMatched;
		this.snapFilename = snapFilename;
		this.extraInfo = extraInfo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ObjSearchID", unique = true, nullable = false)
	public Long getObjSearchId() {
		return this.objSearchId;
	}

	public void setObjSearchId(Long objSearchId) {
		this.objSearchId = objSearchId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ObjectID")
	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GenerateID", nullable = false)
	public Generatevideo getGeneratevideo() {
		return this.generatevideo;
	}

	public void setGeneratevideo(Generatevideo generatevideo) {
		this.generatevideo = generatevideo;
	}

	@Column(name = "TubeID")
	public Long getTubeId() {
		return this.tubeId;
	}

	public void setTubeId(Long tubeId) {
		this.tubeId = tubeId;
	}

	@Column(name = "component_id")
	public Short getComponentId() {
		return this.componentId;
	}

	public void setComponentId(Short componentId) {
		this.componentId = componentId;
	}

	@Column(name = "distance", precision = 12, scale = 0)
	public Float getDistance() {
		return this.distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	@Column(name = "is_matched")
	public Boolean getIsMatched() {
		return this.isMatched;
	}

	public void setIsMatched(Boolean isMatched) {
		this.isMatched = isMatched;
	}

	@Column(name = "snap_filename")
	public String getSnapFilename() {
		return this.snapFilename;
	}

	public void setSnapFilename(String snapFilename) {
		this.snapFilename = snapFilename;
	}

	@Column(name = "extra_info")
	public String getExtraInfo() {
		return this.extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

}