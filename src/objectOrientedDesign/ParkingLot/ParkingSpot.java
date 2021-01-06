package objectOrientedDesign.ParkingLot;

public class ParkingSpot {
  VehicleType type;
  boolean isFree;
  Vehicle vehicle;
  ParkingSpotType spotType;
  int spotNumber;
  int floorNumber;

  public void freeSpot(){
    this.isFree = true;
  }

  public void assignSpot(){
    this.isFree = false;
  }
}
