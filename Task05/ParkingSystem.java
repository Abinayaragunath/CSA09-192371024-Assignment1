public class ParkingSystem {

    private static int ticketCounter = 0;
    private static int totalOccupancy = 0;

    private String facilityName;

    public ParkingSystem(String facilityName) {
        this.facilityName = facilityName;
    }

    public ParkingTicket createTicket(String vehicleNo) {
        ticketCounter++;
        totalOccupancy++;

        return new ParkingTicket(
                "TKT" + String.format("%03d", ticketCounter),
                vehicleNo, 1, totalOccupancy
        );
    }

    public void vehicleLeaves() {
        if (totalOccupancy > 0) {
            totalOccupancy--;
        }
    }

    public static int getTicketCounter() {
        return ticketCounter;
    }

    public static int getTotalOccupancy() {
        return totalOccupancy;
    }

    public void displayFacility() {
        System.out.println("Facility: " + facilityName);
        System.out.println("Total Tickets: " + getTicketCounter());
        System.out.println("Current Occupancy: " + getTotalOccupancy());
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        ParkingSystem northGate = new ParkingSystem("North Gate");
        ParkingSystem southGate = new ParkingSystem("South Gate");

        ParkingTicket t1 = northGate.createTicket("TN01AB1111");
        ParkingTicket t2 = southGate.createTicket("TN02CD2222");

        t1.displayTicket();
        t2.displayTicket();

        northGate.displayFacility();
        southGate.displayFacility();

        northGate.vehicleLeaves();

        System.out.println("After one vehicle leaves:");
        System.out.println("Total Occupancy: " + getTotalOccupancy());
    }
}

class ParkingTicket {

    private String ticketNo;
    private String vehicleNo;
    private int floor;
    private int slot;

    public ParkingTicket(String ticketNo, String vehicleNo,
                         int floor, int slot) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
        this.floor = floor;
        this.slot = slot;
    }

    public void displayTicket() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Floor: " + floor);
        System.out.println("Slot: " + slot);
        System.out.println("----------------------");
    }
}