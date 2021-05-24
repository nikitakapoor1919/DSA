class Solution
{
    public static void swap(int nums[],int l,int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
    public static void sort012(int nums[], int n)
    {
         int low=0,mid=0,high=nums.length-1;
         while(mid<=high){
             if(nums[mid]==0){
                 swap(nums,mid,low);
                 mid++;
                 low++;
             }
             else if(nums[mid]==1){
                 mid++;
             }
             else{
                 swap(nums,mid,high);
                 high--;
             }
         }
    }
}
