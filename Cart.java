import java.util.ArrayList;
import java.util.List; 
public class Cart {
	 final String ERROR_NOT_IN_CART = "This Game is not in Cart.";
	
	 int NOT_FOUND = -1;
	 private List<ItemBought> cart;
	 public Cart()
	 {
		 cart = new ArrayList<ItemBought>();
	 }
	 
	 public void add_to_cart(Game new_game, int number_add) throws GameNotExist
	 {
		 int index_in_list = get_index(new_game);
		 if(index_in_list == NOT_FOUND)
		 {
			 ItemBought new_item = new ItemBought(new_game, number_add);
			 cart.add(new_item);
		 }
		 else 
		 {
			 ItemBought item_bought = cart.get(index_in_list);
			 item_bought.buy(number_add);
		 }
	 }
	 
	 public double get_total_price()
	 {
		 double total_price = 0;
		 for(int i = 0; i < cart.size(); i++)
		 {
			 ItemBought now_item = cart.get(i);
			 total_price += now_item.calculate_price();
		 }
		 return total_price;
	 }
	 
	 public void print_cart_info()
	 {
		 for(int i = 0; i < cart.size(); i++)
		 {
			 (cart.get(i)).print_info();
		 }
	 }
	 
	 public void make_empty()
	 {
		 for(int i = 0; i < cart.size(); i++)
		 {
			 ItemBought now_item = cart.get(i);
			 now_item.buy_finish();
		 }
		 cart.clear();
	 }
	 
	 public void remove(Game input_game) throws NotInCartException
	 {
		 int index_in_list = get_index(input_game);
		 if(index_in_list == NOT_FOUND)
		 {
			 throw new NotInCartException(ERROR_NOT_IN_CART);
		 }
		 else 
		 {
			 ItemBought item_bought = cart.get(index_in_list);
			 item_bought.remove();
			 if(item_bought.is_empty())
				 cart.remove(index_in_list);
		 }
	 }

	 private int get_index(Game game_input)
	 {
		 for(int i = 0; i < cart.size(); i++)
		 {
			 if((cart.get(i)).is_equal(game_input))
			 {
				 return i;
			 }
		 }
		 return NOT_FOUND;
	 }
	 
}

