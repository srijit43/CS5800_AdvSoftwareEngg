package HW8_Java_model.handler;

import HW8_Java_model.Snack;
import HW8_Java_model.StateOfVendingMachine;
import HW8_Java_model.VendingMachine;

public class PaymentHandler extends SnackDispenseHandler {
    @Override
    public void handle(VendingMachine vendingMachine) {
        if (vendingMachine.getStateOfVendingMachine().getVendingMachineState() == StateOfVendingMachine.VendingState.WAITING_FOR_PAYMENT) {
            int userSelectedSnackIndex = vendingMachine.getStateOfVendingMachine().getCurrentSnackSelection();
            double userInsertedMoney = vendingMachine.getStateOfVendingMachine().getCurrentInsertedMoney();
            Snack userSelectedSnack = vendingMachine.getSnackStock().get(userSelectedSnackIndex);
            if (userInsertedMoney < userSelectedSnack.getPrice()) {
                System.out.println("PaymentHandler : User does not have enough money to dispense item. The snack cost $" + userSelectedSnack.getPrice());
                return;
            }
            System.out.println("PaymentHandler : User has enough money to buy snack.");
        } else {
            // move to next
            this.handleNext().handle(vendingMachine);
        }

    }
}