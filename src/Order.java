//@author : Anshuman Suri - 2014021
//@author : Satyam Kumar - 2014096
import java.util.ArrayList;

public class Order {
	int order_id;
	int state;
	//Will use a hash for code of pizza and pizza names
	ArrayList<Integer> pizzas; 
	ArrayList<String> sizes;
	ArrayList<Integer> quantities;
	//Pizza name, along with size (small/medium/large)
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public ArrayList<Integer> getPizzas() {
		return pizzas;
	}
	public void setPizzas(ArrayList<Integer> pizzas) {
		this.pizzas = pizzas;
	}
	public ArrayList<String> getSizes() {
		return sizes;
	}
	public void setSizes(ArrayList<String> sizes) {
		this.sizes = sizes;
	}
	public ArrayList<Integer> getQuantities() {
		return quantities;
	}
	public void setQuantities(ArrayList<Integer> quantities) {
		this.quantities = quantities;
	}
}
