package SWE_homework2model;

// Abstract Factory for Macronutrients
interface MacronutrientFactory {
    default String createCarb(){
        throw new RuntimeException("not implemented");
    }
    default String createProtein(){
        throw new RuntimeException("not implemented");
    }
    default String createFat(){
        throw new RuntimeException("not implemented");
    }
}
