class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start){
        if(remain < 0){
            return;
        }

        if(remain == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = start; i<candidates.length; i++){
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remain-candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }

    }
}
