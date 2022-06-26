package inflearn.string;

/**
 * DES : 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요. 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 * IN : 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 * OUT : 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 */

import java.util.Scanner;

public class RemoveDupString {
    public String mySolution(String s) {
        StringBuffer answerBuf = new StringBuffer();

        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            String str = String.valueOf(c);
            if (answerBuf.indexOf(str) == -1) {
                answerBuf.append(c);
            }
        }
        return answerBuf.toString();
    }

    public static void main(String[] args) {
        RemoveDupString T = new RemoveDupString();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.mySolution(s));
    }
}