package inflearn.array;

/**
 * DES : N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 *      예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
 *      첫 자리부터의 연속된 0은 무시한다.
 * IN : 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다. 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 * OUT : 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ReversePrimeNumber {
    public ArrayList<String> mySolution(String[] arr) {
        ArrayList<String> sList = new ArrayList<>();

        for (String s : arr) {
            StringBuffer sb = new StringBuffer();
            int reverseNum = Integer.parseInt(sb.append(s).reverse().toString());

            boolean isPrimeNum = true;

            for (int i = 2; i < reverseNum; i++) {
                if (reverseNum % i == 0) {
                    isPrimeNum = false;
                }
            }

            if (isPrimeNum && reverseNum != 1) {
                sList.add(String.valueOf(reverseNum));
            }
        }

        return sList;
    }

    public static void main(String[] args) {
        ReversePrimeNumber T = new ReversePrimeNumber();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.next();
        }

        for (String str : T.mySolution(arr)) {
            System.out.print(str + " ");
        }
    }
}