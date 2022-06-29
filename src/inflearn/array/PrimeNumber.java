package inflearn.array;

/**
 * DES : 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 *      만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 * IN : 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 * OUT : 첫 줄에 소수의 개수를 출력합니다.
 */

import java.util.Scanner;

public class PrimeNumber {
    public int solution(int n) {
        // 2중 for 문 지양
        // 에라토스테네스 체
        // 소수 : 2보다 큰 자연수 중 1과 자기 자신을 제외한 자연수로는 나누어지지 않는 자연수
        int cnt = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if(arr[i] == 0) {
                cnt++;
                for (int j = i;  j <= n; j = j + i) { // i의 배수 만큼 증가
                    arr[j] = 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        PrimeNumber T = new PrimeNumber();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.print(T.solution(n));
    }
}