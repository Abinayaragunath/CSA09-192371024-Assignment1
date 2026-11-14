interface Payment {

    double calculatePayment();

    default void displayPaymentType() {
        System.out.println("Parking Payment");
    }

    static void showRules() {
        System.out.println("Payment must be completed before exit.");
    }
}

abstract class Vehicle {

    protected String regNo;

    public Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public abstract double calculateFee();

    public void displayDetails() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Parking Fee: Rs." + calculateFee());
    }
}

class Car extends Vehicle implements Payment {

    public Car(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee() {
        return 100.0;
    }

    @Override
    public double calculatePayment() {
        return calculateFee();
    }
}

public class VehicleAbstraction {

    public static void main(String[] args) {

        Car car = new Car("TN01AB1234");

        System.out.println("Vehicle Details:");
        car.displayDetails();

        System.out.println("\nPayment Details:");
        car.displayPaymentType();
        System.out.println("Total Payment: Rs." + car.calculatePayment());

        System.out.println("\nPayment Rules:");
        Payment.showRules();
    }
}