package stream_and_lambda_expressions.streamslambdas.otherExamples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerListUpTo10WithIterate {


    public static void main(String[] args) {

        List<Integer> integerList= Stream.
                iterate(
                0, n -> n<10, n -> n+1).
                collect(Collectors.toList());

        System.out.println("integerList = " + integerList);


    }
}
