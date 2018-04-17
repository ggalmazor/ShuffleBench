import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffle {
  public static void main(String[] args) throws IOException {
    Path shuffleDir = Paths.get("src/main/resources/shuffle/java");
    List<String> lemario = Files.readAllLines(Paths.get("src/main/resources/data/lemario.txt"));
    Files.lines(Paths.get("src/main/resources/data/seeds.txt"))
        .map(Long::parseLong)
        .forEach(seed -> {
          List<String> output = new ArrayList<>(lemario.size());
          output.addAll(lemario);

          Collections.shuffle(output, new Random(seed));
          uncheckedWrite(shuffleDir.resolve("lemario_shuffle_" + seed + ".txt"), output.stream().collect(joining("\n")));
        });
  }

  private static Path uncheckedWrite(Path path, String content) {
    try {
      return Files.write(path, content.getBytes(), CREATE, TRUNCATE_EXISTING);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
