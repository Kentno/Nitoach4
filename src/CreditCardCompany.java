public class CreditCardCompany {
    String name;

    public CreditCardCompany(String name) {
        this.name = name;
        Runtime.systemObjects.add(this);
    }
    // This method is not functional within the bounds of the current system
    public static boolean isValid(String number){
        return true;
    }

    public boolean chargeCreditCard(CreditCard cc, int sum){
        return cc.getLimit() >= sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String){
            return obj.equals(this.name);
        }
        return false;
    }
}
