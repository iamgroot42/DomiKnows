import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PendingOrders {
	public static void insertOrder(int orderid)
	{
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter("Orders.txt"));
			out.write(orderid+"-"+1);
			//1 indicates order created
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
