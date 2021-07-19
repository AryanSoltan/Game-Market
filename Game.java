public class Game {
	private String id;
	private String name;
	private int year;
	private double price;
	private int quantity;
	private String company;
	public Game(String id_input, String name_input
				, double price_input, int year_input, 
				String company_input, int quantity_input) {
		id = id_input;
		name = name_input;
		year = year_input;
		price = price_input;
		company = company_input;
		quantity = quantity_input;
	}
	public void print_info()
	{
		System.out.println("id = " + id + " name = " + name);
	}
	
	public String get_id()
	{
		return id;
	}
	
	public String get_name()
	{
		return name;
	}
	
	public double get_price()
	{
		return price;
	}
	
	public void buy(int number_bought)
	{
		quantity -= number_bought;
	}
	
	public int get_quantity()
	{
		return quantity;
	}
}
