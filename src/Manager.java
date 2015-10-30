
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>Pending Orders</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<table spacing=\"20px\">");
		//Fetch list of pending orders
		{
			writer.print("<tr>");
			writer.print("<td>");
			writer.print("Write Order ID here");
			writer.print("</td>");
			writer.print("<td>");
			writer.print("Corresponding status here");
			writer.print("</td>");
			writer.print("</tr>");
			writer.print("<td>");
			writer.print("<input type=\"button\" name=\"Orderid\" value=\"Update\"/>");
			writer.print("</td>");
		}
		writer.print("</table>");
		writer.print("</body>");
		writer.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//Update status
	}

}
