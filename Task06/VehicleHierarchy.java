class Vehicle {

    protected String regNo;

    public Vehicle(String regNo) {
        this.regNo = regNo;
        System.out.println("Vehicle constructor called");
    }

    public void display() {
        System.out.println("Registration Number: " + regNo);
    }
}

class Car extends Vehicle {

    protected String model;

    public Car(String regNo, String model) {
        super(regNo);
        this.model = model;
        System.out.println("Car constructor called");
    }
}

class ElectricCar extends Car {

    private int batteryCapacity;

    public ElectricCar(String regNo, String model, int batteryCapacity) {
        super(regNo, model);
        this.batteryCapacity = batteryCapacity;
        System.out.println("ElectricCar constructor called");
    }

    public void displayDetails() {
        display();
        System.out.println("Model: " + model);
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class TwoWheeler extends Vehicle {

    public TwoWheeler(String regNo) {
        super(regNo);
        System.out.println("TwoWheeler constructor called");
    }
}

public class VehicleHierarchy {

    public static void main(String[] args) {

        System.out.println("Creating Electric Car:");
        ElectricCar ev = new ElectricCar("TN01AB1234", "Tata Nexon EV", 40);

        System.out.println("\nElectric Car Details:");
        ev.displayDetails();

        System.out.println("\nCreating Two Wheeler:");
        TwoWheeler bike = new TwoWheeler("TN02CD5678");
        bike.display();
    }
}