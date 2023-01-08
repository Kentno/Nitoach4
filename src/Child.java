public class Child {
    private int id, age, height, weight;
    private String name;
    private ETicket eticket;
    private static int counter = 1;
    public Child(int weight,int height, int age, String name) {//worst then a rapist
        this.id = counter++;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.name = name;
        Runtime.systemObjects.add(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof String){
            return obj.equals(this.name);
        }
        return false;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setEticket(ETicket eticket) {
        this.eticket = eticket;
    }

    public ETicket getEticket(){return this.eticket;}

    public String getName(){return name;}

}
