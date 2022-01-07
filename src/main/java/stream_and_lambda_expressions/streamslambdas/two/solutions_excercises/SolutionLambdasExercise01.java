package stream_and_lambda_expressions.streamslambdas.two.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.two.ExampleData;
import stream_and_lambda_expressions.streamslambdas.two.Product;
import java.util.List;

public class SolutionLambdasExercise01 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        products.sort((Product p1, Product p2) -> {
            return p1.getName().compareTo(p2.getName());
        });

        for (Product product : products) {
            System.out.println(product);
        }
    }

}
