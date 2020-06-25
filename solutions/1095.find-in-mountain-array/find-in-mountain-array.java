/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left=0,right=mountainArr.length()-1;
        while(left<right){
            int mid=(left+right)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        int index=search(mountainArr,target,0,left,false);
        if(index!=-1){
            return index;
        }
        return search(mountainArr,target,left+1,mountainArr.length()-1,true);
    }

    int search(MountainArray arr,int target,int left,int right,boolean reversed){
        while(left<=right){
            int mid=(left+right)/2;
            int midValue=arr.get(mid);
            if(target==midValue){
                return mid;
            }else if(reversed){
                if(midValue>target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(midValue<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}