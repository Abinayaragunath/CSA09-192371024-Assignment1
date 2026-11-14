import java.util.Objects;

class Vehicle {

    protected String regNo;

    public Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public double calculateFee() {
        return 50.0;
    }

    public final void displayRules() {
        System.out.println("Parking rules apply to all vehicles.");
    }

    @Override
    public String toString() {
        return "Vehicle Registration Number: " + regNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vehicle other = (Vehicle) obj;
        return Objects.equals(regNo, other.regNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo);
    }
}

class Car extends Vehicle {

    public Car(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee() {
        return 100.0;
    }
}

public class VehicleOverride {

    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("TN01AB1234");
        Vehicle v2 = new Vehicle("TN01AB1234");
        Car car = new Car("TN02CD5678");

        System.out.println("Vehicle Details:");
        System.out.println(v1);

        System.out.println("\nCar Details:");
        System.out.println(car);

        System.out.println("\nParking Fees:");
        System.out.println("Vehicle Fee: Rs." + v1.calculateFee());
        System.out.println("Car Fee: Rs." + car.calculateFee());

        System.out.println("\nObject Comparison:");
        System.out.println("v1 equals v2: " + v1.equals(v2));

        System.out.println("\nHash Codes:");
        System.out.println("v1: " + v1.hashCode());
        System.out.println("v2: " + v2.hashCode());

        System.out.println("\nFinal Method:");
        v1.displayRules();
    }
}