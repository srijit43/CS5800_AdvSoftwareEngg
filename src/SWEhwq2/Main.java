package SWEhwq2;

import java.util.ArrayList;
import java.util.List;

/**
 * /*Driver class for the question*/

public class Main {
    public static void main(String[] args) {

        List<Ship> shipList = new ArrayList<>();

        shipList.add(new Ship("HMS Edward Mounty", "1985"));
        shipList.add(new CargoShip("Bengal Freight", "1993", 30000));
        shipList.add(new CruiseShip("Kolkata Carnival", "1994", 200));

        shipList.forEach(ship -> ship.print());
    }
}
