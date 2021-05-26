import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class WordCount {
    public static void main(String[] args)  {
        File file = new File(args[0]);
        Stream<String> content_stream;
        try {
            content_stream = Files.lines(file.toPath());
        }
        catch (java.io.IOException e){
            e.printStackTrace();
            return;
        }
        Map<String, Long> wc_map = content_stream.flatMap(line-> Arrays.stream(line.split(" "))).filter(x->x.matches("[a-zA-Z]+") && x.length() > 0).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wc_map.forEach((key, value)-> System.out.printf("%s: %d%n", key, value));
    }
}
