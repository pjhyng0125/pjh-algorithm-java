package inflearn.string;

/**
 * DES : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 *      문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *      단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 * IN : 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 * OUT : 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 */

import java.util.Scanner;

public class ValidateCircleString {
    public String mySolution(String s) {
        char[] charArr = s.toCharArray();
        int lt = 0, rt = s.length() - 1;

        boolean isCircleStr = true;

        while(lt < rt) {
            // 대소문자 구분 X => 대문자 통일
            char ltChar = Character.toUpperCase(charArr[lt]);
            char rtChar = Character.toUpperCase(charArr[rt]);

            // 회문 비교
            if (ltChar != rtChar) {
                isCircleStr = false;
                break;
            }

            // index 증감
            lt++;
            rt--;
        }

        return isCircleStr ? "YES" : "NO";
    }

    public static void main(String[] args) {
        ValidateCircleString T = new ValidateCircleString();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.mySolution(s));
    }
}