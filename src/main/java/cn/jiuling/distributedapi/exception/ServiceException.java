package cn.jiuling.distributedapi.exception;

import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import cn.jiuling.distributedapi.Vo.Status;

public class ServiceException extends RuntimeException {

	private final Logger log = Logger.getLogger(ServiceException.class);
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ServiceException() {
		super();
	}

	public ServiceException(Status status) {
		this(status.getDesc());
		this.status = status;

	}

	public ServiceException(Status status, String msg) {
		this(status);
		status.setDesc(msg + ":" + status.getDesc());

	}

	public ServiceException(Status status, Throwable cause) {
		this(status.getDesc(), cause);
		if (cause instanceof ServiceException) {
			ServiceException s = (ServiceException) cause;
			this.status = s.getStatus();
		} else if (cause instanceof ObjectNotFoundException || cause instanceof HibernateObjectRetrievalFailureException) {
			this.status = Status.OBJECT_IS_NOT_EXIST;
		} else {
			this.status = status;
		}
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
