//@author : Anshuman Suri - 2014021
//@author : Satyam Kumar - 2014096
import java.util.ArrayList;

public class Menu {

	ArrayList<String> pizzas;

	public Menu()
	{
		pizzas=new ArrayList<String>();
		pizzas.add("Veggie Delight : Small");
		pizzas.add("Veggie Delight : Medium");
		pizzas.add("Veggie Delight : Large");
		pizzas.add("Cloud 9 : Small");
		pizzas.add("Cloud 9 : Medium");
		pizzas.add("Cloud 9 : Large");
		pizzas.add("Chef's Special : Small");
		pizzas.add("Chef's Special : Medium");
		pizzas.add("Chef's Special : Large");
		pizzas.add("Olive Garden : Small");
		pizzas.add("Olive Garden : Medium");
		pizzas.add("Olive Garden : Large");
	}
	public ArrayList<String> getPizzas() {
		return pizzas;
	}
	
	public String thisPizza(int x)
	{
		if(x<pizzas.size())
		{
			return pizzas.get(x);
		}
		return ""; 
	}
	public void setPizzas(ArrayList<String> pizzas) {
		this.pizzas = pizzas;
	}
	
}
