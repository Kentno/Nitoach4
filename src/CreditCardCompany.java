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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
