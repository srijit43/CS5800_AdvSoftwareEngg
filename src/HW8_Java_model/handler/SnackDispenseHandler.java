package HW8_Java_model.handler;



import HW8_Java_model.VendingMachine;


public abstract class SnackDispenseHandler {
    private SnackDispenseHandler nextHandler;

    public SnackDispenseHandler setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
        return this.nextHandler;
    }

    public abstract void handle(VendingMachine vendingMachine);

    public SnackDispenseHandler handleNext() {
        if (this.nextHandler == null) {
            return null;
        }
        return this.nextHandler;
    }
}
