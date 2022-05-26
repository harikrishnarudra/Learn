package Interviews.delphix;
/*
[100, 110, 140, 130, 60, 70, 50, 90, 140]


public int findMaxProfit(int[] nums){
	int maxProfit = 0;
	if(nums.length<2){
		return 0;
	}
	int len = nums.length;
	int i=0, j=1;
	while(i<len){
		//Finding the next sell
		while(j < len && nums[j] > nums[i] && nums[j] > nums[j-1]){
			j++;
		}
		maxProfit += nums[j-1]-nums[i];

		//Finding the next buy
		i = j;
		while(i+1 < len && nums[i] > nums[i+1] ){
			i++;
		}
		j=i+1;

	}
	return maxProfit;

}









 */
public class MaxProfit {
}
