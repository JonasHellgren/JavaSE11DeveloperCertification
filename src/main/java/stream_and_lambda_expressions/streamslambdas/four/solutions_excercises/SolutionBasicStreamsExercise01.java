package stream_and_lambda_expressions.streamslambdas.four.solutions_excercises;


import stream_and_lambda_expressions.streamslambdas.four.Category;
import stream_and_lambda_expressions.streamslambdas.four.Product;
import stream_and_lambda_expressions.streamslambdas.four.ExampleData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionBasicStreamsExercise01 {

    public static List<Product> findUtensilsSortedByName(List<Product> products) {

       // Comparator<Product> nameComparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Comparator<Product> nameComparator = Comparator.comparing(Product::getName);

        return products.
                stream().
                filter(product -> product.getCategory()==Category.UTENSILS).  //Find the products that are in the category UTENSILS
                sorted(nameComparator).  //Sort them by name
                collect(Collectors.toList());  //Collect the result into a List

        //throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        List<Product>  sortedProducts=findUtensilsSortedByName(products);
        sortedProducts.forEach(product -> System.out.println(product));
    }


}
