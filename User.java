public class User {
	final int DEFAULT_BUY = 1;
	final static String MONEY_ERROR = "Not Enough Money";
	
	
	private double amount_money;
	private Cart cart;
	
	public User()
	{
		amount_money = 0;
		cart = new Cart();
	}
	
	public void buy(Game buy_game) throws GameNotExist
	{
		cart.add_to_cart(buy_game, DEFAULT_BUY);
	}
	
	public void print_cart()
	{
		cart.print_cart_info();
	}
	
	public void submit() throws NotEnoughMoneyException 
	{
		double price = cart.get_total_price();
		if(price > amount_money)
		{
			throw new NotEnoughMoneyException(MONEY_ERROR);
		}
		else
		{
			amount_money -= price;
			cart.make_empty();
		}
	}
	
	public void remove(Game input_game) throws NotInCartException
	{
		cart.remove(input_game);
	}
	
	public void charge(double amount_charge)
	{
		amount_money += amount_charge;
	}
}
