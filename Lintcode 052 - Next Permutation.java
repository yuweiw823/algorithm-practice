public class Solution {
	/**
	 * @param nums: an array of integers
	 * @return: return nothing (void), do not return anything, modify nums in-place instead
	 */
	// write your code here
	//从后向前找，找到第一个valley (nums[i] < nums[i - 1])
	//确定 [i, nums.length)，所有的数字都需要调整
	//从[i, nums.length) 中，找到仅次于charAt[i]大的数字，放在 i 位上
	//剩下的数字从小到大排在 [i+1, nums.length) 上
		
	public int[] nextPermutation(int[] nums) {
		// write your code here
		if(nums == null || nums.length == 0) {
			return nums;
		}

		if(nums.length == 1) {
			return nums;
		}

		int index = nums.length - 2;
		while (index >= 0 && nums[index] >= nums[index + 1]) {
			index--;
		}

		if(index >= 0) {
			int biggerIndex = index;
			for(int i = nums.length - 1; i > index; i--) {
				if(nums[i] > nums[index]) {
					biggerIndex = i;
					break;
				}
			}

			swap(index, biggerIndex, nums);
			reverse(index + 1, nums.length - 1, nums);
			return nums;

		} else {
			reverse(0, nums.length - 1, nums);
			return nums;
		}
	}

	public void swap(int a, int b, int[] nums) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public void reverse(int start, int end, int[] reversedArr) {
		while (start < end) {
			swap(start, end, reversedArr);
			start++;
			end--;
		}
	}
}