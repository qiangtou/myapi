package cn.jiuling.distributedapi.Vo;

public class SummaryResolutionVo {
	/*<id><id/>
	<description></description>
	<height><height/>
	<width><width/>*/
	private Integer id;
	private String description;
	private Integer height;
	private Integer width;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public SummaryResolutionVo(Integer id, String description, Integer height, Integer width) {
		super();
		this.id = id;
		this.description = description;
		this.height = height;
		this.width = width;
	}
}
