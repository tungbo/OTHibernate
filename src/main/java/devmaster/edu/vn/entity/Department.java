package devmaster.edu.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	@Id
	@Column(name = "DEPT_ID")
	private Integer deptId;
	@Column(name = "DEPT_NAME")
	private String deptName;
	@Column(name = "DEPT_NO")
	private String deptNo;
	@Column(name = "LOCATION")
	private String location;
	
	public Department() {}
	
	public Department(Integer deptId, String deptName, String deptNo, String location) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptNo = deptNo;
		this.location = location;
	}

	public Integer getDeptID() {
		return deptId;
	}

	public void setDeptID(Integer deptID) {
		this.deptId = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
