package cn.jiuling.distributedapi.Vo;

public class IdRes extends ResStatus {
	private Long id;

	public IdRes(Status videoAddSuccess, long id) {
		super(videoAddSuccess);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
