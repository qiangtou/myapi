package cn.jiuling.distributedapi.Vo;

public class UnhandledtaskVo {
	/* <casetitle></casetitle>
	   <cameratitle></cameratitle>
	   <uploadvideoid></uploadvideoid>//转码任务的id
	   < videoifilename></ videoifilename>//转码后的路径
	*/
	private String casetitle;
	private String cameratitle;
	private Long uploadvideoid;
	private String videoifilename;

	public UnhandledtaskVo(String casetitle, String cameratitle, Long uploadvideoid, String videoifilename) {
		super();
		this.casetitle = casetitle;
		this.cameratitle = cameratitle;
		this.uploadvideoid = uploadvideoid;
		this.videoifilename = videoifilename;
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

	public Long getUploadvideoid() {
		return uploadvideoid;
	}

	public void setUploadvideoid(Long uploadvideoid) {
		this.uploadvideoid = uploadvideoid;
	}

	public String getVideoifilename() {
		return videoifilename;
	}

	public void setVideoifilename(String videoifilename) {
		this.videoifilename = videoifilename;
	}
}
