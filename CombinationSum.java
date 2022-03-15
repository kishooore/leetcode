import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum tester = new CombinationSum();
        int[] candidates = {10,1,2,7,6,1,5};
        Arrays.sort(candidates);
        int target = 8;
        tester.combinationSum(candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        helper(candidates, 0, target, currentPath, ans);
        return ans;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> currentPath, List<List<Integer>> ans) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            currentPath.add(candidates[i]);
            helper(candidates, i+1, target - candidates[i], currentPath, ans);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
