public class Leetcode {

    /**
     * @param args the command line arguments
     */
    
    
    public static void mergeSort(int[] nums, int start, int end) {
        if(end-start>1){
            int mid = start + (end-start)/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid, end);
            int n = end-start;
            int[] tmp = new int[n];
            int i = start, j = mid;
            for(int k=0;k<n;k++){
                if(i==mid){
                    tmp[k] = nums[j++];
                }else if(j==end) {
                    tmp[k] = nums[i++];
                }else if(i<mid && j<end){
                    tmp[k] = nums[i]<nums[j]? nums[i++] : nums[j++];
                }
            }
            for(int k=0;k<n;k++) {
                nums[k+start] = tmp[k];
            }
        }
    }
    

    public static void main(String[] args) {
        int[] nums = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43}; 
        int n = nums.length;
        mergeSort(nums, 0, n);
        for(int i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
    }
    
}
