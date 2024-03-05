package devmaster.edu.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import devmaster.edu.vn.entity.Department;
import devmaster.edu.vn.util.HibernateUtil;

public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public List<Department> getAllDepartment() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Department> list = session.createQuery("from Department").list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public Department getDepartmentById(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Department department = (Department)session.createQuery("from Product where MaSP = :maSP").setParameter("maSP", id).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return department;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertDepartment(Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(department);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateDepartment(Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(department);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteDepartment(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Department where DEPT_ID = :deptId").setParameter("deptId", id).executeUpdate();
			session.getTransaction().commit();
			session.close();
			if(res>0) {
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

}
