import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class PendingOrders {
	
	private static HashMap<Integer, Integer> orders;
	private static int NumOrders;
	public PendingOrders()
	{
		BufferedReader in= null;
		orders = new HashMap<Integer, Integer>();
		String line, tmp[];
		try {
			in = new BufferedReader(new FileReader("Orders.txt"));
			NumOrders = Integer.parseInt(in.readLine());
			while((line = in.readLine()) != null) {
				tmp = line.split("-");
				orders.put(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
			}
		} catch(IOException e) {
			System.out.println("TF!");
		} finally {
			try {if(in != null) in.close();} catch(IOException e){}
		}
	}
	
	public static void insertOrder(int orderid)
	{
		orders.put(orderid, 1); NumOrders++;
	}
	
	public static boolean getOrder(int orderid)
	{
		return orders.containsKey(orderid);
	}
	
	public static boolean changeOrder(int orderid)
	{
		if(getOrder(orderid)) {
			orders.put(orderid, orders.get(orderid) + 1);
			return true;
		}
		else return false;
	}
	public void FinalWrite()
	{
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("Orders.txt"));
			out.write(""+NumOrders+System.lineSeparator());
			for(Integer orderid : orders.keySet()) {
				out.write(""+orderid+System.lineSeparator());
			}
		} catch(IOException e) {
		} finally {try {if(out != null) out.close();}catch(IOException e){}}
		
	}
}