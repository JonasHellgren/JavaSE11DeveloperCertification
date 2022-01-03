package object_oriented_approach.bmi_calculator;

public abstract class MassCategoryEvaluator {

    protected final double  input;

    public MassCategoryEvaluator(double input) {
        this.input = input;
    }

    abstract Category findCategory();

}
