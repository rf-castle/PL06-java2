import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class WordCount {
    public static void main(String[] args) {
        File file = new File("text.txt");

        Stream<String> content_stream = Stream.of();
        Map<String, Long> wc_map = content_stream.flatMap(line-> Arrays.stream(line.split(" "))).filter(x->x.matches("[a-zA-Z]+") && x.length() > 0).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
