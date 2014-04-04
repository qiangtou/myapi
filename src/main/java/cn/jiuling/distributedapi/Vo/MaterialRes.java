package cn.jiuling.distributedapi.Vo;


public class MaterialRes extends ResStatus {
	private Long materialid;

	public MaterialRes(Status s, Long materialid) {
		super(s);
		this.materialid = materialid;
	}

	public Long getMaterialid() {
		return materialid;
	}

	public void setMaterialid(Long materialid) {
		this.materialid = materialid;
	}
}
