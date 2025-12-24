class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {

  private int getLength(ListNode h) {
    int len = 0;
    while (h != null) {
      len++;
      h = h.next;
    }
    return len;
  }

  private int[] getDivisions(int n, int d) {
    int[] dens = new int[d];
    int idx = 0;
    while (n != 0) {
      int x = (int) Math.ceil((float) n / (float) d);
      dens[idx++] = x;
      n -= x;
      d -= 1;
    }
    return dens;
  }

  private ListNode HEAD;

  private ListNode forward(int fPtr) {
    ListNode startingPtr = new ListNode(0);
    ListNode startingPtrRet = startingPtr;
    int i = 0;
    while (i < fPtr) {
      ListNode save = this.HEAD;
      this.HEAD = this.HEAD.next;
      startingPtr.next = save;
      startingPtr = save;
      i++;
    }
    startingPtr.next = null;
    return startingPtrRet.next;
  }

  public ListNode[] splitListToParts(ListNode head, int k) {
    this.HEAD = head;
    int[] denominations = getDivisions(getLength(head), k);
    ListNode[] result = new ListNode[k];
    for (int i = 0; i < k; i++) result[i] = forward(denominations[i]);
    return result;
  }
}

public class _725_Split_Linked_List_in_Parts {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .splitListToParts(
          new ListNode(
            1,
            new ListNode(
              2,
              new ListNode(
                3,
                new ListNode(
                  4,
                  new ListNode(
                    5,
                    new ListNode(
                      6,
                      new ListNode(
                        7,
                        new ListNode(8, new ListNode(9, new ListNode(10)))
                      )
                    )
                  )
                )
              )
            )
          ),
          3
        )
    );
  }
}
