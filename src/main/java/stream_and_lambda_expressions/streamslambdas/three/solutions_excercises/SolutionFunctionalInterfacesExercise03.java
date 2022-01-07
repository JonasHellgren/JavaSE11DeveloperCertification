package stream_and_lambda_expressions.streamslambdas.three.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.three.Category;
import stream_and_lambda_expressions.streamslambdas.three.ExampleData;
import stream_and_lambda_expressions.streamslambdas.three.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Predicate;

public class SolutionFunctionalInterfacesExercise03 {

    public enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b);

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public DoubleBinaryOperator getOperator() {
            return operator;
        }
    }

    public static double calculate(double a, double b, ArithmeticOperation operation) {
       return operation.getOperator().applyAsDouble(a,b);
    }

    public static void main(String[] args) {

        double sum= calculate(1,2,ArithmeticOperation.ADD);
        System.out.println("sum = " + sum);


    }

}
