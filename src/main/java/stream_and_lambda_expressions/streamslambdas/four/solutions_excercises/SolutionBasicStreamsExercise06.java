package stream_and_lambda_expressions.streamslambdas.four.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.four.ExampleData;
import stream_and_lambda_expressions.streamslambdas.four.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionBasicStreamsExercise06 {

    public static String formatProductList(List<Product> products) {
        // Converts each of the products to a string (using Product.toString()) and collect the results in a string.
        return products.
                stream().
                map(p -> p.toString()).
                collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        String productsAsString=formatProductList(products);
        System.out.println("productsAsString = "+"\n" + productsAsString);
    }

}
