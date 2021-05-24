/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    static void printMinMax(int[] arr){
        int n=arr.length;
        int max,min;
        if(n%2==0){
            if(arr[0]>arr[1]){
                max=arr[0];
                min=arr[1];
            }
            else{
                max=arr[1];
                min=arr[0];
            }
        }
        else{
            max=arr[0];
            min=arr[0];
        }
        for(int i=2;i<=n-1;){
            if(arr[i]>arr[i+1]){
                if(arr[i]>max){
                    max=arr[i];
                }
                if(arr[i+1]<min){
                    min=arr[i+1];
                }
            }
            else{
                if(arr[i+1]>max){
                    max=arr[i+1];
                }
                if(arr[i]<min){
                    min=arr[i];
                }
            }
            i+=2;
        }
        System.out.println("max: "+max+"\nmin: "+min);
    }
	public static void main (String[] args) {
	    int[] arr={10,2,6,3,80,4,0,1};
	    printMinMax(arr);
	}
}
