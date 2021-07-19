import java.util.Scanner;

public class GameMarket {
	
	final static String SPACE_CHAR = " ";
	final static int TYPE_COMMAND_INDEX = 0;
	final static String ADD_TYPE = "AddGame";
	final static int INDEX_ID_GAME = 1;
	final static String PRINT_TYPE = "ShowShoppingList";
	final static String SUBMIT_TYPE = "Submit";
	final static String CHARGE_CREDIT = "AddCredit";
	final static String REMOVE_TYPE = "RemoveGame";
	final static int INDEX_AMOUNT_CHARGE = 1;
	final static int INPUT_INDEX = 0;
	
	private static Datas all_data;
	private static User user;
	
	public static void main(String []args)
	{
		all_data = new Datas(args[INPUT_INDEX]);
		user = new User();
		handle_commands();
	}
	
	private static void handle_commands()
	{
		Scanner input_read = new Scanner(System.in);
		while(input_read.hasNextLine())
		{
			String command = input_read.nextLine();
			handle_one_command(command);
		}
		input_read.close();
	}
	
	private static void handle_one_command(String command)
	{
		try {
			String[] parts = command.split(SPACE_CHAR);
			switch(parts[TYPE_COMMAND_INDEX]) 
			{
				case ADD_TYPE:
					Game buy_game = all_data.find_game(parts[INDEX_ID_GAME]);
					user.buy(buy_game);
					break;
				case PRINT_TYPE:
					user.print_cart();
					break;
				case SUBMIT_TYPE: 
					user.submit();
				break;
				case REMOVE_TYPE:
					Game remove_game = all_data.find_game(parts[INDEX_ID_GAME]);
					user.remove(remove_game);
				break;
				case CHARGE_CREDIT:
					double amount_charge = Double.parseDouble(parts[INDEX_AMOUNT_CHARGE]);
					user.charge(amount_charge);
					break;
			}
		}catch(NotEnoughMoneyException money_exception)
		{
			System.out.println(money_exception.getMessage());
		}
		catch(NotInCartException not_in_cart_exception)
		{
			System.out.println(not_in_cart_exception.getMessage());
		}
		catch(GameNotExist game_not_exist)
		{
			System.out.println(game_not_exist.getMessage());
		}
	}
}
