
public class DataRepresentation {

    public static void main(String[] args) {

        // Create a jagged array
        String[][] slots = new String[3][];

        // Assign different numbers of slots
        slots[0] = new String[3];
        slots[1] = new String[2];
        slots[2] = new String[4];

        // Allocate vehicles
        slots[0][0] = "TN01AB1111";
        slots[1][0] = "TN02CD2222";
        slots[2][2] = "TN03EF3333";

        // Display parking slots
        for (int floor = 0; floor < slots.length; floor++) {

            System.out.println("Floor " + floor);

            for (int slot = 0; slot < slots[floor].length; slot++) {

                if (slots[floor][slot] == null) {
                    System.out.println("Slot " + slot + " : Free");
                } else {
                    System.out.println("Slot " + slot + " : " + slots[floor][slot]);
                }
            }
        }
    }
}
