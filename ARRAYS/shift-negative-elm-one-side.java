class GFG {
    static void shift(int[] arr){
        int i=-1;
        for(int j=0;j<arr.length;j++){
            if(arr[j]<0){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        for(int x: arr){
            System.out.print(x+" ");
        }
    }
	public static void main (String[] args) {
	    int[] arr={12, 11, 13, -5, 6, -7, 5, -3, -6};
	    shift(arr);
	}
}
