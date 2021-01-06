package objectOrientedDesign.ParkingLot;

import java.util.Date;

public class Ticket {
  TicketStatus status = TicketStatus.UNPAID; //default
  Date issuedAt;
  Vehicle issuedToVehicle;
  Payment payment;
}
