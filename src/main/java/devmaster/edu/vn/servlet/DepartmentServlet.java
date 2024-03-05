package devmaster.edu.vn.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import devmaster.edu.vn.dao.DepartmentDAOImpl;
import devmaster.edu.vn.entity.Department;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentDAOImpl departmentDAOImpl;
       
    public void init() {
    	departmentDAOImpl = new DepartmentDAOImpl();
    }
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch(action) {
            case "/insert":
            	insertDepartment(request, response);
                break;
            case "/delete":
            	deleteDepartment(request, response);
                break;
            case "/update":
            	updateDepartment(request, response);
                break;
				default:
					getAllDepartment(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void getAllDepartment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	List<Department> listDepartment = departmentDAOImpl.getAllDepartment();
	request.setAttribute("listDepartment", listDepartment);
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/Home.jsp");
    dispatcher.forward(request, response);
	}

		    private void insertDepartment(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("deptId"));
		        String name = request.getParameter("deptName");
		        String no = request.getParameter("deptNo");
		        String location = request.getParameter("location");
		        Department department = new Department(id,name, no, location);
		        departmentDAOImpl.insertDepartment(department);
		        response.sendRedirect("list");
		    }

		    private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("deptId"));
		        String name = request.getParameter("deptName");
		        String no = request.getParameter("deptNo");
		        String location = request.getParameter("location");
		        Department department = new Department(id,name, no, location);
		        departmentDAOImpl.updateDepartment(department);
		        response.sendRedirect("list");
		    }

		    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("deptId"));
		        departmentDAOImpl.deleteDepartment(id);
		        response.sendRedirect("list");
		    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
