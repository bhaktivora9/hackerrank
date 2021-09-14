package practice.datastructures.arrays.medium.sparse_arrays;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'matchingStrings' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters:
	 * 
	 * 1. STRING_ARRAY strings 2. STRING_ARRAY queries
	 * 
	 */

	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
		List<Integer> arrCount = new ArrayList<>();
		queries.parallelStream().forEachOrdered(q -> {
			long count = strings.parallelStream().filter(s -> s.contentEquals(q)).count();
			String string = Long.toString(count);
			arrCount.add(Integer.parseInt(string));
		});
		return arrCount;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<Integer> res = Result.matchingStrings(strings, queries);

		// bufferedWriter.write(res.stream().map(Object::toString).collect(joining("\n"))
		// + "\n");
		System.out.print(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
//		bufferedWriter.close();
	}
}
