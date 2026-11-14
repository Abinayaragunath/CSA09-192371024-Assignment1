import java.time.LocalDateTime;
import java.util.ArrayList;

class ParkingRecord {

    String vehicleNo;
    String vehicleType;
    int floor;
    int slot;
    double fee;
    LocalDateTime entryTime;
    LocalDateTime passExpiry;

    public ParkingRecord(String vehicleNo, String vehicleType,
                         int floor, int slot, double fee,
                         LocalDateTime entryTime) {

        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.floor = floor;
        this.slot = slot;
        this.fee = fee;
        this.entryTime = entryTime;

        if (vehicleType.equalsIgnoreCase("VISITOR")) {
            passExpiry = entryTime.plusDays(1);
        }
    }

    public void display() {
        System.out.println("Vehicle Number: " + vehicleNo);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Floor: " + floor);
        System.out.println("Slot: " + slot);
        System.out.println("Parking Fee: Rs." + fee);

        if (passExpiry != null) {
            System.out.println("Visitor Pass Expires: " + passExpiry);
        }
    }
}

public class ParkingSystemUpdate {

    private ParkingRecord[][] slots;

    private ArrayList<ParkingRecord> activeRecords =
            new ArrayList<>();

    public ParkingSystemUpdate(int[] slotsPerFloor) {

        slots = new ParkingRecord[slotsPerFloor.length][];

        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new ParkingRecord[slotsPerFloor[i]];
        }
    }

    public double calculateFee(String vehicleType,
                               LocalDateTime entryTime) {

        switch (vehicleType.toUpperCase()) {

            case "E-BIKE":
                return 30.0;

            case "CAR":
                return 100.0;

            case "DELIVERY VAN":

                int hour = entryTime.getHour();

                if (hour >= 9 && hour < 17) {
                    return 200.0;
                }

                return 100.0;

            case "VISITOR":
                return 150.0;

            default:
                return -1;
        }
    }

    public void parkVehicle(String vehicleNo,
                            String vehicleType,
                            LocalDateTime entryTime) {

        if (vehicleNo == null || vehicleNo.trim().isEmpty()) {
            System.out.println("Invalid vehicle number.");
            return;
        }

        for (ParkingRecord record : activeRecords) {
            if (record.vehicleNo.equalsIgnoreCase(vehicleNo)) {
                System.out.println("Vehicle already parked.");
                return;
            }
        }

        double fee = calculateFee(vehicleType, entryTime);

        if (fee < 0) {
            System.out.println("Invalid vehicle type.");
            return;
        }

        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {

                if (slots[f][s] == null) {

                    ParkingRecord record = new ParkingRecord(
                            vehicleNo, vehicleType,
                            f, s, fee, entryTime
                    );

                    slots[f][s] = record;
                    activeRecords.add(record);

                    System.out.println("\nVehicle parked successfully.");
                    record.display();
                    return;
                }
            }
        }

        System.out.println("Parking is full.");
    }

    public void releaseVehicle(String vehicleNo) {

        for (int i = 0; i < activeRecords.size(); i++) {

            ParkingRecord record = activeRecords.get(i);

            if (record.vehicleNo.equalsIgnoreCase(vehicleNo)) {

                slots[record.floor][record.slot] = null;
                activeRecords.remove(i);

                System.out.println("Vehicle released successfully.");
                return;
            }
        }

        System.out.println("Vehicle not found.");
    }

    public void displayParking() {

        System.out.println("\nPARKING OCCUPANCY");

        for (int f = 0; f < slots.length; f++) {

            System.out.println("Floor " + (f + 1));

            for (int s = 0; s < slots[f].length; s++) {

                if (slots[f][s] == null) {
                    System.out.println("Slot " + s + ": Free");
                } else {
                    System.out.println("Slot " + s + ": "
                            + slots[f][s].vehicleNo);
                }
            }
        }

        System.out.println("Total Active Vehicles: "
                + activeRecords.size());
    }

    public static void main(String[] args) {

        // Five floors with different slot counts
        int[] floorCapacity = {3, 4, 2, 3, 5};

        ParkingSystemUpdate parking =
                new ParkingSystemUpdate(floorCapacity);

        LocalDateTime morning =
                LocalDateTime.of(2026, 11, 14, 10, 0);

        LocalDateTime evening =
                LocalDateTime.of(2026, 11, 14, 18, 0);

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println("===========================");

        System.out.println("\n1. E-BIKE TEST");
        parking.parkVehicle("TN01AB1111", "E-BIKE", morning);

        System.out.println("\n2. CAR TEST");
        parking.parkVehicle("TN02CD2222", "CAR", morning);

        System.out.println("\n3. DELIVERY VAN TEST");
        parking.parkVehicle("TN03EF3333", "DELIVERY VAN", morning);

        System.out.println("\n4. VISITOR PASS TEST");
        parking.parkVehicle("TN04GH4444", "VISITOR", morning);

        System.out.println("\n5. EVENING DELIVERY VAN TEST");
        parking.parkVehicle("TN05IJ5555", "DELIVERY VAN", evening);

        System.out.println("\n6. INVALID VEHICLE TYPE TEST");
        parking.parkVehicle("TN06KL6666", "BUS", morning);

        parking.displayParking();

        System.out.println("\n7. RELEASE VEHICLE TEST");
        parking.releaseVehicle("TN02CD2222");

        parking.displayParking();
    }
}