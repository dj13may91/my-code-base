package objectOrientedDesign.ShoppingWebsite;

import java.util.Date;

public class Payment {
  PaymentMode paymentMode;
  PaymentStatus paymentStatus = PaymentStatus.PENDING;
  Date paidOn;
}
