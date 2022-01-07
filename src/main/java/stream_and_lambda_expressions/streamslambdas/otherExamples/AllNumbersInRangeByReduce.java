package stream_and_lambda_expressions.streamslambdas.otherExamples;

import java.util.stream.IntStream;

public class AllNumbersInRangeByReduce {

    public static void main(String[] args) {

        // To get the product of all elements
        // in given range excluding the
        // rightmost element

        int product= IntStream.range(1,4).
                reduce((partRes,num) -> partRes*num).
                orElse(-1);

        System.out.println("product = " + product);


    }
}
