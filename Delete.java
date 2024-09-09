package gls.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		String Username = request.getParameter("Username");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Delete Employee</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>Deleted Employee with name " + Username + "</h1>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/", "root", "Tanvi@gls16");
			PreparedStatement pst = con.prepareStatement("DELETE FROM User WHERE Username = " + Username);
			pst.executeUpdate();
			out.println("<h2>Employee Deleted Successfully!</h2>");
			
			// Link back to home page or employee validation page
			String linkUrl = "Details";
			out.println("<a href='" + linkUrl + "'>Back to Home</a>");
		} catch (Exception e) {
			out.println("<h3>Error Occurred: " + e.getMessage() + "</h3>");
		}

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
