import java.util.ArrayList;
import java.util.Arrays;

public class ex {
   public static void main(String[] args) {
      ArrayList<String> n = new ArrayList<String>(Arrays.asList(
         "adfd", "sdf", "hgfd"
      ));
      n.remove(0);
      System.out.println(n.get(0));
   }
}
