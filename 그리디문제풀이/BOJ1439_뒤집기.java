import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1439_뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int zero = 0;
		int one = 0;
		if (str.charAt(0) == '0') {
			one++;
		} else {
			zero++;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				if (str.charAt(i + 1) == '0') {
					one++;
				} else {
					zero++;
				}
			}
		}
		System.out.println(Math.min(zero, one));
	}
}
