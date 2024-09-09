package gls.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/", "root", "Tanvi@gls16");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM User");
			ResultSet rs = pst.executeQuery();

			// Start HTML output
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Validation</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Employee List</h1>");

			// Output the employee details with links
			while (rs.next()) {
				String Username = rs.getString(1);
				String UserSalary = rs.getString(2);
				String UserDesignation = rs.getString(3);
				

				String linkUrl = "Details?Username=" + Username + "&UserSalary=" +UserSalary + "&UserDesignation=" + UserDesignation;
				out.println("<a href='" + linkUrl + "'>" + Username + "</a><br>");
			}

			// Home link at the bottom
			String homeUrl = "index.jsp";
			out.println("<br><a href='" + homeUrl + "'>Home</a>");

			out.println("</body>");
			out.println("</html>");

			out.close();
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
