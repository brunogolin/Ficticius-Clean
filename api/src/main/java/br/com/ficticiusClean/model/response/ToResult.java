package br.com.ficticiusClean.model.response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

public class ToResult {

	private Timestamp timestamp;
	private String id;
	private int status;
	private String status_message;
	private ArrayList<ToResultError> errors;
	private Object data;

	public ToResult() {
		this.id = UUID.randomUUID().toString().replaceAll("-", "");
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.errors = null;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public String getId() {
		return id;
	}

	public int getStatus() {
		return status;
	}

	public String getStatus_message() {
		return status_message;
	}

	public ArrayList<ToResultError> getErrors() {
		return errors;
	}

	public Object getData() {
		return data;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

	public void setErrors(ArrayList<ToResultError> errors) {
		this.errors = errors;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void addError(TipoErrosEnum tipoErro, String field) {
		
		if (this.errors == null)
			this.errors = new ArrayList<ToResultError>();
		
		ToResultError error = new ToResultError();

		error.setCode(tipoErro.toString());
		error.setField(field);

		this.errors.add(error);
	}

	public boolean hasError() {
		return (null == this.errors) ? true : false;
	}

	public boolean hasNotError() {
		return (null == this.errors) ? true : false;
	}

}
