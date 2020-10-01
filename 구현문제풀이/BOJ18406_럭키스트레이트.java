import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18406_럭키스트레이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() / 2) {
				sum += (str.charAt(i) - '0');
			} else {
				sum -= (str.charAt(i) - '0');
			}
		}
		System.out.println((sum == 0) ? "LUCKY" : "READY");
	}
}
