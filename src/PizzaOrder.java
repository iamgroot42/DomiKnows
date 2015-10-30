//@author : Anshuman Suri - 2014021
//@author : Satyam Kumar - 2014096

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PizzaOrder
 */
@WebServlet("/PizzaOrder")
public class PizzaOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		//Set OrderID
		HttpSession session=request.getSession();
		int yoda=PendingOrders.getNumOrders();
		PendingOrders.incNumOrders();
		session.setAttribute("OrderID", yoda+1);
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>");
		writer.println("Build order");
		writer.println("</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2> Select your pizza(s) </h2>");
		writer.print("<h3> Order number : "+(yoda+1)+"</h3>");
		writer.println("<form method='post'>");
		writer.println("<table cellspacing=\"20 px\">");			
		Menu m=new Menu();
		ArrayList<String> menew=m.getPizzas();
		String useless;
		int i;
		for(i=0;i<menew.size();i++)
		{
			writer.println("<tr>");
			writer.println("<td>");
			useless="\"pizza"+i+"\"";
			writer.println("<input type=\"checkbox\" name="+useless+"/>");
			writer.println("</td>");
			writer.println("<td>"+menew.get(i)+"</>");
			writer.println("<td>");
//			writer.println("<select name='size"+i+"'>");
//			writer.println("<option value=\"small\"> Small </option>");
//			writer.println("<option value=\"medium\"> Medium </option>");
//			writer.println("<option value=\"large\"> Large </option>");
//			writer.println("</select>");
			writer.println("</td>");
			writer.println("<td>");
			writer.println("Quantity : ");
			writer.println("<input type='number' name='quantity"+i+"' value=\"1\" min=\"1\"/>");
			writer.println("</td>");
			writer.println("</tr>");
		}
		writer.println("</table>");
		writer.println("</br></br>");
		writer.println("<input type=\"submit\" value=\"Checkout\" name=\"submit\"/>");
		writer.println("<input type=\"reset\" value=\"Reset\" name=\"reset\"/>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order ord=new Order();
		boolean anything=false;
		ArrayList<Integer> pizzas=new ArrayList<Integer>();
		ArrayList<String> sizes=new ArrayList<String>();
		ArrayList<Integer> quantities=new ArrayList<Integer>();
		int i;
		Menu m=new Menu();
		ArrayList<String> mewto=m.getPizzas();
		for(i=0;i<mewto.size();i++)
		{
			if(request.getParameter("pizza"+i)!=null)
			{
				pizzas.add(i);
				sizes.add(request.getParameter("size"+i));
				quantities.add(Integer.parseInt(request.getParameter("quantity"+i)));
				anything=true;
			}
		}				
		HttpSession session=request.getSession();
		int lolwut=(Integer)session.getAttribute("OrderID");
		if(anything)
		{
			ord.setPizzas(pizzas);
			ord.setQuantities(quantities);
//			ord.setSizes(sizes);
			//Uses last used order ID,increments it and puts it in OrderID of current order
			ord.setOrder_id(lolwut);
			ord.setState(1);
			//Adding pizza order to session for being used in the next page
			session.setAttribute("Order",ord);
			response.sendRedirect("DeliveryInfo");
		}	
		else
		{
			//Hack:
			PendingOrders.decNumOrders();
			response.sendRedirect("PizzaOrder");
		}
	}
}
