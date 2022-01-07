package stream_and_lambda_expressions.streamslambdas.otherExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongestWordInStringListByReduce {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");

        /*
        Integer longestLength=words.stream().
                reduce(0,
                        (partRes,str) -> partRes.length() > str.length()?partRes.length():str.length());  */

        String longestWord=words.stream().
                reduce( "",
                        (partRes,str) -> partRes.length() > str.length()?partRes:str);

        System.out.println("longestWord = " + longestWord);

    }

}
