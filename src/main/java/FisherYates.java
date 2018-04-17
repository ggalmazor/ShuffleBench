import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FisherYates {

  public static List<String> shuffle(List<String> list, Random random) {
    String[] array = list.toArray(new String[0]);
    String[] result = new String[list.size()];

    for (int i = 0; i < array.length; ++i) {
      int j = Double.valueOf(random.nextDouble() * (i + 1)).intValue();

      if (j != i)
        result[i] = result[j];

      result[j] = array[i];
    }

    return Arrays.asList(result);
  }
}
