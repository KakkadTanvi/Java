package gls.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Getting employee data from the request
		String Username = request.getParameter("Username");
		String UserSalary = request.getParameter("UserSalary");
		String UserDesignation= request.getParameter("UserDesignation");

	
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit User</title>");
		out.println("</head>");
		out.println("<body>");

		// Page content
		out.println("<h1>Edit User Details</h1>");
		out.println("<form action='EditAction' method='post'>");
		out.println("<table>");
		out.println("<tr><td>UserName: </td><td><input type='text' name='Username' value='" + Username + "'/></td></tr>");
		out.println("<tr><td> Salary: </td><td><input type='text' name='esal' value='" + UserSalary + "'/></td></tr>");
		out.println("<tr><td> Designation: </td><td><input type='text' name='UserDesignation' value='" + UserDesignation+ "'/></td></tr>");
		out.println("<tr><td></td><td><input type='submit' value='Edit User'></td></tr>");
		out.println("</table>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
