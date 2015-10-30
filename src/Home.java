

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		writer.print("<title>");
		writer.print("Contact Info");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h2> Welcome to Pizza Planet! </h2>");
		writer.print("</br></br>");
		writer.print("<form action=\"PizzaOrder\" method=\"get\">");
		writer.print("<input type=\"submit\" value=\"Place Order\"/>");
		writer.print("</form>");
		writer.print("</br></br>");
		writer.print("<form action=\"TrackOrder\" method=\"get\">");
		writer.print("<input type=\"submit\" value=\"Track Order\"/>");
		writer.print("</form>");
		writer.print("</body>");
		writer.print("</html>");	
		if(request.getParameter("place-order")!=null) System.out.println("TOMATO");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
