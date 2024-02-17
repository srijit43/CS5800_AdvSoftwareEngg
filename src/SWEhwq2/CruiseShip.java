package SWEhwq2;

public class CruiseShip extends Ship {
    private int maxCapacity;

    public CruiseShip(String shipName, String builtYear, int maxCapacity){
        super(shipName,builtYear);
        this.maxCapacity = maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public void print() {
        System.out.println("[CruiseShip] Ship name is " + this.getShipName() +
                ", built in " + this.getBuiltYear() + " , and maximum passenger capacity is " + this.maxCapacity + ".");
    }
}
