import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ShuffleOne {

  public static void main(String[] args) throws IOException {
    List<String> lemario = Files.readAllLines(Paths.get("src/main/resources/data/lemario.txt"));

    List<String> output = FisherYates.shuffle(lemario, new ParkMiller(9965168727L));
    output.subList(0, 10).forEach(System.out::println);
  }
}
