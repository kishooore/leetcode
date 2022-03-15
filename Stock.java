
public class Stock {
    public static void main(String[] args) {
        Stock stock = new Stock();
        int[] prices = {1, 3, 8, 4};
        System.out.print(stock.maxProfit(prices));
    }
    
    public int maxProfit(int[] prices) {
        int minStock = prices[0];
        int maxProfit = 0;
        for (int i = 0; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minStock);
            minStock = Math.max(prices[i], minStock);
        }
        return maxProfit;
    }

}
