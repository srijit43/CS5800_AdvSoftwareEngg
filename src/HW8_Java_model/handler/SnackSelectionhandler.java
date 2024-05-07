package HW8_Java_model.handler;

import HW8_Java_model.StateOfVendingMachine;
import HW8_Java_model.VendingMachine;

public class SnackSelectionhandler extends SnackDispenseHandler {
    @Override
    public void handle(VendingMachine vendingMachine) {
        if (vendingMachine.getStateOfVendingMachine().getVendingMachineState() == StateOfVendingMachine.VendingState.PICK_SNACK) {
            if (vendingMachine.getStateOfVendingMachine().getCurrentSnackSelection() >= vendingMachine.getSnackStock().size()) {
                System.out.println("Invalid Snack, please select valid snack");
                return;
            }
            System.out.println("Its valid snack option, the snack option is available");
            return;
        }
        // move to next handler
        this.handleNext().handle(vendingMachine);
    }
}