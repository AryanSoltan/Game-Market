public class ItemBought {
	
	final String ID_DEFINE = "id: ";
	final String NAME_DEFINE = " name: ";
	final String NUMBER_DEFINE = " number bought: ";
	final String ERROR_GAME_NOT_EXIST = "This Game Is Not Available";
	
	private int number_bought;
	private Game game_type;
	
	public ItemBought(Game game_type_input, int number_input)
	{
		game_type = game_type_input;
		number_bought = number_input;
	}
	public void buy(int number_buy) throws GameNotExist
	{
		if(number_bought + number_buy > game_type.get_quantity())
			throw new GameNotExist(ERROR_GAME_NOT_EXIST);
		number_bought += number_buy;
	}
	
	public boolean is_equal(Game game_input)
	{
		return game_type.equals(game_input);
	}
	
	public void print_info()
	{
		String id_game = game_type.get_id();
		String name_game = game_type.get_name();
		System.out.println(ID_DEFINE + id_game + NAME_DEFINE + name_game + NUMBER_DEFINE + number_bought);
	}
	
	public double calculate_price() 
	{
		return number_bought * game_type.get_price();
	}
	
	public void buy_finish()
	{
		game_type.buy(number_bought);
	}
	
	public void remove()
	{
		number_bought -= 1;
	}
	
	public boolean is_empty()
	{
		if(number_bought == 0)
			return true;
		return false;
	}
}
