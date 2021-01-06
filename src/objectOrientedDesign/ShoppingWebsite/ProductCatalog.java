package objectOrientedDesign.ShoppingWebsite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductCatalog {

  Map<String, List<UUID>> productNameAndProductIdMap = new HashMap<>();
  Map<String, List<UUID>> productCategoryAndProductIdMap = new HashMap<>();
  Map<UUID, Product> productIdAndProductMap = new HashMap<>();

  public void searchProductByName() {
  }

  public void searchProductByCategory() {
  }
}
