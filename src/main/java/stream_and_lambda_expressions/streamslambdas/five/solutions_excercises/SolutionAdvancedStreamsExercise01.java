package stream_and_lambda_expressions.streamslambdas.five.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.five.Product;
import stream_and_lambda_expressions.streamslambdas.five.ExampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SolutionAdvancedStreamsExercise01 {

    public static Set<String> getSortedProductNames(List<Product> products) {
        //Collect the names of the products into a TreeSet.

        return products.
                stream().
                collect(
                        TreeSet::new,  //a new mutable result container
                        (list, product) -> list.add(product.getName()),  //fold an element into a result container
                        TreeSet::addAll);  //accepts result containers and merges them

    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        Set<String> sortedProducts = getSortedProductNames(products);
        sortedProducts.forEach(product -> System.out.println(product));
    }

}
