package objectOrientedDesign.ShoppingWebsite;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Product {

  private UUID productId;
  private String name; //tv
  private String type; //electronics
  private long availableQuantity;
  private String description;
  private long price;
  private double avgRating;
  private List<ProductReview> productReviews = new ArrayList<>(0);

  public UUID getProductId() {
    return productId;
  }

  public double getAvgRating() {
    return avgRating;
  }

  public List<ProductReview> getProductReviews() {
    return productReviews;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public long getAvailableQuantity() {
    return availableQuantity;
  }


  public String getDescription() {
    return description;
  }

  public long getPrice() {
    return price;
  }

  public void addProductReview(ProductReview review) {
    //add to list
    //update avg rating
  }
}
