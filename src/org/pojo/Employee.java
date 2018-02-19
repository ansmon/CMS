package org.pojo;

public class Employee {
	private int empId;
	private String empUserName;
	private String empEmail;
	private String empPassword;
	private String empAddress;
	private String empContactNo;
		public Employee() {
		super();
	}		
	public Employee(String empUserName, String empEmail, String empPassword, String empAddress,
				String empContactNo) {
			super();
			this.empUserName = empUserName;
			this.empEmail = empEmail;
			this.empPassword = empPassword;
			this.empAddress = empAddress;
			this.empContactNo = empContactNo;
		}

	public Employee(int empId, String empUserName, String empEmail, String empPassword, String empAddress,
				String empContactNo) {
			super();
			this.empId = empId;
			this.empUserName = empUserName;
			this.empEmail = empEmail;
			this.empPassword = empPassword;
			this.empAddress = empAddress;
			this.empContactNo = empContactNo;
		}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpUserName() {
		return empUserName;
	}
	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpContactNo() {
		return empContactNo;
	}
	public void setEmpContactNo(String empContactNo) {
		this.empContactNo = empContactNo;
	}
}
