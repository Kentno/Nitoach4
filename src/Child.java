public class Child {
    private int id, age, height, weight;
    private ETicket eticket;
    private static int counter = 1;
    public Child(int weight,int height, int age) {//worst then a rapist
        this.id = counter++;
        this.weight = weight;
        this.height = height;
        this.age = age;
        Runtime.systemObjects.add(this);
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

}
