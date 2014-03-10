package cn.jiuling.distributedapi.exception;

import org.apache.log4j.Logger;

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

	public ServiceException(Status status, Throwable cause) {
		this(status.getDesc(), cause);
		if (cause instanceof ServiceException) {
			ServiceException se = (ServiceException) cause;
			this.status = se.getStatus();
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
