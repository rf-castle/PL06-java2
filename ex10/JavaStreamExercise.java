import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class JavaStreamExercise {
    public static void main(String[] args) {

        List<String> number = Arrays.asList("2", "3", "4", "5");
        number.stream()
                .map(x -> Integer.parseInt(x) * 2)
                .forEach(System.out::println);
        List<String> stoplist = Arrays.asList(
                "is", "was", "to", "have", "in", "on"
        );
        List<String> teststr = Arrays.asList(
                "The", "2019-20", "coronavirus", "pandemic",
                "was", "confirmed", "to", "have", "spread",
                "to", "Japan", "on", "16", "January", "2020", "."
        );
        List<String> resultstr = teststr.
                stream().
                filter(content ->
                        !stoplist.contains(content)
                                && content.chars().allMatch(Character::isAlphabetic)
                ).sorted().collect(Collectors.toList());
        Collections.reverse(resultstr);
        for (String result: resultstr){
            System.out.println(result);
        }
    }
}
