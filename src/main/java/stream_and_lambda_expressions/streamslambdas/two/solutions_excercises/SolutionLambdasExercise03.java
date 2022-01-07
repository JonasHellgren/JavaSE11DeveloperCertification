package stream_and_lambda_expressions.streamslambdas.two.solutions_excercises;

import stream_and_lambda_expressions.streamslambdas.two.Category;
import stream_and_lambda_expressions.streamslambdas.two.ExampleData;
import stream_and_lambda_expressions.streamslambdas.two.Product;

import java.util.ArrayList;
import java.util.List;

public class SolutionLambdasExercise03 {

    public interface ShoppingCartFactory {
        ShoppingCart newShoppingCart();
    }

    public static ShoppingCartFactory getShoppingCartFactory() {

        //ShoppingCartFactory sc=() -> new  ShoppingCart();

        return ShoppingCart::new;
    }

    public static class ShoppingCart {
        protected final List<Product> products = new ArrayList<>();

        public void add(Product product) {
            this.products.add(product);
        }
    }

        public static void main(String[] args) {
            List<Product> products = ExampleData.getProducts();

            ShoppingCartFactory scf = getShoppingCartFactory();
            ShoppingCart sc = scf.newShoppingCart();

            sc.add(products.get(0));
            sc.products.forEach(System.out::println);

            System.out.println("sc.products.size() = " + sc.products.size());

        }
}

