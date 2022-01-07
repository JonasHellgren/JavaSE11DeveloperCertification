package stream_and_lambda_expressions.streamslambdas.otherExamples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindingDivisorsOfAnIntegerUsingIterateAndFilter {

    public static List<Integer> findDivisors(int number) {

        return Stream.
                iterate(1,n -> n<number, n -> n+1).   //infinite stream of integers
                filter(n ->  number % n ==0).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Integer> divisors=findDivisors(10);

        System.out.println("divisors of 10= " + divisors);

    }

}
