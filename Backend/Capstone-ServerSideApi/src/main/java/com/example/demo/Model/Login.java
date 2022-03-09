package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String login_name;
	private String login_password;
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	 public Login(int id, String login_name, String login_password) {
			super();
			this.id = id;
			this.login_name = login_name;
			this.login_password = login_password;
		}
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLoginName() {
			return login_name;
		}
		public void setLoginName(String login_name) {
			this.login_name = login_name;
		}
		public String getLoginPassword() {
			return login_password;
		}
		public void setLoginPassword(String login_password) {
			this.login_password = login_password;
		}

}
