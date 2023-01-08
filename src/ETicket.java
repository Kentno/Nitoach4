import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ETicket {
    private final int id;
    private int ridesLeft;
    private LocalTime timeLimit;
    private Child child;
    private ArrayList<Device> allowedDevices;
    private final CreditCard cc;

    public CreditCard getCreditCard() {
        return cc;
    }

    public ETicket(int rideLimit, LocalTime timeLimit, CreditCard creditCard) {
        id = counter++;
        this.ridesLeft = rideLimit;
        this.timeLimit = timeLimit;
        this.cc = creditCard;
        Runtime.systemObjects.add(this);
    }
    public int getId() {
        return id;
    }

    public int getRidesLeft() {
        return ridesLeft;
    }

    public void setRidesLeft(int ridesLeft) {
        this.ridesLeft = ridesLeft;
    }

    public LocalTime getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalTime timeLimit) {
        this.timeLimit = timeLimit;
    }

    public List<Device> getAllowedDevices() {
        return allowedDevices;
    }

    public void addChild(Child child){
        this.child = child;
    }


    /**
     * Will check if child can ride device and if the E-Ticket does not already contain the device
     */
    public boolean addRide(Device device){
        if (device.canRide(this.child) & !this.allowedDevices.contains(device)){
            this.allowedDevices.add(device);
            return true;
        }
        return false;
    }

    public void removeRide(Device device){
        if(this.getAllowedDevices().contains(device)) {
            this.getAllowedDevices().remove(device);
            System.out.println("Device removed successfully");
        }
        else System.out.println("We have encountered a problem,\nThe chosen device is not the the allowed devices list for this E-ticket.");
    }

    private static int counter = 1;

}
