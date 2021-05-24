class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){
        
        int meh=0,msf=0;
        for(int i=0;i<n;i++){
            meh+=arr[i];
            if(meh<0){
                meh=0;
            }
            if(msf<meh){
                msf=meh;
            }
        }
        return msf;
    }
    
}
