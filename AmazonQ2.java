import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    private static int getUniqueElementCount(int s, int e, List<Integer> arr) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i = s; i <= e; i++) {
            uniqueElements.add(arr.get(i));
        }
        return uniqueElements.size();
    }

    public static int getMedianOfSubarrayUniqueness(List<Integer> initialArray) {
        int n = initialArray.size();
        List<Integer> uniquenessList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int uniqueCount = getUniqueElementCount(i, j, initialArray);
                uniquenessList.add(uniqueCount);
            }
        }

        Collections.sort(uniquenessList);

        int size = uniquenessList.size();
        if (size % 2 == 0) {
            return Math.min(uniquenessList.get(size / 2), uniquenessList.get(size / 2 - 1));
        } else {
            return uniquenessList.get(size / 2);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        int result = Result.getMedianOfSubarrayUniqueness(new ArrayList<>(Arrays.asList(1, 2, 1)));
        System.out.println(result);

    }
}
