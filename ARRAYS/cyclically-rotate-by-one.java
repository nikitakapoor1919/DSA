class Compute {
    public void rotate(long arr[])
    {
       int i=0,j=arr.length-1;
       while(i!=j){
           long temp=arr[i];
           arr[i]=arr[j];
           arr[j]=temp;
           i++;
       }
    }
}
