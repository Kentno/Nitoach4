import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Guardian {
    private int id;
    private ArrayList<Child> children;
    private CreditCard cc;
    private static int counter = 1;
    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Child> getChildren() {
        return children;
    }


    public Guardian() {
        children = new ArrayList<>();
        this.id = counter++;
        this.account = new Account(this);

    }
    public void FillRegisterForm(){
        System.out.println("please enter child's weight: ");
        int weight = Runtime.getInt();
        System.out.println("please enter child's height: ");
        int height = Runtime.getInt();
        System.out.println("please enter child's ID: ");
        int id = Runtime.getInt();
        System.out.println("please enter child's age: ");
        int age = Runtime.getInt();

        Child c = new Child(weight,height,age);
        children.add(c);
        this.account.addChild(c);
        System.out.println("Please enter the number of hours the E-Ticket will be valid for:");
        int timeLimit = Runtime.getInt();
        System.out.println("Please enter the number of rides the E-Ticket will be valid for:");
        int rideLimit = Runtime.getInt();
        ETicket ticket = new ETicket(rideLimit, LocalTime.now().plusHours(timeLimit), this.giveInfo());
        ticket.addChild(c);
        this.account.addETicket(ticket);
        c.setEticket(ticket);


        System.out.println("User succesfuly added");
    }
    public CreditCard giveInfo(){
        Runtime.scanner.nextLine();
        System.out.println("Please enter your credit card number: ");
        String ccID = Runtime.scanner.nextLine();
        if(!CreditCardCompany.isValid(ccID)){
            // due to non-functionality this path is not fully implemented
            System.out.println("cant create account pls try again later!");
        }
        System.out.println("Please enter your credit card limit: ");
        int limit = Runtime.getInt();
        System.out.println("Please enter your credit card company name: ");
        String cccName = Runtime.scanner.nextLine();
        cc = new CreditCard(ccID, limit, cccName);
        return cc;
    }


}
