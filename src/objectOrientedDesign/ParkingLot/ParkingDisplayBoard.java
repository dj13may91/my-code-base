package objectOrientedDesign.ParkingLot;

public class ParkingDisplayBoard {
  String displaySpotInfo;
  int totalFreeSpots;

  public String getDisplaySpotInfo(ParkingFloor floor){
    StringBuilder builder = new StringBuilder("Available free spots: ");
    if(floor.parkingSpotMap.size() > 0){

      return String.valueOf(builder);
    }
    return "No free spots available!!";
  }
}
