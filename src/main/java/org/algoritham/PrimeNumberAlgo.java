package org.algoritham;

public class PrimeNumberAlgo {

	public static void main(String[] args) {

		int n = 39;
		findPrimePair(n);
	}

	static void findPrimePair(int n) {
		boolean[] isPrime = new boolean[n + 1];

		listofPrimes(39, isPrime);

		for (int i = 2; i < n; i++) {
			int j = n / i;

			if (isPrime[i] && isPrime[j] && i * j == n) {

				System.out.println("is prime " + i + "   " + j);
				break;
			}
		}

	}

	static void listofPrimes(int n, boolean isPrime[]) {
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= n; i++)
			isPrime[i] = true;

		for (int p = 2; p * p <= n; p++) {

			if (isPrime[p] == true) {

				for (int i = p * 2; i <= n; i += p)
					isPrime[i] = false;
			}

		}
	}

}
