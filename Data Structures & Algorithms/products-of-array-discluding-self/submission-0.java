class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];

        //step 1: prefix/left multiply
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }

        //step 2:right multiply
        int right=1;

        for(int i=n-1;i>=0;i--){
            res[i]=res[i]*right;//left*right

            //update right
            right=right*nums[i];
        }
        return res;
    }
}  
