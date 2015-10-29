

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Random
 */
@WebServlet("/Random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Random() {
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
		RequestDispatcher view = request.getRequestDispatcher("HomePage.html");
		view.forward(request, response);
		System.out.println(request.getParameter("pizza1"));
		System.out.println(request.getParameter("size1"));
		System.out.println(request.getParameter("quantity1"));
		
		//Code for making sense out of pizza form-content (begins)
		Order ord=new Order();
		boolean anything=false;
		ArrayList<Integer> pizzas=new ArrayList<Integer>();
		ArrayList<String> sizes=new ArrayList<String>();
		ArrayList<Integer> quantities=new ArrayList<Integer>();
		if(request.getParameter("pizza1")!=null)
		{
			pizzas.add(1);
			sizes.add(request.getParameter("size1"));
			quantities.add(Integer.parseInt(request.getParameter("quantity1")));
			anything=true;
		}
		if(request.getParameter("pizza2")!=null)
		{
			pizzas.add(2);
			sizes.add(request.getParameter("size2"));
			quantities.add(Integer.parseInt(request.getParameter("quantity2")));
			anything=true;
		}
		if(request.getParameter("pizza3")!=null)
		{
			pizzas.add(3);
			sizes.add(request.getParameter("size3"));
			quantities.add(Integer.parseInt(request.getParameter("quantity3")));
			anything=true;
		}
		if(request.getParameter("pizza4")!=null)
		{
			pizzas.add(4);
			sizes.add(request.getParameter("size4"));
			quantities.add(Integer.parseInt(request.getParameter("quantity4")));
			anything=true;
		}
		if(anything)
		{
			ord.setPizzas(pizzas);
			ord.setQuantities(quantities);
			ord.setSizes(sizes);
		}
		//Code for making sense out of pizza form-content (begins)
		
		//Code for making sense out of Track-Order page (ends)
		if(request.getParameter("orderID")!=null)
		{
			//bleh
		}
		//Code for making sense out of Track-Order page (ends)
		
		//Code for making sense out of User-form page (begins)
		User usr=new User();
		//Checks kind of redundant ; checking done at HTML
		if(request.getParameter("name")!=null)
		{
			usr.setName(request.getParameter("name"));
		}
		if(request.getParameter("mobile")!=null)
		{
			usr.setPhone_number(Integer.parseInt(request.getParameter("name")));
		}
		if(request.getParameter("address")!=null)
		{
			usr.setAddress(request.getParameter("address"));
		}
		//Code for making sense out of User-form page (ends)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("name"));
		doGet(request, response);
	}
	

}
