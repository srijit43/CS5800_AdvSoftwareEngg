package SWEhwq2;

public class Ship {
    private String shipName;
    private String builtYear;

    public Ship(){

    }

    public Ship(String shipName, String builtYear){
        this.shipName = shipName;
        this.builtYear = builtYear;

    }

    public void setBuiltYear(String builtYear) {
        this.builtYear = builtYear;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getBuiltYear() {
        return builtYear;
    }

    public String getShipName() {
        return shipName;
    }

    public void print(){
        System.out.println("The ship name is " +shipName + " and it was built in year " +builtYear);
    }

}
