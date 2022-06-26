package inflearn.string;

/**
 * DES : N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 * IN : 첫 줄에 자연수 N(3<=N<=20)이 주어집니다. 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 * OUT : N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseString {
    // toCharArray(), 직접 바꾸기
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answerList = new ArrayList<>();

        for (String x : str) {
            char[] charArr = x.toCharArray();
            int lt = 0, rt = x.length() - 1;
            while (lt < rt) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt ++;
                rt --;
            }
            String tmp = String.valueOf(charArr);
            answerList.add(tmp);
        }

        return answerList;
    }

    // StringBuffer.reverse()
    public String[] mySolution(int n, String[] strArr) {
        String[] answerArr = new String[n];

        for (int i = 0; i < strArr.length; i++) {
            StringBuffer sb = new StringBuffer(strArr[i]);
            answerArr[i] = sb.reverse().toString();
        }

        return answerArr;
    }

    public static void printAnswer(String[] answerArr) {
        for (String answer : answerArr) {
            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        ReverseString T = new ReverseString();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        // n 개 입력
        String[] strArr = new String[n];
        for (int i = 0; i < n; i ++) {
            strArr[i] = kb.next();
        }
        printAnswer(T.mySolution(n, strArr));
    }
}