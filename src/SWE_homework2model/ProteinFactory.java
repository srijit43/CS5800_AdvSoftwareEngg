package SWE_homework2model;

import java.util.Random;

// Concrete Factory for Proteins
class ProteinFactory implements MacronutrientFactory {


    @Override
    public String createProtein() {
        String[] proteinOptions = {"fish", "chicken", "beef", "tofu"};
        return proteinOptions[new Random().nextInt(proteinOptions.length)];
    }

}

