// import java.util.*;
// 160 / 162 testcases passed
// class Solution {

//   private Map<String, List<String>> tree, buffer;
//   private Set<String> filenames;
//   private Map<String, Integer> filenames_freq;

//   private void destructure(String path) {
//     int delimeter = path.indexOf(" ");
//     String absolute_file_path = path.substring(0, delimeter), files_stream =
//       path.substring(delimeter + 1);
//     String[] filepath = absolute_file_path.split("/");
//     int i = filepath.length - 1;
//     String[] files = files_stream.split(" ");
//     List<String> subfiles = new ArrayList<>();
//     for (String file : files) {
//       String name = file.substring(file.indexOf("("));
//       this.filenames_freq.put(
//           name,
//           this.filenames_freq.getOrDefault(name, 0) + 1
//         );
//       subfiles.add(file);
//     }
//     for (; i > -1; i--) {
//       if (!this.tree.containsKey(filepath[i])) {
//         this.tree.put(filepath[i], new ArrayList<>());
//       }
//       if (i == filepath.length - 1) this.tree.get(filepath[i]).addAll(subfiles);
//       else if (
//         !this.tree.get(filepath[i]).contains(filepath[i + 1])
//       ) this.tree.get(filepath[i]).add(filepath[i + 1]);
//     }
//   }

//   public List<List<String>> findDuplicate(String[] paths) {
//     this.tree = new HashMap<>();
//     this.filenames = new HashSet<>();
//     this.filenames_freq = new HashMap<>();
//     this.buffer = new HashMap<>();
//     String ROOT = "root";
//     for (String path : paths) destructure(path);

//     Iterator<String> file_names = this.filenames.iterator();
//     dfsQ_fileFinder(ROOT, new ArrayList<String>());
//     List<List<String>> result = new ArrayList<>();
//     for (List<String> __paths__ : buffer.values()) {
//       if (__paths__.size() > 1) result.add(__paths__);
//     }
//     return result;
//   }

//   private void dfsQ_fileFinder(String dir, List<String> path) {
//     path.add(dir);
//     for (String fileOrDir : tree.getOrDefault(dir, Collections.emptyList())) {
//       if (fileOrDir.contains(".")) { // file
//         int idx = fileOrDir.indexOf('(');
//         String filename = fileOrDir.substring(0, idx);
//         String content = fileOrDir.substring(idx);
//         String fullPath = String.join("/", path) + "/" + filename;
//         buffer.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath);
//       } else dfsQ_fileFinder(fileOrDir, path);
//     }
//     path.remove(path.size() - 1);
//   }
// }

import java.util.*;

class Solution {

  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> contentMap = new HashMap<>();

    for (String path : paths) {
      String[] parts = path.split(" ");
      String dir = parts[0];

      for (int i = 1; i < parts.length; i++) {
        String file = parts[i];
        int idx = file.indexOf('(');
        String fileName = file.substring(0, idx);
        String content = file.substring(idx + 1, file.length() - 1);

        String filePath = dir + "/" + fileName;
        contentMap
          .computeIfAbsent(content, k -> new ArrayList<>())
          .add(filePath);
      }
    }

    List<List<String>> result = new ArrayList<>();
    for (List<String> group : contentMap.values()) {
      if (group.size() > 1) result.add(group);
    }

    return result;
  }
}

public class _609_Find_Duplicate_File_in_System {

  public static void main(String[] args) {
    List<List<String>> duplicates = new Solution()
      .findDuplicate(
        new String[] {
          "root/a 1.txt(abcd) 2.txt(efgh)",
          "root/c 3.txt(abcd)",
          "root/c/d 4.txt(efgh)",
          "root 4.txt(efgh)",
        }
      );
    System.out.println(duplicates);
  }
}
