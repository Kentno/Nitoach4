import java.util.ArrayList;
import java.util.List;

public class Account {
        private List<String> purchasesAndRefunds;
        private List<CreditCard> creditCards;
        private List<Child> children;
        private List<ETicket> eTickets;
        private Guardian user;

    public Account(Guardian user) {
        this.user = user;
        this.purchasesAndRefunds = new ArrayList<>();
        this.creditCards = new ArrayList<>();
        this.children = new ArrayList<>();
        this.eTickets = new ArrayList<>();
        Runtime.systemObjects.add(this);
    }

    public void addCC(CreditCard cc){
        this.creditCards.add(cc);
    }

    public void addChild(Child c){
        this.children.add(c);
    }

    public void addETicket(ETicket et){
        this.eTickets.add(et);
    }

    public void addPruchaseOrRefund(String s){
        this.purchasesAndRefunds.add(s);
    }
}
