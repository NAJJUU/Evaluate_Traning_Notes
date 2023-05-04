package com.earth.najuhwa.dto;

import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Repository;

/*
 * id varchar(30) primary key
	, name varchar(30) not null
	, pwd varchar(30) not null
	, email varchar(50) not null
	, reg_date date not null
 */
@Repository
public class User {
	private String id;
	private String name;
	private String pwd;
	private String email;
	private Date reg_date;

	public User(){this("", "", "", "");}

	public User(String id, String name, String pwd, String email) {
		//super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, pwd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(pwd, other.pwd);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", reg_date=" + reg_date
				+ "]";
	}	
}
