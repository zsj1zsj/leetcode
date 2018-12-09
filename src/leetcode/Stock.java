package leetcode;

public class Stock {
	public int maxProfit(int[] prices) {

		int n = prices.length;

		if (n < 2)
			return 0;

		int maxPrice = prices[n - 1];
		int max = 0;

		for (int i = n - 2; i >= 0; i--) {
			maxPrice = Math.max(maxPrice, prices[i]);
			max = Math.max(max, maxPrice - prices[i]);
		}
		return max;
	}

	public int maxProfit2(int[] prices) {
		int max = 0;
		int n = prices.length;

		if (n < 2)
			return 0;

		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1])
				max += prices[i] - prices[i - 1];
		}

		return max;
	}

	public int maxProfit3(int[] prices) {
		int n = prices.length;
		int max = 0;
		
		if (n < 2)
			return 0;

		int min = prices[0];
		int max2 = prices[n - 1];

		

		for (int i = 1; i < n; i++) {
			int san1 = 0;
			int san2 = 0;

			min = prices[0];
			for (int j = 1; j <= i; j++) {
				if (prices[j] < min)
					min = prices[j];

				san1 = prices[j] - min > 0 ? prices[j] - min : san1;
			}

			max2 = prices[n - 1];
			for (int k = n - 2; k >= i; k--) {
				if (prices[k] > max2)
					max2 = prices[k];
				san2 = max2 - prices[k] > san2 ? max2 - prices[k] : san2;
			}

			int total = san1 + san2;
			if (total > max)
				max = total;
		}

		return max;
	}

	public static void main(String[] args) {
		Stock s = new Stock();
		int[] prices = { 3,3,5,0,0,3,1,4};
		int result = s.maxProfit3(prices);
		System.out.println(result);
	}
}
