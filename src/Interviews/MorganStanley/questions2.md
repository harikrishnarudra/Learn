
Why Kafka, why not any other ?
How consumers are connected to Kafka? What happens if one consumer goes down/up ?
Rest vs Soap ?
Can we use Rest service as a soap service ?
Servlets vs Spring Controller
What does spring does when a request receives ?
Multi-threading


[1,6,0,4,2,5]  k=6

contiguous {6}, {6,0}, {0,4,2}

i , j

public int contArr(int[] nums, int k){
	List<ArrayList> res = new ArrayList();
	int i = 0, j=0;
	int len = nums.length;
	for(i;i<len;i++){
		if(nums[i]==k){
			List<Integer> subArr = new ArrayList();
			subArr.add(nums[i]);
			res.add(subArr);
		}

		int currSum = nums[i]+nums[++j];
		while(currSum<=k){
			currSum += nums[++j];
		}
		if(currSum == k){
			List<Integer> subArr = new ArrayList();
			subArr.add(nums[i]);
			res.add(subArr);
		}
		if(currSum > k){
			currSum -= nums[i];
			j++;
		}

	}
}


List<Integer> subArr = new ArrayList<Integer>();
List<Number> subArr = new ArrayList<Integer>(); //Allows
List<Number> subArr = new ArrayList<Number>();



