
public class Stock {
    public static void main(String[] args) {
        Stock stock = new Stock();
        int[] prices = {2,4,1};
        System.out.print(stock.maxProfit(prices));
    }
    
    public int maxProfit(int[] prices) {
        int minIndex = min(prices);
        int maxProfit = 0;
        for (int i = minIndex + 1; i<prices.length; i++) {
            int profit = prices[i] - prices[minIndex];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    private int min(int[] prices) {
        int min = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
            }
        }
        return min;
    }
}
