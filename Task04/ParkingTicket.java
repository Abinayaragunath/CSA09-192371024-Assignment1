import java.time.LocalDateTime;

public class ParkingTicket {

    private String ticketNo;
    private String vehicleNo;
    private int floor;
    private int slot;
    private LocalDateTime entryTime;

    // Default constructor
    public ParkingTicket() {
        this("TKT001", "UNKNOWN", 0, 0);
    }

    // Parameterized constructor
    public ParkingTicket(String ticketNo, String vehicleNo, int floor, int slot) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
        this.floor = floor;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    // Overloaded constructor
    public ParkingTicket(String ticketNo, String vehicleNo) {
        this(ticketNo, vehicleNo, 0, 0);
    }

    // Copy constructor
    public ParkingTicket(ParkingTicket other) {
        this(other.ticketNo, other.vehicleNo, other.floor, other.slot);
        this.entryTime = other.entryTime;
    }

    public void displayTicket() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Floor: " + floor);
        System.out.println("Slot: " + slot);
        System.out.println("Entry Time: " + entryTime);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        ParkingTicket t1 = new ParkingTicket();

        ParkingTicket t2 = new ParkingTicket(
                "TKT002", "TN01AB1111", 1, 2);

        ParkingTicket t3 = new ParkingTicket(
                "TKT003", "TN02CD2222");

        ParkingTicket t4 = new ParkingTicket(t2);

        t1.displayTicket();
        t2.displayTicket();
        t3.displayTicket();
        t4.displayTicket();
    }
}