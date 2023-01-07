public class CreditCard {
    private String id;
    private int limit;
    private CreditCardCompany ccc;

    public CreditCard(String id, int limit, String ccc) {
        this.id = id;
        this.limit = limit;
        Runtime.systemObjects.add(this);
        for (Object o : Runtime.systemObjects){
            if (o.equals(ccc)){
                assert o instanceof CreditCardCompany;
                this.ccc = ((CreditCardCompany) o);
                return;
            }
        }
        this.ccc = new CreditCardCompany(ccc);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
