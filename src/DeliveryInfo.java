

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeliveryInfo
 */
@WebServlet("/DeliveryInfo")
public class DeliveryInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title> Contact Info </title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h2> Enter your contact information </h2>");
		//Get Order ID from session:
		HttpSession session=request.getSession();
		int orderid=(Integer)session.getAttribute("OrderID");
		writer.print("<h3> Order number : "+orderid+"</h3>");
		
		writer.print("<form method='post'>");
		writer.print("<table cellspacing=\"20 px\">");
		writer.print("<tr>");
		writer.print("<td> Name :</td>");
		writer.print("<td>");
		writer.print("<input type=\"text\" name=\"name\" required>");
		writer.print("</td>");
		writer.print("</tr>");
		writer.print("<tr>");
		writer.print("<td> Phone number: </td>");
		writer.print("<td>");
		writer.print("<input type=\"number\" name=\"mobile\" min=\"0\" required>");
		writer.print("</td>");
		writer.print("</tr>");
		writer.print("<tr>");
		writer.print("<td>Address :</td>");
		writer.print("<td>");
		writer.print("<textarea name=\"address\" required></textarea>");
		writer.print("</td>");
		writer.print("</tr>");
		writer.print("</table>");
		writer.print("<br/><br/>");
		writer.print("<input type=\"submit\" value=\"Place Order\">");
		writer.print("</form>");
		writer.print("</body>");
		writer.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name,address;
		long phoneno;
		//Mandatory fields, will never be null:
		name=request.getParameter("name");
		address=request.getParameter("address");
		phoneno=Long.parseLong(request.getParameter("mobile"));
		User usr=new User();
		usr.setAddress(address);
		usr.setName(name);
		usr.setPhone_number(phoneno);
		HttpSession session = request.getSession();
		Order ord=(Order)session.getAttribute("Order");
		usr.setCurrent_order(ord);
		
		//Add order to database :
		PendingOrders.insertOrder(ord.getOrder_id(), usr);
		session.invalidate(); //Get rid of the current session
		
		//Redirect user to tracking page for this tracking ID
		request.setAttribute("orderID", ord.getOrder_id());
		RequestDispatcher view = request.getRequestDispatcher("TrackingPage");
		view.forward(request, response);
	}

}
