package Interviews.microsoft;

import com.practice.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TreeHeight {

        public int solution(TreeNode T) {
            // write your code in Java SE 8
            Set<Integer> set = new HashSet();
            set.add(T.val);
            return Math.max(recurse(T.left, set), recurse(T.right, set)) + 1;
        }

        private int recurse(TreeNode t, Set<Integer> set) {
            if (t == null || set.contains(t.val)) {
                return 0;
            }
            set.add(t.val);
            return Math.max(recurse(t.left, set), recurse(t.right, set)) + 1;

        }

    public static void main(String[] args) {

    }

}
