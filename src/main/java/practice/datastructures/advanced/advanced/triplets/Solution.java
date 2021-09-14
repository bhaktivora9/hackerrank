package practice.datastructures.advanced.advanced.triplets;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

	// Complete the solve function below.
	static int solve(List<Integer> a) {
		HashSet<Integer> set = new HashSet<Integer>(a);
		int sum1 = 0;
		for (Integer integer : set) {
			sum1=sum1+  integer;
		}
		System.out.println(sum1);
		int sum = 0;
		// int listSize = a.size();
		// int diff = set.size();
		HashSet<List<Integer>> indices = new HashSet<>();
		for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			List<Integer> collect = IntStream.range(0, a.size()).boxed().filter(i -> a.get(i).equals(integer))
					.collect(Collectors.toList());
			indices.add(collect);
			/*List<Integer> collect_ = a.stream().filter(i -> i.equals(integer)).map(i -> a.indexOf(i))
					.collect(Collectors.toList());*/
			// List<Integer> collect = a.stream().
			System.out.println(indices);
			int n = collect.size();
			int total = factorial(n);
			sum = sum + total;
		}

		return sum;
	}

	private static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {

			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter :");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int aCount = Integer.parseInt(bufferedReader.readLine().trim());
		System.out.println("Enter :");

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = solve(a);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
