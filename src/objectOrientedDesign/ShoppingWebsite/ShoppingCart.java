package objectOrientedDesign.ShoppingWebsite;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

  private Map<Product, Integer> shoppingList = new HashMap<>(0);

  public void addItem(Product product) {
    if(product.getAvailableQuantity() == 0){
      return;
    }
    if (shoppingList.get(product) != null && shoppingList.get(product) < 10) {
      shoppingList.put(product, shoppingList.get(product) + 1);
    } else {
      shoppingList.put(product, 1);
    }
    // decrease item quantity by 1 when order is placed
  }

  public void removeItem(){}

  public Map<Product, Integer> getShoppingList() {
    return shoppingList;
  }
}
