package practice.datastructures.stacks.medium.waiter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

	/*
	 * You are a waiter at a party. There is a pile of numbered plates. Create an
	 * empty array. At each iteration, , remove each plate from the top of the stack
	 * in order. Determine if the number on the plate is evenly divisible by the
	 * prime number. If it is, stack it in pile . Otherwise, stack it in stack .
	 * Store the values in from top to bottom in . In the next iteration, do the
	 * same with the values in stack . Once the required number of iterations is
	 * complete, store the remaining values in in , again from top to bottom. Return
	 * the array.
	 * 
	 * 
	 * Example : A => [3,4,7,6,5] q => 1
	 * 
	 * answer = [4,6,3,7,5]
	 * 
	 */

	static List<Integer> prime = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

	/*
	 * Complete the 'waiter' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters:
	 * 
	 * 1. INTEGER_ARRAY number 2. INTEGER q
	 *
	 */

	private static List<Integer> generatePrimeNumbers(int q) {
		List<Integer> collect = new ArrayList<Integer>(prime);
		int i = 1;
		while (!(collect.size() >= q)) {
			int end = i * 1000;
			int start = collect.size() == prime.size() ? 30 : (i - 1) * 1000 + 1;
			System.out.println("Generating prime numbers from " + start + " to " + end);
			List<Integer> collect1 = IntStream.rangeClosed(start, end).parallel().filter(x -> isPrime(x)).boxed()
					.collect(Collectors.toList());
			collect.addAll(collect1);
			i++;
		}

		return collect;
	}

	public static boolean isPrime(int number) {
		return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	}

	public static List<Integer> waiter(List<Integer> number, int q) {

		long start = System.currentTimeMillis();
		if (q > prime.size()) {
			prime = generatePrimeNumbers(q);
		}

		List<Integer> answers = new ArrayList<>();
		Stack<Integer> B = new Stack<>();
		Stack<Integer> A = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		/*
		 * number.stream().forEachOrdered(n -> { A.push(n); });
		 */
		for (int i = 0; i < number.size(); i++) {
			Integer n = number.get(i);
			A.push(n);
		}
		for (int i = 0; i < q; i++) {
			Integer primeNumber = prime.get(i);
			while (!A.isEmpty()) {
				Integer n = A.pop();
				if (n % primeNumber == 0) {
					B.push(n);
				} else {
					temp.push(n);
				}
			}
			A.addAll(temp);
			temp.clear();
			while (!B.isEmpty()) {
				Integer pop = B.pop();
				answers.add(pop);
			}
		}
		while (!A.isEmpty()) {
			int n = A.pop();
			answers.add(n);
		}
		long end = System.currentTimeMillis();
		System.out.println("time taken " + (end - start) + " ms");
		return answers;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		// int n = Integer.parseInt(firstMultipleInput[0]);

		int q = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> result = Result.waiter(number, q);

		result.stream().forEachOrdered(System.out::println);
	}
}
