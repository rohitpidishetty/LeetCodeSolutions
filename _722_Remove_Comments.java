import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

class Solution {

  public List<String> removeComments(String[] source) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean inBlock = false;

    for (String line : source) {
      int i = 0;
      if (!inBlock) sb.setLength(0);
      while (i < line.length()) {
        if (
          !inBlock &&
          i + 1 < line.length() &&
          line.charAt(i) == '/' &&
          line.charAt(i + 1) == '*'
        ) {
          inBlock = true;
          i += 2;
        } else if (
          inBlock &&
          i + 1 < line.length() &&
          line.charAt(i) == '*' &&
          line.charAt(i + 1) == '/'
        ) {
          inBlock = false;
          i += 2;
        } else if (
          !inBlock &&
          i + 1 < line.length() &&
          line.charAt(i) == '/' &&
          line.charAt(i + 1) == '/'
        ) {
          break;
        } else if (!inBlock) {
          sb.append(line.charAt(i));
          i++;
        } else i++;
      }
      if (!inBlock && sb.length() > 0) result.add(sb.toString());
    }

    return result;
  }
}

public class _722_Remove_Comments {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .removeComments(
          new String[] {
            "class test{",
            "public: ",
            "   int x = 1;",
            "   /*double y = 1;*/",
            "   char c;",
            "};",
          }
        )
    );
    System.out.println("+----------------------------------+");

    System.out.println(
      new Solution()
        .removeComments(
          new String[] {
            "/*Test program */",
            "int main()",
            "{ ",
            "  // variable declaration ",
            "int a, b, c;",
            "a = 10; /* This is a test",
            "   multiline  ",
            "   comment for ",
            "   testing */",
            "a = b + c;",
            "}",
          }
        )
    );
  }
}
/**
 * ["class test{","public: ","   int x = 1;","","   char c;","};"]
 * ["class test{","public: ","   int x = 1;","","   char c;","};"]
 */
