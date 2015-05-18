package com.sds.icto.guestbook.vo;

import java.sql.Date;

public class GuestBookVo {
	private long no;
	private String name;
	private String password;
	private String message;
	private Date date;
	public GuestBookVo() {
	}
	public GuestBookVo(String name, String password, String message) {
		super();
		this.name = name;
		this.password = password;
		this.message = message;
	}
	public GuestBookVo(long no, String name, String password, String message,
			Date date) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.message = message;
		this.date = date;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
