import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 특정 수 까지 증가하고 그 이후부터는 감소
// 가장 긴 부분 수열을 왼쪽에서 오른쪽으로 한번,
// 오른쪽에서 왼쪽으로 한번 적용
// 각 위치까지의 가장 긴 증가하는 길이와 감소하는 길이 정보를 모두 얻음
// 그리고 두배열을 합친 후, 가장 큰 값을 가져온다
// 자기자신을 포함하기때문에 -1

public class BOJ11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] dpi = new int[N]; // 증가 수열
		int[] dpd = new int[N]; // 감소 수열
		int[] dp = new int[N]; // 합친 수열

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			dpi[i] = 1;
			dpd[N - i - 1] = 1;

			for (int j = 0; j < N; j++) {
				if (arr[i] > arr[j] && dpi[i] < dpi[j] + 1) {
					dpi[i] = dpi[j] + 1;
				}
				if (arr[N - i - 1] > arr[N - j - 1] && dpd[N - i - 1] < dpd[N - j - 1] + 1) {
					dpd[N - i - 1] = dpd[N - j - 1] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = dpi[i] + dpd[i];
			max = Math.max(max, dp[i]);
		}

		System.out.println(max - 1);
	}
}
