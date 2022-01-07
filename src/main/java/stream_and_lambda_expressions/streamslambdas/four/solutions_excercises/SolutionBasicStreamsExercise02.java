package stream_and_lambda_expressions.streamslambdas.four.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.four.Category;
import stream_and_lambda_expressions.streamslambdas.four.ExampleData;
import stream_and_lambda_expressions.streamslambdas.four.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionBasicStreamsExercise02 {

    public static List<String> getProductNamesForCategory(List<Product> products, Category category) {

        return products.
                stream().
                filter(p -> p.getCategory()==category).  //Find the products that are in the given category
              //  map(p -> p.getName()).    //Transform each product to its name
                map(Product::getName).    //alt expression
                collect(Collectors.toList());  //Collect the result into a List

    }

    public List<String> categoriesToProductNames(Map<Category, List<Product>> productsByCategory, Stream<Category> categories) {
        // TODO: Start with the stream of categories.
        // For each category in that stream, get the products.
        // Then transform them to product names.
        // Finally, collect the results in a list.
        //
        // Hint: You'll need to use different mapping methods.

//        return categories...;

        throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        List<String>  sortedProducts=getProductNamesForCategory(products,Category.OFFICE);
        sortedProducts.forEach(product -> System.out.println(product));
    }

}
