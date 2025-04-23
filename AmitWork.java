public class Main {
    public static void main(String[] args) {

        MobilePhone myPhone = new MobilePhone("Samsung", "S21", 2000);
        MobilePhone yoniPhone = new MobilePhone("Samsung", "A73", 1600);

        System.out.println("Before discount:\n");
        myPhone.printDetails();
        yoniPhone.printDetails();

        System.out.println("\nApplying 10% discount...\n");
        myPhone.discount();
        yoniPhone.discount();

        System.out.println("\nAfter discount:\n");
        myPhone.printDetails();
        yoniPhone.printDetails();
    }
}

class MobilePhone {
    String brand;
    String model;
    double price;

    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void printDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price + "\n");
    }

    public void discount() {
        price = price - (price * 0.10);
