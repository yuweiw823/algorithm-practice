public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> res = new ArrayList<String>();
        int n = nums.length;
        
        for(int i = 0; i<=n; i++){
            int lt = (i == 0) ? lower : nums[i-1] + 1;
            int gt = (i == n) ? upper : nums[i] - 1;
            addRange(lt, gt, res);
        }
        return res;
    }
    
    public void addRange(int lt, int gt, ArrayList<String> res){
        if(lt > gt) return;
        if(lt == gt) res.add(Integer.toString(lt));
        if(lt < gt) res.add(Integer.toString(lt) + "->" + Integer.toString(gt));
    }
}