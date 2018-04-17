import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleOne {
  public static void main(String[] args) throws IOException {
    List<String> lemario = Files.readAllLines(Paths.get("src/main/resources/data/lemario.txt"));
    List<String> output = new ArrayList<>(lemario.size());
    output.addAll(lemario);

    Collections.shuffle(output, new Random(42L));
    output.subList(0, 10).forEach(System.out::println);
  }
}
