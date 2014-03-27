package cn.jiuling.distributedapi.Vo;

public class IdRes extends ResStatus {
	private Long id;

	public IdRes(Status s, long id) {
		this(s);
		this.id = id;
	}

	public IdRes(Status s) {
		super(s);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
