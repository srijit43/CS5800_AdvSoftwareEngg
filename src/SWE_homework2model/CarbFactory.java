package SWE_homework2model;

import java.util.Random;

// Concrete Factory for Carbs
class CarbFactory implements MacronutrientFactory {
    @Override
    public String createCarb() {
        String[] carbOptions = {"cheese", "bread", "lentils", "pistachio"};
        return carbOptions[new Random().nextInt(carbOptions.length)];
    }

}

