package practice.datastructures.stacks.medium.balancebrackets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'isBalanced' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String isBalanced(String s) {
		// Write your code here
		String replace = s;
		int n = -1;
		
		while (replace.length() != n) {
			n = replace.length();
			replace = replace.replace("[]", "");

			replace = replace.replace("()", "");
			replace = replace.replace("{}", "");
		}

		if (replace.length() == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String s = bufferedReader.readLine();

				String result = Result.isBalanced(s);
				// System.out.println(result);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
