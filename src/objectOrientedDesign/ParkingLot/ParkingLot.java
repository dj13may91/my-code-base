package objectOrientedDesign.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
  List<ParkingFloor> parkingFloors = new ArrayList<>(0);

  public void addParkingFloor(ParkingFloor floor){
    this.parkingFloors.add(floor);
  }

  public Ticket assignNewTicket(Vehicle newVehicle){
    Ticket ticket = new Ticket();
    ticket.issuedToVehicle = newVehicle;
    //do do do duuhh doooo
    return ticket;
  }
}
