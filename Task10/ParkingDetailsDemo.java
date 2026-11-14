class ParkingDetails {

    private String vehicleNo;
    private int floor;
    private double parkingFee;

    public ParkingDetails(String vehicleNo, int floor, double parkingFee) {
        this.vehicleNo = vehicleNo;
        this.floor = floor;
        this.parkingFee = parkingFee;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        if (floor >= 0) {
            this.floor = floor;
        }
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        if (parkingFee >= 0) {
            this.parkingFee = parkingFee;
        }
    }
}

public class ParkingDetailsDemo {

    public static void main(String[] args) {

        ParkingDetails parking = new ParkingDetails("TN01AB1234", 1, 100.0);

        System.out.println("Vehicle Number: " + parking.getVehicleNo());
        System.out.println("Floor: " + parking.getFloor());
        System.out.println("Parking Fee: Rs." + parking.getParkingFee());

        parking.setVehicleNo("TN02CD5678");
        parking.setFloor(2);
        parking.setParkingFee(150.0);

        System.out.println("\nUpdated Parking Details:");
        System.out.println("Vehicle Number: " + parking.getVehicleNo());
        System.out.println("Floor: " + parking.getFloor());
        System.out.println("Parking Fee: Rs." + parking.getParkingFee());

        Integer totalFee = (int) parking.getParkingFee();

        System.out.println("\nWrapper Class:");
        System.out.println("Total Fee: Rs." + totalFee);
    }
}