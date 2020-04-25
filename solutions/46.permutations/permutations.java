import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> current = new ArrayList<>();
        for (int i : nums) {
            current.add(i);
        }
        permute(res, current, 0);
        return res;
    }

    void permute(List<List<Integer>> res, List<Integer> current, int i) {
        if (i == current.size()) {
            res.add(new ArrayList(current));
            return;
        }
        for (int j = i; j < current.size(); j++) {
            Collections.swap(current, i, j);
            permute(res, current, i + 1);
            Collections.swap(current, i, j);
        }
    }
}