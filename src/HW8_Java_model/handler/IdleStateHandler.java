package HW8_Java_model.handler;

import HW8_Java_model.StateOfVendingMachine;
import HW8_Java_model.VendingMachine;

public class IdleStateHandler extends SnackDispenseHandler {
    @Override
    public void handle(VendingMachine vendingMachine) {
        if (vendingMachine.getStateOfVendingMachine().getVendingMachineState() == StateOfVendingMachine.VendingState.IDLE) {
            // refresh the state
            vendingMachine.getStateOfVendingMachine().setCurrentSnackSelection(-1);
            vendingMachine.getStateOfVendingMachine().setCurrentInsertedMoney(0);
            vendingMachine.getStateOfVendingMachine().setIdleState();
        } else {
            this.handleNext().handle(vendingMachine);
        }
    }
}