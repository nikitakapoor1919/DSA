class Solution{
  public static void swap(int[] arr,int l,int r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    
    public static void convertToWave(int arr[], int n){
        
        for(int i=0;i<n;i+=2){
            if(i>0 && arr[i-1]>arr[i]){
                swap(arr,i,i-1);
            }
            if(i<n-1 && arr[i+1]>arr[i]){
                swap(arr,i,i+1);
            }
        }
        
    }
}
