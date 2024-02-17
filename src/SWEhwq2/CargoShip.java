package SWEhwq2;

public class CargoShip extends Ship{
    private int cargoCap;

    public CargoShip(String shipName, String builtYear,int cargoCap){
        super(shipName,builtYear);
        this.cargoCap = cargoCap;
    }

    public void setCargoCap(int cargoCap) {
        this.cargoCap = cargoCap;
    }

    public int getCargoCap() {
        return cargoCap;
    }

    @Override
    public void print() {
        System.out.println("[CargoShip] Ship name is " + this.getShipName() +
                ", built in " + this.getBuiltYear() + " , and cargo capacity is " + this.cargoCap + " metric tonnes.");
    }


}
