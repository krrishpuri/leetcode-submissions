class Solution {
    public int maxProfit(int[] prices) {
       int minPrice=Integer.MAX_VALUE;//we initialize the min values as max as we don't know the current max value
       int maxProfit=0;
       //then we don't know the maxprofit so we set it to 0
       for(int i=0;i<prices.length;i++){
        //we do a for loop
        if(prices[i]<minPrice){
            //if prices[i] is less the minprice so in array 7 is less then infinity so new value is 7
            minPrice=prices[i];
           // so new value of minPrice is 7
        }
        else{
            int profit=prices[i]-minPrice;
            //profit is equal to price[i]-minPrice
            maxProfit=Math.max(profit,maxProfit);
            //then we get the maxprofit by using the Math.max

        }
       } 

       return maxProfit;
    }
}
