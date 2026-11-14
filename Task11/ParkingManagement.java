import java.util.ArrayList;

class ParkingTicket {

    private String vehicleNo;
    private int floor;
    private int slot;

    public ParkingTicket(String vehicleNo, int floor, int slot) {
        this.vehicleNo = vehicleNo;
        this.floor = floor;
        this.slot = slot;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public int getFloor() {
        return floor;
    }

    public int getSlot() {
        return slot;
    }

    public void display() {
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Floor: " + floor);
        System.out.println("Slot: " + slot);
    }
}

class ParkingManagement {

    private String[][] slots;
    private ArrayList<ParkingTicket> activeTickets = new ArrayList<>();

    public ParkingManagement(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];

        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }
    }

    public void parkVehicle(String vehicleNo) {

        if (vehicleNo == null || vehicleNo.trim().isEmpty()) {
            System.out.println("Invalid vehicle number.");
            return;
        }

        for (ParkingTicket ticket : activeTickets) {
            if (ticket.getVehicleNo().equalsIgnoreCase(vehicleNo)) {
                System.out.println("Vehicle is already parked.");
                return;
            }
        }

        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {

                if (slots[f][s] == null) {
                    slots[f][s] = vehicleNo;

                    ParkingTicket ticket =
                            new ParkingTicket(vehicleNo, f, s);

                    activeTickets.add(ticket);

                    System.out.println("Vehicle parked successfully.");
                    ticket.display();
                    return;
                }
            }
        }

        System.out.println("Parking is full.");
    }

    public void releaseVehicle(String vehicleNo) {

        for (int i = 0; i < activeTickets.size(); i++) {

            ParkingTicket ticket = activeTickets.get(i);

            if (ticket.getVehicleNo().equalsIgnoreCase(vehicleNo)) {

                slots[ticket.getFloor()][ticket.getSlot()] = null;
                activeTickets.remove(i);

                System.out.println("Vehicle released successfully.");
                return;
            }
        }

        System.out.println("Vehicle not found.");
    }

    public void displayOccupancy() {

        System.out.println("\nParking Occupancy:");

        for (int f = 0; f < slots.length; f++) {
            System.out.println("Floor " + f);

            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    System.out.println("Slot " + s + ": Free");
                } else {
                    System.out.println("Slot " + s + ": " + slots[f][s]);
                }
            }
        }

        System.out.println("Active Vehicles: " + activeTickets.size());
    }

    public static void main(String[] args) {

        ParkingManagement parking =
                new ParkingManagement(new int[]{2, 2});

        System.out.println("CAMPUS SMART PARKING SYSTEM");

        parking.parkVehicle("TN01AB1111");
        parking.parkVehicle("TN02CD2222");
        parking.parkVehicle("TN03EF3333");
        parking.parkVehicle("TN04GH4444");

        parking.displayOccupancy();

        System.out.println("\nTesting Boundary Case:");
        parking.parkVehicle("TN05IJ5555");

        System.out.println("\nTesting Duplicate Vehicle:");
        parking.parkVehicle("TN01AB1111");

        System.out.println("\nTesting Invalid Vehicle:");
        parking.parkVehicle("");

        System.out.println("\nTesting Release:");
        parking.releaseVehicle("TN02CD2222");

        parking.displayOccupancy();

        System.out.println("\nTesting Invalid Release:");
        parking.releaseVehicle("TN99ZZ9999");
    }
}