package HW8_Java_model;

import HW8_Java_model.handler.*;

import java.util.List;
import java.util.stream.IntStream;

public class VendingMachine {
    private final StateOfVendingMachine stateOfVendingMachine;
    private List<Snack> snackStock;
    private final SnackDispenseHandler snackDispenseHandler;

    public VendingMachine() {
        this.stateOfVendingMachine = new StateOfVendingMachine();
        loadAllSnacks();
        // this is kind of cycle, once the snack is properly dispensed the state will move to the idle
        // next state of the ide should be the snack selection for next snack!
        this.snackDispenseHandler = new IdleStateHandler();
        this.snackDispenseHandler.setNextHandler(new SnackSelectionhandler()).setNextHandler(new PaymentHandler()).setNextHandler(new DispenserHandler())
                .setNextHandler(this.snackDispenseHandler);
        stateOfVendingMachine.setIdleState();
    }

    private void loadAllSnacks() {
        this.snackStock = List.of(
                new Snack("Coke", 2.99, 15),
                new Snack("Pepsi", 1.99, 10),
                new Snack("Cheetos", 1.49, 20),
                new Snack("Doritos", 3.49, 12),
                new Snack("Snickers", 1.29, 25),
                new Snack("KitKat", 2.49, 18)
        );
    }

    public void listAllAvailableSnacks() {
        IntStream.rangeClosed(1, this.snackStock.size()).forEach(value -> System.out.println(value + ") " + this.snackStock.get(value - 1).getName() + " : " + this.snackStock.get(value - 1).getPrice()));
    }

    public StateOfVendingMachine getStateOfVendingMachine() {
        return this.stateOfVendingMachine;
    }

    public List<Snack> getSnackStock() {
        return this.snackStock;
    }

    public void selectSnack(int snackItemIndex) {
        if(!isValidTransitionState(StateOfVendingMachine.VendingState.PICK_SNACK)) {
            System.out.println("Not valid transition state.");
            return;
        }
        this.stateOfVendingMachine.setCurrentSnackSelection(snackItemIndex);
        this.stateOfVendingMachine.setPickSnackState();
        this.snackDispenseHandler.handle(this);
    }

    public void insertMoney(double money) {
        if(!isValidTransitionState(StateOfVendingMachine.VendingState.WAITING_FOR_PAYMENT)) {
            System.out.println("Not valid transition state.");
            return;
        }
        this.stateOfVendingMachine.setCurrentInsertedMoney(money);
        this.stateOfVendingMachine.setWaitingForMoneyState();
        this.snackDispenseHandler.handle(this);
    }

    public void dispenseSnack() {
        if(!isValidTransitionState(StateOfVendingMachine.VendingState.DISPENSING)) {
            System.out.println("Not valid transition state.");
            return;
        }
        this.stateOfVendingMachine.setDispensingState();
        this.snackDispenseHandler.handle(this);
        // its does not matter if snack has been dispensed or not
        // at this level we should progress to the idle state
        this.stateOfVendingMachine.setIdleState();
    }

    public StateOfVendingMachine.VendingState getCurrentState() {
        return stateOfVendingMachine.getVendingMachineState();
    }

    public boolean isValidTransitionState(StateOfVendingMachine.VendingState vendingState) {
        StateOfVendingMachine.VendingState currentState = getCurrentState();
        return switch (currentState) {
            case IDLE -> vendingState == StateOfVendingMachine.VendingState.PICK_SNACK;
            case PICK_SNACK -> vendingState == StateOfVendingMachine.VendingState.WAITING_FOR_PAYMENT;
            case WAITING_FOR_PAYMENT -> vendingState == StateOfVendingMachine.VendingState.DISPENSING;
            default -> false;
        };
    }

}
