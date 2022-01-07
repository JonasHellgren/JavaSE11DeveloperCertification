package stream_and_lambda_expressions.streamslambdas.two.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.two.Category;
import stream_and_lambda_expressions.streamslambdas.two.ExampleData;
import stream_and_lambda_expressions.streamslambdas.two.Product;

import java.util.ArrayList;
import java.util.List;

public class SolutionLambdasExercise02 {

    public interface ProductFilter {
        boolean accept(Product product);
    }

    public static List<Product> findProductsByCategory(List<Product> products, Category category) {

        ProductFilter filter = product -> product.getCategory()==category; //"defining" accept method

        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (filter.accept(product)) {
                result.add(product);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        List<Product> productsOfCategory=findProductsByCategory(products,  Category.FOOD);
        productsOfCategory.forEach(p -> System.out.println(p));
    }

}
