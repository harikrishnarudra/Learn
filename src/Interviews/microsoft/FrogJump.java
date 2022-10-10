package Interviews.microsoft;

public class FrogJump {
    public int findMaxDistance(int[] arr){
        int N = arr.length;
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        int i = 1;

        while (i < arr.length) {
            // previous is greater than current
            if (arr[i] >= arr[i - 1]) {
                leftMax[i] = leftMax[i - 1] + 1;
            } else {
                leftMax[i] = 0;
            }

            i++;

        }

        rightMax[N - 1] = 0;  //
        int j = N - 2;
        while (j >= 0) {
            // next is greater than current
            if (arr[j] >= arr[j + 1]) {
                rightMax[j] = rightMax[j + 1] + 1;
            } else {
                rightMax[j] = 0;
            }

            j--;

        }

        int maxD = 0;

        for (int k = 0; k < N; k++) {
            maxD = Math.max(maxD, leftMax[k] + rightMax[k] + 1);

        }

        return maxD;
    }

    public static void main(String[] args) {
        FrogJump f = new FrogJump();
        System.out.println(f.findMaxDistance(new int[]{1, 5, 5, 2, 6}));
    }
}
