import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 조건이 없는 경우 기본 점화식
// dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
// 조건을 추가하면
// dp[n] = dp[n-1] + 1에서 dp[n-1]을 만드는 식에서 1이 나오면 조건 위배 (2,3도 마찬가지)
// dp[n][1] = dp[n-1][2] + dp[n-1][3] 
// dp[n][2] = dp[n-1][1] + dp[n-1][3]
// dp[n][3] = dp[n-1][1] + dp[n-1][2]
public class BOJ15990_123더하기5 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int q = 1000000009;
		long[][] dp = new long[100001][4];
		// 1 => 1, 2 => 2, 3 => 1+2, 2+1, 3
		dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

		for (int i = 4; i < dp.length; i++) {
			for (int j = 1; j <= 3; j++) {
				if (j == 1) {
					dp[i][j] = dp[i - 1][2] + dp[i - 1][3];
				} else if (j == 2) {
					dp[i][j] = dp[i - 2][1] + dp[i - 2][3];
				} else {
					dp[i][j] = dp[i - 3][1] + dp[i - 3][2];
				}
				dp[i][j] %= q;
			}
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			for (int j = 1; j <= 3; j++) {
				ans += dp[N][j];
				ans %= q;
			}
			sb.append(ans).append('\n');
		}

		System.out.println(sb.toString());
	}
}
