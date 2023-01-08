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
    public static Device mamba = new Device("Mamba ride", true,true,140,12,0,1000);
    public static Device giantWheel = new Device("Giant Wheel", true,false,0,0,0,1000);
    public static Device carrousel = new Device("Carrousel", true,false,0,8,0,1000);
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
                    break;
                case 4:
                    break;
                case 5:
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
