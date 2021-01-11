import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//스티커 2n개를 구매
//2행 n열로 배치
//스티커 한장을 떼면 변을 공유하는 스티커는 모두 찢어져서 사용 불가 (왼쪽 오른쪽 위 아래 사용 불가)
//점수합이 최대가 되게 스티커를 떼어내려고함
// 윗줄의 첫 시작칸을 선택한 경우 => 아래로 보는 대각선
// 아랫줄의 첫 시작칸을 선택한 경우 => 위로 보는 대각선
// 두칸 전에서도 확인 필요
// 100 1 1
// 1   1 100
// 이 경우에는 100 + 100 = 200이 가장 큼

public class BOJ9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N + 1];
			for (int i = 0; i < sticker.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[2][N + 1];
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
			}
			sb.append(Math.max(dp[0][N], dp[1][N])).append('\n');
		}
		System.out.println(sb.toString());
	}
}
