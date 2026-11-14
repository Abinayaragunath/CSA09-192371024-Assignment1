interface Chargeable {
    double chargingFee();
}

abstract class Vehicle {

    protected String regNo;

    public Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public abstract double calculateFee();

    public void display() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Parking Fee: Rs." + calculateFee());
    }

    public void display(String vehicleType) {
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

class TwoWheeler extends Vehicle {

    public TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee() {
        return 30.0;
    }
}

class Car extends Vehicle {

    public Car(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee() {
        return 50.0;
    }
}

class ElectricCar extends Car implements Chargeable {

    public ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee() {
        return 70.0;
    }

    @Override
    public double chargingFee() {
        return 20.0;
    }
}

public class FeeDemo {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
            new TwoWheeler("TN01AB1234"),
            new Car("TN02CD5678"),
            new ElectricCar("TN03EF9012")
        };

        System.out.println("Campus Smart Parking Fee Details");
        System.out.println("--------------------------------");

        for (Vehicle vehicle : vehicles) {
            vehicle.display();
            System.out.println();
        }

        System.out.println("Compile-time Polymorphism:");

        Car car = new Car("TN04GH3456");
        car.display("Car");

        System.out.println("\nInterface Method:");

        ElectricCar ev = new ElectricCar("TN05IJ7890");
        System.out.println("Charging Fee: Rs." + ev.chargingFee());
    }
}