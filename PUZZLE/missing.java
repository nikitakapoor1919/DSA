class Solution {
    int MissingNumber(int array[], int n) {
        int z=0;
        for(int i=0;i<array.length;i++){
            z=z^array[i];
        }
        for(int i=1;i<=n;i++){
            z=z^i;
        }
        return z;
    }
}
