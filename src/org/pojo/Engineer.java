package org.pojo;

public class Engineer {
	private int enggId;
	private String enggUserName;
	private String enggEmail;
	private String enggPassword;
	private String enggAddress;
	private String enggContactNo;
	public Engineer() {
		super();
	}
	public Engineer(String enggUserName, String enggEmail, String enggPassword, String enggAddress,
			String enggContactNo) {
		super();
		this.enggUserName = enggUserName;
		this.enggEmail = enggEmail;
		this.enggPassword = enggPassword;
		this.enggAddress = enggAddress;
		this.enggContactNo = enggContactNo;
	}
	public Engineer(int enggId, String enggUserName, String enggEmail, String enggPassword, String enggAddress,
			String enggContactNo) {
		super();
		this.enggId = enggId;
		this.enggUserName = enggUserName;
		this.enggEmail = enggEmail;
		this.enggPassword = enggPassword;
		this.enggAddress = enggAddress;
		this.enggContactNo = enggContactNo;
	}
	public int getEnggId() {
		return enggId;
	}
	public void setEnggId(int enggId) {
		this.enggId = enggId;
	}
	public String getEnggUserName() {
		return enggUserName;
	}
	public void setEnggUserName(String enggUserName) {
		this.enggUserName = enggUserName;
	}
	public String getEnggEmail() {
		return enggEmail;
	}
	public void setEnggEmail(String enggEmail) {
		this.enggEmail = enggEmail;
	}
	public String getEnggPassword() {
		return enggPassword;
	}
	public void setEnggPassword(String enggPassword) {
		this.enggPassword = enggPassword;
	}
	public String getEnggAddress() {
		return enggAddress;
	}
	public void setEnggAddress(String enggAddress) {
		this.enggAddress = enggAddress;
	}
	public String getEnggContactNo() {
		return enggContactNo;
	}
	public void setEnggContactNo(String enggContactNo) {
		this.enggContactNo = enggContactNo;
	}
}
