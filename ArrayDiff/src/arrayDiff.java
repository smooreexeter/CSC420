
public class arrayDiff {
	public static int bigDiff(int[] nums){
		int diff;
		int high = nums[0];
		int low = nums[0];
		for(int i = 1; i < 4; i++){
			high = Math.max(nums[i], high);
			low = Math.min(nums[i], low);
		}
		diff = high - low;
		return diff;
	}
	
	public static int clump(int[] nums){
		int clumpCount = 0;
		for(int i = 0; i < nums.length - 1; i++){
			if(nums[i] == nums[i+1]){
				clumpCount++;
				for(int j = i+2; j < nums.length; j++){
					if(nums[i] != nums[j]){
						i=j;
						j=nums.length;
					}
				}
			}
		}
		return clumpCount;
	}
	
}
