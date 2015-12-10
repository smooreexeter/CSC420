
public class arrayDiff {
	public static int bigDiff(int[] nums){
		int diff;
		int high = nums[0];
		int low = nums[0];
		for(int i = 0; i < 4; i++){
			high = Math.max(nums[i], high);
			low = Math.min(nums[i], low);
		}
		diff = high - low;
		return diff;
	}
}
