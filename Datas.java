import java.util.ArrayList;
import java.util.List;
import java.io.File;  
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Datas {
	final String ERROR_FILE = "there is an error while reading from file";
	final String DELIMITER = ",";
	final int UNTIL_END = 0;
	final int INDEX_ID = 0;
	final int INDEX_NAME = 1;
	final int INDEX_PRICE = 2;
	final int INDEX_YEAR = 3;
	final int INDEX_COMPANY = 4;
	final int INDEX_QUANTITY = 5;
	final String ERROR_GAME_NOT_EXIST = "This Game Is Not Available";
	
	private List<Game> all_games;
	
	public Datas(String file_input)
	{
		all_games = new ArrayList<Game>();
		read_from_file(file_input);
	}
	
	public void print_all()
	{
		for(int i = 0; i < all_games.size(); i++)
		{
			Game work_game = all_games.get(i);
			work_game.print_info();
		}
	}
	
	public Game find_game(String game_id) throws GameNotExist
	{
		for(int i = 0; i < all_games.size(); i++)
		{
			Game game_check = all_games.get(i);
			if((game_check.get_id()).equals(game_id))
			{
				if(game_check.get_quantity() == 0)
					throw new GameNotExist(ERROR_GAME_NOT_EXIST);
				return game_check;
			}
		}
		throw new GameNotExist(ERROR_GAME_NOT_EXIST);
	}

	private void read_from_file(String file_input)
	{
		try {
			File input_file = new File(file_input);
			Scanner scanner_file = new Scanner(input_file);
			while (scanner_file.hasNextLine()) {
				String readed = scanner_file.nextLine();
				add_new_game(readed);
			 }
			scanner_file.close();
		}catch(FileNotFoundException exception)
		{
			System.out.println(ERROR_FILE);
		}
	}
	
	private void add_new_game(String line_readed)
	{
		String[] infos = line_readed.split(DELIMITER, UNTIL_END);
		String id = infos[0];
		String name = infos[1];
		double price = Double.parseDouble(infos[2]);
		int year = Integer.parseInt(infos[3]);
		String company = infos[4];
		int quantity = Integer.parseInt(infos[5]);
		Game new_game = new Game(id, name, price, year, company, quantity);
		all_games.add(new_game);
	}
}
