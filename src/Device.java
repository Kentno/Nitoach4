public class Device {
    private int id;
    private String name;
    private boolean open;
    private boolean isExtreme;
    private int minHeight = 0;
    private int minAge = 0;
    private int minWeight = 0;
    private int maxWeight = 1000;
    private static int counter = 1;

    public Device(String name, boolean open, boolean isExtreme, int minHeight, int minAge, int minWeight, int maxWeight) {
        this.id = counter++;
        this.name = name;
        this.open = open;
        this.isExtreme = isExtreme;
        this.minHeight = minHeight;
        this.minAge = minAge;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        Runtime.systemObjects.add(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String){
            return obj.equals(this.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isExtreme() {
        return isExtreme;
    }

    public void setExtreme(boolean extreme) {
        isExtreme = extreme;
    }

    public boolean canRide(Child c){
        return !(c.getAge() < this.minAge | c.getHeight() < this.minHeight | c.getWeight() < this.minWeight | c.getWeight() > this.maxWeight);
    }



}
