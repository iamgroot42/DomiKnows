

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrackOrder
 */
@WebServlet("/TrackOrder")
public class TrackOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackOrder() {
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
		writer.print("Track Order");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h2>Enter Tracking ID </h2>");
		writer.print("<body>");
		writer.print("<form method='post'>");
		writer.print("<table cellspacing=\"20 px\">");
		writer.print("<tr>");
		writer.print("<td>Tracking ID: </td>");
		writer.print("<td>");
		writer.print("<input type='number' name='orderID' min=\"1\" required >");
		writer.print("</td>");
		writer.print("</tr>");
		writer.print("</table>");
		writer.print("</br>");
		writer.print("<input type=\"submit\" value=\"Track\" >");
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
		int trackingID=Integer.parseInt(request.getParameter("orderID"));
		//Work with this OrderID and redirect user to status page
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("Track Order");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("Progress :");
		int state=4;
//		state= state of corresponding order from file
		writer.print("<ul>");
		if(state>0)
		{
			writer.print("<li>");
			writer.print("Order Placed");
			writer.print("</li>");
		}
		if(state>1)
		{
			writer.print("<li>");
			writer.print("Preparation");
			writer.print("</li>");
		}
		if(state>2)
		{
			writer.print("<li>");
			writer.print("Bake");
			writer.print("</li>");
		}
		if(state>3)
		{
			writer.print("<li>");
			writer.print("Quality Check");
			writer.print("</li>");
		}
		if(state>4)
		{
			writer.print("<li>");
			writer.print("Out for Delivery");
			writer.print("</li>");
		}
		if(state>5)
		{
			writer.print("<li>");
			writer.print("Delivered");
			writer.print("</li>");
		}
		writer.print("</ul>");
		writer.print("</body>");
		writer.print("</html>");
	}

}
