class Solution {
    public int findBestValue(int[] arr, int target) {
        if(target==0){
            return 0;
        }
        Arrays.sort(arr);
        int N=arr.length;
        int[] prefixSum = new int[N+1];
        for(int i=1;i<=N;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i-1];
        }
        if(target>prefixSum[N]){
            return arr[N-1];
        }
        int diff=target;
        int value=0;
        for(int i=1;i<=arr[N-1];i++){
            int l=0,r=N-1,index=-1;
            while(l<=r){
                int m=l+(r-l)/2;
                if(i<arr[m]){
                    r=m-1;
                }else if(i>arr[m]){
                    l=m+1;
                }else{
                    index=m;
                    break;
                }
                index=l;
            }
            int sum=prefixSum[index]+(N-index)*i;
            if(Math.abs(sum-target)<diff){
                diff=Math.abs(sum-target);
                value=i;
            }
        }
        return value;
    }
}