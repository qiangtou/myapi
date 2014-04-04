package cn.jiuling.distributedapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Gis entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbl_gis", uniqueConstraints = @UniqueConstraint(columnNames = { "objectId", "objectType" }))
public class Gis implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer objectId;
	private Short objectType;
	private String longitude;
	private String latitude;
	private String cityCode;
	private String cityName;
	private String province;
	private String areaCounty;
	private String town;
	private String objectDesc;

	// Constructors

	/** default constructor */
	public Gis() {
	}

	/** minimal constructor */
	public Gis(Integer objectId, Short objectType, String longitude, String latitude) {
		this.objectId = objectId;
		this.objectType = objectType;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	/** full constructor */
	public Gis(Integer objectId, Short objectType, String longitude, String latitude, String cityCode, String cityName, String province, String areaCounty,
			String town, String objectDesc) {
		this.objectId = objectId;
		this.objectType = objectType;
		this.longitude = longitude;
		this.latitude = latitude;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.province = province;
		this.areaCounty = areaCounty;
		this.town = town;
		this.objectDesc = objectDesc;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "objectId", nullable = false)
	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	@Column(name = "objectType", nullable = false)
	public Short getObjectType() {
		return this.objectType;
	}

	public void setObjectType(Short objectType) {
		this.objectType = objectType;
	}

	@Column(name = "longitude", nullable = false, length = 20)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", nullable = false, length = 20)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "cityCode", length = 20)
	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Column(name = "cityName", length = 100)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "province", length = 20)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "areaCounty", length = 20)
	public String getAreaCounty() {
		return this.areaCounty;
	}

	public void setAreaCounty(String areaCounty) {
		this.areaCounty = areaCounty;
	}

	@Column(name = "town", length = 20)
	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Column(name = "objectDesc")
	public String getObjectDesc() {
		return this.objectDesc;
	}

	public void setObjectDesc(String objectDesc) {
		this.objectDesc = objectDesc;
	}

}