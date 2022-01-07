package stream_and_lambda_expressions.streamslambdas.four.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.four.Category;
import stream_and_lambda_expressions.streamslambdas.four.ExampleData;
import stream_and_lambda_expressions.streamslambdas.four.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class SolutionBasicStreamsExercise05 {

    public static boolean areAllOfficeProductsCheap(List<Product> products, BigDecimal priceLimit) {
        // TODO: Look for products in the category OFFICE. Check if all of them cost less than the price limit.
        //
        // Hint: Use two stream operations; one the find the appropriate products,
        // and another one to check if they all cost less than the price limit.

        return products.
                stream().
                filter(p -> p.getCategory()== Category.OFFICE).
                allMatch(p -> p.getPrice().compareTo(priceLimit) <= 0);

      //  throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        products.forEach(System.out::println);
        boolean product=areAllOfficeProductsCheap(products,new BigDecimal("15"));
        System.out.println("product = " + product);
    }


}
