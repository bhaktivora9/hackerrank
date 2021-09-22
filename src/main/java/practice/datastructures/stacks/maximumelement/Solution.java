package practice.datastructures.stacks.maximumelement;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'getMax' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * STRING_ARRAY operations as parameter.
	 */
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> max = new Stack<>();

	public static List<Integer> getMax(List<String> operations) {
		List<Integer> result = new ArrayList<>();
		for (Iterator<String> iterator = operations.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			String[] split = string.split(" ");
			int parseInt = Integer.parseInt(split[0]);
			switch (parseInt) {
			case 1:
				int parseInt2 = Integer.parseInt(split[1]);
				push(parseInt2);
				break;
			case 2:
				delete();
				break;
			case 3:
				if (!max.isEmpty()) {
					Integer peek = max.peek();
					//System.out.println(peek);
					result.add(peek);
				}
				break;
			}
		}
		return result;

	}

	private static void delete() {
		stack.pop();
		max.pop();
	}

	private static void push(int parseInt2) {
		if (stack.isEmpty() && max.isEmpty()) {
			stack.push(parseInt2);
			max.push(parseInt2);
		} else {
			stack.push(parseInt2);
			if (max.peek() <= parseInt2) {
				max.push(parseInt2);
			}else {
				max.push(max.peek());
			}
		}
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> ops = IntStream.range(0, n).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<Integer> res = Result.getMax(ops);
		System.out.println(res.stream().map(Object::toString).collect(joining("\n")) + "\n");
		// bufferedWriter.write(res.stream().map(Object::toString).collect(joining("\n"))
		// + "\n");

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
