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
 * Servlet implementation class EditAction
 */
@WebServlet("/EditAction")
public class EditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String Username = request.getParameter("Username");
		String UserSalary = request.getParameter("UserSalary");
		String UserDesignation = request.getParameter("UserDesignation");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/", "root", "Tanvi@gls16");
			PreparedStatement pst = con.prepareStatement("UPDATE User SET esal=?, edes=? WHERE Username=?");

			pst.setString(1, Username);
			pst.setString(2, UserSalary);
			pst.setString(3, UserDesignation);
			pst.executeUpdate();

			// Start of HTML output with embedded CSS
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Updated</title>");
			out.println("</head>");
			out.println("<body>");

			// Page content
			out.println("<h1> Updated Successfully</h1>");
			out.println("<a href='Details'>View All Employees</a>");

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
		}
	}
	

}
