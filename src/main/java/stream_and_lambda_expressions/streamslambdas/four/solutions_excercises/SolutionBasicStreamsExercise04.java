package stream_and_lambda_expressions.streamslambdas.four.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.four.Category;
import stream_and_lambda_expressions.streamslambdas.four.ExampleData;
import stream_and_lambda_expressions.streamslambdas.four.Product;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SolutionBasicStreamsExercise04 {

    public static Optional<Product> findCheapestCleaning(List<Product> products) {
        // Look for products that are in the category CLEANING and find the cheapest one.
        return products.
                stream().
                filter(p -> p.getCategory()== Category.CLEANING).
                //min(Comparator.comparing(p -> p.getPrice()));
                min(Comparator.comparing(Product::getPrice));
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        Optional<Product>  product=findCheapestCleaning(products);
        System.out.println("product = " + product);
    }

}
