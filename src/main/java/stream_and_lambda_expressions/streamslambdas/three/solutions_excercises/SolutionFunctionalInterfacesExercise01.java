package stream_and_lambda_expressions.streamslambdas.three.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.three.Product;
import stream_and_lambda_expressions.streamslambdas.three.Category;
import stream_and_lambda_expressions.streamslambdas.three.ExampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SolutionFunctionalInterfacesExercise01 {


    public static final int MIN_NAME_LENGTH = 10;

    public static List<Product> filterProducts(List<Product> products, Predicate<Product> predicate) {
        List<Product> result = new ArrayList<>();
        for (Product product:products) {
            if (predicate.test(product)) {
                result.add(product);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        Predicate<Product> predicate=product -> product.getName().length()> MIN_NAME_LENGTH;
        List<Product> productList=filterProducts(products,  predicate);
        productList.forEach(p -> System.out.println(p));
    }

}
