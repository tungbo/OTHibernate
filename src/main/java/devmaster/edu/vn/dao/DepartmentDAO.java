package devmaster.edu.vn.dao;

import java.util.List;

import devmaster.edu.vn.entity.Department;

public interface DepartmentDAO {
	public List<Department> getAllDepartment();
	public Department getDepartmentById(String id);
	public boolean insertDepartment(Department product);
	public boolean updateDepartment(Department product);
	public boolean deleteDepartment(Integer id);
}
