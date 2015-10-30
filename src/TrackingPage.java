//@author : Anshuman Suri - 2014021
//@author : Satyam Kumar - 2014096

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrackingPage
 */
@WebServlet("/TrackingPage")
public class TrackingPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackingPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int trackingID;
		try
		{
			trackingID=(Integer)request.getAttribute("orderID");
		}
		catch(Exception e)
		{
			trackingID=-1;
		}
		if(trackingID==-1)
		{
			try
			{
				trackingID=Integer.parseInt(request.getParameter("orderID"));
			}
			catch(Exception e)
			{
				//Dance
			}
		}
		//Work with this OrderID and show status
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("Track Order");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");		
		if(PendingOrders.getOrder(trackingID)!=null && trackingID!=-1) //If tracking Id exists
		{
			User luke=PendingOrders.getOrder(trackingID);
			Order anakin=luke.getCurrent_order();
			int state=anakin.getState();
			writer.print("<h2> Order number : "+trackingID+" </h2>");
			writer.print("<h3> Progress : </h3>");
			writer.print("<ul>");
			writer.print("<li>");
			if(state>0)
			{
				writer.print("<b>");
				writer.print("Order Placed");
				writer.print("</b>");
			}
			else
			{
				writer.print("Order Placed");
			}
			writer.print("</li>");
			writer.print("<li>");
			if(state>1)
			{
				writer.print("<b>");
				writer.print("Preparation");
				writer.print("</b>");
			}
			else
			{
				writer.print("Preparation");
			}
			writer.print("</li>");
			writer.print("<li>");
			if(state>2)
			{
				writer.print("<b>");
				writer.print("Bake");
				writer.print("</b>");
			}
			else
			{
				writer.print("Bake");
			}
			writer.print("</li>");
			writer.print("<li>");
			if(state>3)
			{
				writer.print("<b>");
				writer.print("Quality Check");
				writer.print("</b>");
			}
			else
			{
				writer.print("Quality Check");
			}
			writer.print("</li>");
			writer.print("<li>");
			if(state>4)
			{
				writer.print("<b>");
				writer.print("Out for Delivery");
				writer.print("</b>");
			}
			else
			{
				writer.print("Out for Delivery");
			}
			writer.print("</li>");
			writer.print("<li>");
			if(state>5)
			{
				writer.print("<b>");
				writer.print("Delivered");
				writer.print("</b>");
			}
			else
			{
				writer.print("Delivered");
			}
			writer.print("</li>");
			writer.print("</ul>");
		}
		else
		{
			writer.println("Order with this tracking ID not placed yet");
		}
		writer.print("</body>");
		writer.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
