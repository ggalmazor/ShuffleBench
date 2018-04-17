import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Shuffle {
  public static void main(String[] args) throws IOException {
    Path shuffleDir = Paths.get("src/main/resources/shuffle/java");
    List<String> lemario = Files.readAllLines(Paths.get("src/main/resources/data/lemario.txt"));
    Files.lines(Paths.get("src/main/resources/data/seeds.txt"))
        .map(Long::parseLong)
        .forEach(seed -> {
          uncheckedWrite(
              shuffleDir.resolve("lemario_shuffle_" + seed + ".txt"),
              FisherYates.shuffle(lemario, new ParkMiller(seed)).stream().collect(joining("\n"))
          );
        });
  }

  private static void uncheckedWrite(Path path, String content) {
    try {
      Files.write(path, content.getBytes(), CREATE, TRUNCATE_EXISTING);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
