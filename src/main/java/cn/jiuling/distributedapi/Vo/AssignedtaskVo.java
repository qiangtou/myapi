package cn.jiuling.distributedapi.Vo;

public class AssignedtaskVo {
	/*<username></username>
	<casetitle></casetitle>
	<cameratitle></cameratitle>
	<videoifilename></videoifilename>
	<uploadvideoid></uploadvideoid>
	<status></status>
	*/

	private String username;
	private String casetitle;
	private String cameratitle;
	private String videoifilename;
	private Long uploadvideoid;
	private Short status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCasetitle() {
		return casetitle;
	}

	public void setCasetitle(String casetitle) {
		this.casetitle = casetitle;
	}

	public String getCameratitle() {
		return cameratitle;
	}

	public void setCameratitle(String cameratitle) {
		this.cameratitle = cameratitle;
	}

	public String getVideoifilename() {
		return videoifilename;
	}

	public void setVideoifilename(String videoifilename) {
		this.videoifilename = videoifilename;
	}

	public Long getUploadvideoid() {
		return uploadvideoid;
	}

	public void setUploadvideoid(Long uploadvideoid) {
		this.uploadvideoid = uploadvideoid;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public AssignedtaskVo(String username, String casetitle, String cameratitle, String videoifilename, Long uploadvideoid, Short status) {
		super();
		this.username = username;
		this.casetitle = casetitle;
		this.cameratitle = cameratitle;
		this.videoifilename = videoifilename;
		this.uploadvideoid = uploadvideoid;
		this.status = status;
	}

}
