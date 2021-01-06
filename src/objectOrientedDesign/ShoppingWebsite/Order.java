package objectOrientedDesign.ShoppingWebsite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {

  private UUID orderId;
  private UserAccount userAccount;
  private Date issueDate;
  private Date deliveryDate;
  private OrderStatus orderStatus;
  private PaymentMode paymentMode;
  private List<Notification> notificationsSentToUser = new ArrayList<>(0);
  private boolean isPaid;
  private boolean isNotificationSubscribed = true;

  public void sendNotificationToUser(Notification notification) {
    if (isNotificationSubscribed) {
      //send notification
    }
  }

  public void unsubscribe() {
    isNotificationSubscribed = true;
  }

  public PaymentMode getPaymentMode() {
    return paymentMode;
  }

  public boolean isPaid() {
    return isPaid;
  }

  public UUID getOrderId() {
    return orderId;
  }

  public UserAccount getUserAccount() {
    return userAccount;
  }

  public Date getIssueDate() {
    return issueDate;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }
}
