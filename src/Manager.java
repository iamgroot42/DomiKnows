
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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
    
    private String Mapper(int x)
    {
    	String ret;
    	if(x==1) ret="Order Placed";
    	else if(x==2) ret="Preparation";
    	else if(x==3) ret="Bake";
    	else if(x==4) ret="Quality Check";
    	else if(x==5) ret="Out for Delivery";
    	else ret="Delivered";
    	return ret;
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
		writer.print("<table cellspacing=\"20px\">");
		writer.print("<form method='post'>");
//		writer.print("<td>Name</td>");
		//Fetch list of pending orders
		HashMap<Integer,User> chloro=PendingOrders.getOrders();
		for(Integer x: chloro.keySet())
		{
			writer.print("<tr>");
			writer.print("<td>");
			writer.print(x);
			writer.print("</td>");
			writer.print("<td>");
			int y=chloro.get(x).getCurrent_order().getState();
			writer.print(Mapper(y));
			writer.print("</td>");
			writer.print("<td>");
			writer.print("<input type=\"button\" name=\""+x+"\" value=\"Update\"/>");
			writer.print("</td>");
			writer.print("</tr>");
		}
		writer.print("</form>");
		writer.print("</table>");
		writer.print("</body>");
		writer.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("BC print kyun nahi ho raha?! This part is effing same as PizzaOrder's last part of doPost() :'(");
		if(request.getParameter("1")!=null) System.out.println("Kuch to hua hai"); 
		for(String y: request.getParameterMap().keySet())
		{
			System.out.println("I got a button :) ");
			PendingOrders.changeOrder(Integer.parseInt(request.getParameter(y)));
		}
	}

}
