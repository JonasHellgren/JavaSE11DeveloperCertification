package object_oriented_approach.bmi_calculator;

public abstract class MassCategoryEvaluator<T> {

    protected final T  input;

    public MassCategoryEvaluator(T input) {
        this.input = input;
    }

    protected abstract boolean isLimitLargerThanInput(Category category);

    public Category findCategory() {

        for (int i = Category.values().length-1; i >= 0; i--) {
            Category  category = Category.values()[i];
            if (isLimitLargerThanInput(category)) {  //sub class defines isLimitLargerThanInput
                return category;
            }

        }
        throw new RuntimeException ("Failed to find Category");
    }

}
