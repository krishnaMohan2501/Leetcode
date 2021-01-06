class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int length = nums.length;
        int[] left_array = new int[length];
        int[] right_array = new int[length];
        int[] output_array = new int[length];
        
        // initialize
        left_array[0] = nums[0];
        right_array[length-1] = nums[length-1];
        
        // precompute left_array and right array multiplication
        for(int i = 1; i<length; i++){
            left_array[i] = left_array[i-1] * nums[i]; 
        }
        for(int j = length-1;j>0; j--){
            right_array[j-1] = right_array[j] * nums[j-1]; 
        }
        
        for(int k=0;k<length;k++){
            
            if(k==0){
                output_array[k] = right_array[k+1];
            }else if(k==length-1){
                output_array[k] = left_array[k-1]; 
            }else{
                output_array[k] = left_array[k-1] * right_array[k+1];
            }
        }
        return output_array;
        
        
    }
}
