package stream_and_lambda_expressions.streamslambdas.otherExamples;


import stream_and_lambda_expressions.streamslambdas.otherExamples.models.Person;

import java.util.Arrays;
import java.util.List;

public class SumOfPersonAgesByReduce {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(new Person("Jonas",47), new Person("Alex",3));

        //if we use sequential streams and the types of the accumulator arguments and the types of
        // its implementation match, we don't need to use a combiner.


        int sumOfAges=persons.stream().
                reduce(0,
                        (partRes,person) ->  partRes+person.getAge(), Integer::sum);

        System.out.println("sumOfAges = " + sumOfAges);

    }
}
