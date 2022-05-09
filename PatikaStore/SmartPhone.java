package PatikaStore;
public class SmartPhone extends Product {

    private int camera;
    private int batteryCapacity;
    private String color;

    public SmartPhone(int id, double price, double discountRate, int stock, String productName, String brand, int storage, int screenSize, int ram, int camera, int batteryCapacity, String color) {
        super(id, price, discountRate, stock, productName, brand, storage, screenSize, ram);
        this.camera = camera;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
