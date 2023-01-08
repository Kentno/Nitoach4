import javax.swing.border.EtchedBorder;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalTime;

public class Runtime {
    public static List<Object> systemObjects = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static Park park = new Park();
    public static Map map = new Map();
    public static App app = new App();
    public static Device mamba = new Device("Mamba Ride", true, true, 140, 12, 0, 1000);
    public static Device giantWheel = new Device("Giant Wheel", true, false, 0, 0, 0, 1000);
    public static Device carrousel = new Device("Carrousel", true, false, 0, 8, 0, 1000);
    private static final Guardian currentUser = new Guardian();



    public static void main(String[] args){
        systemObjects.add(park);
        systemObjects.add(map);
        systemObjects.add(app);
        systemObjects.add(currentUser);
        boolean userInit = false;
        while (true) {
            System.out.println(systemObjects);
            System.out.println("Welcome to ePark!");
            System.out.println("""
                    1) Register child
                    2) Manage ticket  
                    3) Add ride
                    4) Remove ride
                    5) Exit park
                    6) Exit
                    """);
            int pick = scanner.nextInt();
            switch (pick){
                default:
                    System.out.println("Illegal character.");
                    break;
                case 1:
                    currentUser.FillRegisterForm();
                    break;
                case 2:
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Which child would you like to add the ride to? Please type his/her exact name:");
                    String childName = Runtime.scanner.nextLine();
                    List<Child> clist = currentUser.getChildren();
                    Child child = null;
                    for (Child c : clist)
                        if (Objects.equals(c.getName(), childName)) {
                            child = c;
                            break;
                        }
                    if (child == null) {
                        System.out.println("There is no child registered with that name.");
                        continue;
                    }

                    if (child.getEticket().getAllowedDevices().size() >= child.getEticket().getCreditCard().getLimit()) {
                        System.out.println("There is not enough money in your credit card to add another ride.");
                        break;
                    }
                    System.out.println("Which ride would you like to add? Please type its exact name:");
                    String deviceName = Runtime.scanner.nextLine();

                    if (Objects.equals(deviceName, "Carrousel")) {
                        if (carrousel.canRide(child) && carrousel.isOpen())
                            child.getEticket().addRide(carrousel);
                        else {
                            System.out.println("The child isn't allowed to ride or the ride is unavailable at the moment.");
                        }
                    } else if (Objects.equals(deviceName, "Mamba Ride")) {
                        String extremeAnswer = null;
                        System.out.println("This is an extreme ride, are you sure you want to allow your child to enter this ride? (y,n)?");
                        while (true) {
                            extremeAnswer = Runtime.scanner.nextLine();
                            if (Objects.equals(extremeAnswer, "n") || (Objects.equals(extremeAnswer, "y")))
                                break;
                            System.out.println("invalid character. Enter again:");
                        }
                        if (Objects.equals(extremeAnswer, "n"))
                            break;
                        if (mamba.canRide(child) && mamba.isOpen())
                            child.getEticket().addRide(mamba);
                        else {
                            System.out.println("Either the child isn't allowed to ride, or the ride is unavailable at the moment.");
                        }
                    } else if (Objects.equals(deviceName, "Giant Wheel")) {
                        if (giantWheel.canRide(child) && giantWheel.isOpen()) {
                            child.getEticket().addRide(giantWheel);
                        } else {
                            System.out.println("Either the child isn't allowed to ride, or the ride is unavailable at the moment.");
                        }
                    } else
                        System.out.println("This ride doesn't exist in our park.");
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Which child would you like to add the ride to? Please type it's exact name");
                    String childName1 = Runtime.scanner.nextLine();
                    List<Child> childList1 = currentUser.getChildren();
                    Child child1 = null;
                    for (Child c : childList1)
                        if (Objects.equals(c.getName(), childName1)) {
                            child1 = c;
                            break;
                        }
                    if (child1 == null) {
                        System.out.println("There is no child registered with that name.");
                    } else {
                        System.out.println("Which ride would you like to remove? Please type it's exact name");
                        String deviceName1 = Runtime.scanner.nextLine();

                        if (Objects.equals(deviceName1, "Carrousel")) {
                            currentUser.removeRide(carrousel, child1.getEticket());
                        } else if (Objects.equals(deviceName1, "Mamba Ride")) {
                            if (mamba.canRide(child1) && mamba.isOpen()) {
                                child1.getEticket().addRide(mamba);
                            } else {
                                System.out.println("Either the child isn't allowed to ride, or the ride is unavailable at the moment.");
                            }
                        } else if (Objects.equals(deviceName1, "Giant Wheel")) {
                            if (giantWheel.canRide(child1) && giantWheel.isOpen()) {
                                child1.getEticket().addRide(giantWheel);
                            } else {
                                System.out.println("Either the child isn't allowed to ride, or the ride is unavailable at the moment.");
                            }
                        }
                    }

                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Which child would you like to exit the park? Please type his/her exact name:");
                    String childName2 = Runtime.scanner.nextLine();
                    List<Child> clist2 = currentUser.getChildren();
                    Child child2 = null;
                    for (Child c : clist2)
                        if (Objects.equals(c.getName(), childName2)) {
                            child2 = c;
                            break;
                        }
                    if (child2 == null) {
                        System.out.println("There is no child registered with that name.");
                        break;
                    }
                    ETicket et2 = child2.getEticket();
                    CreditCard cc2 = et2.getCreditCard();
                    CreditCardCompany ccc2 = cc2.getCcc();
                    boolean flag = true;
                    for (Object o : Runtime.systemObjects) {
                        if (o instanceof CreditCard & o != cc2) {//no need to delete credit card company
                            if (ccc2.equals(o)) {
                                flag = false;
                            }
                        }
                    }
                    if (!ccc2.chargeCreditCard(cc2, et2.getAllowedDevices().size())) {
                        System.out.println("Credit Card declined, the police are on their way.");
                    }
                    if (flag) {
                        systemObjects.remove(ccc2);
                    }
                    systemObjects.remove(cc2);
                    systemObjects.remove(et2);
                    systemObjects.remove(child2);
                    System.out.println("Child has exited the park successfully");

                    break;
                case 6:
                    return;
            }
            System.out.println("\n\n");
        }
    }

    public static int getInt() {
        int i = -1;
        while (i < 0) {
            try {
                i = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Not a number, please try again: ");
                scanner.nextLine();
            }
        }
        return i;
    }
}
