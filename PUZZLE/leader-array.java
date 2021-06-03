public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> list=new ArrayList<>();
        int msf=A.get(A.size()-1);
        list.add(msf);
        for(int i=A.size()-2;i>=0;i--){
            if(A.get(i)>msf){
                msf=A.get(i);
                list.add(msf);
            }
        }
        return list;
    }
}
