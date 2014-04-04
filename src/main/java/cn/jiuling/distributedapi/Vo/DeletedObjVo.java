package cn.jiuling.distributedapi.Vo;

import java.sql.Timestamp;
import java.util.Date;

public class DeletedObjVo {
	/* <id></id>
	  <type></type>
	  <title></title>
	  <create_time></create_time>*/
	private Long id;
	private Integer type;
	private String title;
	private Timestamp create_time;

	public DeletedObjVo(Long id, String title, Date createTime, Integer type) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		if (createTime != null) {
			this.create_time = (Timestamp) createTime;
		}
	}

	/*public DeletedObjVo(Object id, Object title, Object createTime, Object type) {
		System.out.println(123);
		this.id = (Long) id;
		this.type = (Integer) type;
		this.title = (String) title;
		this.create_time = (Timestamp) createTime;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp createTime) {
		create_time = createTime;
	}

}
