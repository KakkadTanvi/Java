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
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
		String UserSalary = request.getParameter("UserSalary");
		String UserDesignation = request.getParameter("UserDesignation");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/", "root", "Tanvi@gls16");
			PreparedStatement pst = con.prepareStatement("INSERT INTO User (Username,UserSalary,UserDesignation) VALUES (?, ?, ?)");
			
			pst.setString(1, Username);
			pst.setString(2, UserSalary);
			pst.setString(3, UserDesignation);
			pst.executeUpdate();

			// Start of HTML output with embedded CSS
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Added</title>");
			out.println("</head>");
			out.println("<body>");
			// Display success message
			out.println("<h1>Employee Successfully Added</h1>");

			// Links to other actions
			out.println("<a href='Details'>Show Employees</a>");
			out.println("<a href='index.jsp'>Home</a>");

			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
