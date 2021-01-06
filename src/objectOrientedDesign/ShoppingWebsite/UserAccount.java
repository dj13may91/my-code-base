package objectOrientedDesign.ShoppingWebsite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserAccount {

  private final Map<UUID, ProductReview> productIdAndReviews = new HashMap<>();
  private String name;
  private String username;
  private String password;
  private String address;
  private String zip;
  private AccountType accountType;
  private AccountStatus accountStatus;
  private List<Object> creditOrDebitCardDataList;

  public String getName() {
    return name;
  }

  public String getUsername() {
    return username;
  }

  public String getAddress() {
    return address;
  }

  public String getZip() {
    return zip;
  }

  public AccountType getAccountType() {
    return accountType;
  }

  public AccountStatus getAccountStatus() {
    return accountStatus;
  }

  public void addProductReview(Product product) {
    ProductReview review = new ProductReview();
    //set review
    this.productIdAndReviews.put(product.getProductId(), review);
    product.addProductReview(review);
  }
}
