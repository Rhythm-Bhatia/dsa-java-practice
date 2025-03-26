// class Solution {
//     public int minOperations(int[][] grid, int x) {
//         int arr[]=Arrays.stream(grid).flatMapToInt(Arrays::stream).toArray();

//         for(int i=0;i<arr.length;i++){
//             if(arr[i] % x != 0){
//                 return -1;
//             }
//             else{
//                 for(int j=0;j<arr.length;j++){
//                     int a=arr[j];
//                     for(int k=0;k<arr.length;k++){
//                         for(int l=1;l<5;l++){
//                             if((arr[k]+x*l)==a||(arr[k]-x*l)==a){

//                             }
//                         }
                        
//                     }
//                 }
//             }


//         }
//         return 0;
//     }
// }   
import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        // Flatten the 2D grid into a 1D array
        int arr[] = Arrays.stream(grid)
                          .flatMapToInt(Arrays::stream)
                          .toArray();

        // Check if all elements can be converted to the same number
        for (int num : arr) {
            if ((num - arr[0]) % x != 0) {
                return -1;
            }
        }

        // Sort the array to find the median
        Arrays.sort(arr);
        int median = arr[arr.length / 2];  // Median minimizes the total moves

        // Calculate the minimum number of operations
        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
