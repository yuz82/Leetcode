/*
Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].
Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if(rowIndex<0) return list;
        list.add(1);
        if(rowIndex==0){
            return list;
        }
        list.add(1);
        if(rowIndex==1){
            return list;
        }
        List<Integer> newList = null;
        int tmpRow = 2;
        while(tmpRow <= rowIndex){
            newList = new ArrayList<Integer>();
            for(int i=0;i<=tmpRow;i++){
                if(i==0||i==tmpRow){
                    newList.add(1);
                }else{
                    newList.add(list.get(i)+list.get(i-1));
                }
            }
            list = newList;
            tmpRow++;
        }
        return list;
        
    }
}
