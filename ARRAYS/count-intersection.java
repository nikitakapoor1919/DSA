class Solution{
    //Function to return the count of the number of elements in
    //the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[],int b[],int n,int m)
    {
        int count=0;
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(a[i],false);
        }
        for(int i=0;i<m;i++){
            if(map.containsKey(b[i])){
                map.put(b[i],true);
            }
        }
        for(Map.Entry<Integer,Boolean> entry:map.entrySet()){
            if(entry.getValue()){
                count++;
            }
        }
        return count;
    }
};
