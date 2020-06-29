class Solution {
    Random random=new Random();
    public int findKthLargest(int[] nums, int k) {
        return select(nums,0,nums.length-1,nums.length-k);
    }

    int select(int[] nums,int left,int right,int index){
        int k=randomPartition(nums,left,right);
        if(k==index){
            return nums[k];
        }else if(index<k){
            return select(nums,left,k-1,index);
        }else{
            return select(nums,k+1,right,index);
        }
    }

    int randomPartition(int[] nums,int left,int right){
        if (left == right)
            return left;
        int i=random.nextInt(right-left+1)+left;
        swap(nums,left,i);
        return partition(nums,left,right);
    }

    int partition(int[] nums,int left,int right){
        int v=nums[left];
        int i=left,j=right+1;
        while(true){
            while(v>nums[++i])if(i==right)break;
            while(v<nums[--j]);
            if(i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,left,j);
        return j;
    }

    void swap(int[] nums,int l,int r){
        int t=nums[l];
        nums[l]=nums[r];
        nums[r]=t;
    }
}