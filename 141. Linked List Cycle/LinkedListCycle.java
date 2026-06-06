public class LinkedListCycle {

    // --- 問題で与えられる ListNode 定義 ---
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // --- 解法 ---
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // --- テスト用ヘルパー: サイクル付きリスト作成 ---
    // pos: tail が繋がるインデックス (-1 ならサイクルなし)
    static ListNode buildList(int[] vals, int pos) {
        if (vals == null || vals.length == 0) return null;

        ListNode[] nodes = new ListNode[vals.length];
        for (int i = 0; i < vals.length; i++) {
            nodes[i] = new ListNode(vals[i]);
        }
        for (int i = 0; i < vals.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        if (pos >= 0 && pos < vals.length) {
            nodes[vals.length - 1].next = nodes[pos]; // サイクル接続
        }
        return nodes[0];
    }

    // --- main: 動作確認 ---
    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // テストケース1: [3,2,0,-4], pos=1 → サイクルあり (期待: true)
        ListNode head1 = buildList(new int[]{3, 2, 0, -4}, 1);
        System.out.println("Test 1: " + solution.hasCycle(head1)); // true

        // テストケース2: [1,2], pos=0 → サイクルあり (期待: true)
        ListNode head2 = buildList(new int[]{1, 2}, 0);
        System.out.println("Test 2: " + solution.hasCycle(head2)); // true

        // テストケース3: [1], pos=-1 → サイクルなし (期待: false)
        ListNode head3 = buildList(new int[]{1}, -1);
        System.out.println("Test 3: " + solution.hasCycle(head3)); // false

        // テストケース4: null → (期待: false)
        System.out.println("Test 4: " + solution.hasCycle(null)); // false

        // テストケース5: [1,2,3,4,5], pos=-1 → サイクルなし (期待: false)
        ListNode head5 = buildList(new int[]{1, 2, 3, 4, 5}, -1);
        System.out.println("Test 5: " + solution.hasCycle(head5)); // false
    }
}
