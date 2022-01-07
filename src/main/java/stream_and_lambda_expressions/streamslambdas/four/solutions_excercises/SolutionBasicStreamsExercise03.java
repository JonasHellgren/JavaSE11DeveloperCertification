package stream_and_lambda_expressions.streamslambdas.four.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.four.Category;
import stream_and_lambda_expressions.streamslambdas.four.ExampleData;
import stream_and_lambda_expressions.streamslambdas.four.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SolutionBasicStreamsExercise03 {

    public static Optional<Product> findProductCheaperThan(List<Product> products, BigDecimal priceLimit) {
       // Find any product in the list that is cheaper than the given price limit.

       return products.
               stream().
               filter(p -> p.getPrice().compareTo(priceLimit) <= 0).
               findAny();
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        Optional<Product>  product=findProductCheaperThan(products, new BigDecimal("15"));
        System.out.println("product = " + product);
    }

}
