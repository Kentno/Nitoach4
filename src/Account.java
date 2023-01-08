import java.util.ArrayList;
import java.util.List;

public class Account {
        private List<String> purchasesAndRefunds;
        private List<Child> children;
        private List<ETicket> eTickets;
        private Guardian user;



    public Account(Guardian user) {
        this.user = user;
        this.purchasesAndRefunds = new ArrayList<>();
        this.children = new ArrayList<>();
        this.eTickets = new ArrayList<>();
        Runtime.systemObjects.add(this);
    }


    public List<ETicket> geteTickets() {
        return eTickets;
    }


    public void addChild(Child c){
        this.children.add(c);
    }

    public void addETicket(ETicket et){
        this.eTickets.add(et);
    }

    public void addPurchaseOrRefund(String s){
        this.purchasesAndRefunds.add(s);
    }

}
