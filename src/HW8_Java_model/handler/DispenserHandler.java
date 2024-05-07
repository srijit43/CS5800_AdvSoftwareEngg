package HW8_Java_model.handler;


import HW8_Java_model.Snack;
import HW8_Java_model.StateOfVendingMachine;
import HW8_Java_model.VendingMachine;

public class DispenserHandler extends SnackDispenseHandler {
    @Override
    public void handle(VendingMachine vendingMachine) {
        if (vendingMachine.getStateOfVendingMachine().getVendingMachineState() == StateOfVendingMachine.VendingState.DISPENSING) {
            int userSelectedSnackIndex = vendingMachine.getStateOfVendingMachine().getCurrentSnackSelection();
            double userInsertedMoney = vendingMachine.getStateOfVendingMachine().getCurrentInsertedMoney();
            Snack userSelectedSnack = vendingMachine.getSnackStock().get(userSelectedSnackIndex);
            if (userSelectedSnack.getQuantity() <= 0) {
                System.out.println("DispenserHandler : There are not enough " + userSelectedSnack.getName() +" available, so returning the money");
                return;
            }
            // decrease the quantity
            userSelectedSnack.setQuantity(userSelectedSnack.getQuantity() - 1);
            System.out.println("DispenserHandler : Snack " + userSelectedSnack.getName() + " Has been dispensed. Balance of $" + (userInsertedMoney - userSelectedSnack.getPrice()) +  "  returned.");
            return;
        }
        // move to next idle
        this.handleNext().handle(vendingMachine);
    }
}