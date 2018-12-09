package leetcode;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n+1];
        ugly[0]=1;
        int[] pointer = new int[primes.length];
        for(int i=1;i<n;i++) {
            int min=Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j=0;j<primes.length;j++) {
                if(ugly[pointer[j]]*primes[j]<min) {
                    min=ugly[pointer[j]]*primes[j];
                    minIndex = j;
                }else if(ugly[pointer[j]]*primes[j]==min) {
                    pointer[j]++;
                }
            }
            ugly[i]=min;
            pointer[minIndex]++;
        }
        return ugly[n-1];
    }


	public static void main(String[] args) {

		SuperUglyNumber s = new SuperUglyNumber();
		int[] primes = {5,7,13,17,23,29,31,43,53,59,61,71,73,79,83,97,109,131,137,163,167,181,191,193,197,199,227,233,251,263};

		System.out.println(s.nthSuperUglyNumber(500, primes));
	}
}
