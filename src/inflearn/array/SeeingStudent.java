package inflearn.array;

/**
 * DES : 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
 *      선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 * IN : 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 * OUT : 선생님이 볼 수 있는 최대학생수를 출력한다.
 */

import java.util.Scanner;

public class SeeingStudent {
    public int mySolution(int n, int[] arr) {
        int cnt = 1;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        SeeingStudent T = new SeeingStudent();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(T.mySolution(n, arr));
    }
}