// 특정 숫자를 한 번 삭제할 수도 있고, 아닐 수도 있다
// dp[i][j]: arr[1]~arr[i]까지의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1912_연속합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];

		int[][] dp = new int[N][2]; // i번째를 삭제했을때, 삭제하지 않았을때로 구분

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = dp[0][0] = dp[0][1] = arr[0];

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
			ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
		}
		System.out.println(ans);
	}
}
