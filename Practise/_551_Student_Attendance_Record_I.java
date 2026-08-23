class Solution {
  public boolean checkRecord(String s) {
    char prev = '\0';
    int l_count = 0;
    int absent_count = 0;
    for (char ch : s.toCharArray()) {
      if (ch != 'P') {
        if (ch == 'A') {
          absent_count++;
          if (absent_count >= 2)
            return false;
        }
        if (ch == 'L') {
          if (ch != prev)
            l_count = 1;
          else {
            l_count++;
            if (l_count >= 3)
              return false;
          }
        }
      }
      prev = ch;
    }
    return true;
  }
}

public class _551_Student_Attendance_Record_I {
  public static void main(String[] args) {
    System.out.println(new Solution().checkRecord("PPALLP"));
  }
}