package gls.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String Username = request.getParameter("Username");
		String UserSalary = request.getParameter("UserSalary");
		String UserDesignation = request.getParameter("UserDesignation");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>User Details</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>User Name: " + Username + "</h1>");
		out.println("<h1>User Salary: " + UserSalary + "</h1>");
		out.println("<h1>User Designation: " + UserDesignation + "</h1>");

		String delUrl = "Delete?Username=" + Username;
		out.println("<a href='" + delUrl + "'>Delete</a>");

		String homeUrl = "index.jsp";
		out.println("<a href='" + homeUrl + "'>Home</a>");

		String editUrl = "EditEmp?Username=" +Username;
		out.println("<a href='" + editUrl + "'>Edit</a>");

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
