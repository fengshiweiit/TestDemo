package leetcode;

/**
 * @Description
 * @Date 2019/6/26 20:41
 * @Created by Feng Shiwei
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class Demo18 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int beforeMin = getBeforeMin(prices, i);
            if (beforeMin == prices[i]){
                continue;
            }
            //当天最大收益
            int profit = prices[i] - beforeMin;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

        }
        return maxProfit;
    }

    private static int getBeforeMin(int[] prices, int i) {
        int price = prices[i];
        for (int j = 0; j < i; j++) {
            if (prices[j] < price) {
                price = prices[j];
            }
        }
        return price;
    }
}
