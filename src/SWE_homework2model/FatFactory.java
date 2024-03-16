package SWE_homework2model;

import java.util.Random;

// Concrete Factory for Fats
class FatFactory implements MacronutrientFactory {


    @Override
    public String createFat() {
        String[] fatOptions = {"avocado", "sour cream", "tuna", "peanuts"};
        return fatOptions[new Random().nextInt(fatOptions.length)];
    }
}
