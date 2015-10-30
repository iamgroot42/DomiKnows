//@author : Anshuman Suri - 2014021
//@author : Satyam Kumar - 2014096
import java.util.ArrayList;

public class Menu {

	ArrayList<String> pizzas;

	public Menu()
	{
		pizzas=new ArrayList<String>();
		pizzas.add("Veggie Delight");
		pizzas.add("Cloud 9");
		pizzas.add("Chef's Special");
		pizzas.add("Olive Garden");
	}
	public ArrayList<String> getPizzas() {
		return pizzas;
	}

	public void setPizzas(ArrayList<String> pizzas) {
		this.pizzas = pizzas;
	}
	
}
