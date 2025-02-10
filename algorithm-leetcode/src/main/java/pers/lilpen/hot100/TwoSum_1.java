package pers.lilpen.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curRes = target - nums[i];
            if (numIndexMap.containsKey(curRes)) {
                return new int[]{numIndexMap.get(curRes), i};
            }
            numIndexMap.put(nums[i], i);
        }
        return null;
    }
}
