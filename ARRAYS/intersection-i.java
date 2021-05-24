class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],false);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                map.put(nums2[i],true);
            }
        }
        var entries=map.entrySet();
        for(var entry: entries){
            if(entry.getValue()){
                list.add(entry.getKey());
            }
        }
        int[] arr=new int[list.size()];
        int k=0;
        for(int elm:list){
            arr[k++]=elm;
        }
        return arr;
    }
}
