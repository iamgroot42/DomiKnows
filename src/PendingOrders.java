//@author : Anshuman Suri - 2014021
//@author : Satyam Kumar - 2014096

import java.util.HashMap;

public class PendingOrders {
	
	private static HashMap<Integer, User> orders = new HashMap<Integer, User>();
	private static int NumOrders = 0;
	public static int getNumOrders()
	{
		return NumOrders;
	}
	public static void incNumOrders()
	{
		NumOrders++;
	}
	public static void decNumOrders()
	{
		NumOrders--;
	}
	public static HashMap<Integer,User> getOrders()
	{
		return orders;
	}
	/* not needed, remove it while submitting */
//	public PendingOrders()
//	{		
//		BufferedReader in= null;
//		orders = new HashMap<Integer, User>();
//		String line, tmp[];
//		try {
//			in = new BufferedReader(new FileReader("Orders.txt"));
//			NumOrders = Integer.parseInt(in.readLine());
//			while((line = in.readLine()) != null) {
//				tmp = line.split("-");
//				orders.put(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
//			}
//		} catch(IOException e) {
//			System.out.println("TF!");
//		} finally {
//			try {if(in != null) in.close();} catch(IOException e){}
//		}
//	}
	
	public static void insertOrder(int orderid, User user)
	{
		orders.put(orderid, user);
	}
	public static User getOrder(int orderid)
	{
		return orders.get(orderid);
	}
	
	public static boolean changeOrder(int orderid)
	{
		if(getOrder(orderid)!=null) {
			int state = orders.get(orderid).current_order.getState();
			orders.get(orderid).current_order.setState(++state);
			if(state>6) state=6;
			//If order completed,remove it 
//			if(state == 6)
//				orders.remove(orders.get(orderid));
			return true;
		}
		return false;
	}
	/* not needed, remove it while submitting */
//	public void FinalWrite()
//	{
//		BufferedWriter out = null;
//		try {
//			out = new BufferedWriter(new FileWriter("Orders.txt"));
//			out.write(""+NumOrders+System.lineSeparator());
//			for(Integer orderid : orders.keySet()) {
//				out.write(""+orderid+System.lineSeparator());
//			}
//		} catch(IOException e) {
//		} finally {try {if(out != null) out.close();}catch(IOException e){}}
//		
//	}
}
