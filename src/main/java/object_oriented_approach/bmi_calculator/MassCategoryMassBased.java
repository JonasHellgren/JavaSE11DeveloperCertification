package object_oriented_approach.bmi_calculator;

public class MassCategoryMassBased extends  MassCategoryEvaluator{


    public MassCategoryMassBased(double input) {
        super(input);
    }

    @Override
    public Category findCategory() {

        for (int i = Category.values().length-1; i >= 0; i--) {
            Category  category = Category.values()[i];
            if (super.input > Category.massLimit(category)) {
                return category;
            }

        }
        return null;
    }

}
