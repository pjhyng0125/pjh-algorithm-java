package inflearn.string;

/**
 * DES : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 *      문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *      단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 *      알파벳 이외의 문자들의 무시합니다.
 * IN : 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 * OUT : 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
 */

import java.util.Scanner;

public class ValidateCircleOnlyAlphabetString {
    public String solution(String s) {
        // 특수문자, 숫자 replace
        String replaceExceptAlphabetStr = s.toUpperCase().replaceAll("[^A-Z]", "");

        String reverseStr = new StringBuffer(replaceExceptAlphabetStr).reverse().toString();

        return (replaceExceptAlphabetStr.equals(reverseStr)) ? "YES" : "NO";
    }
    public String mySolution(String s) {
        // 특수문자, 숫자 replace
        String replaceExceptAlphabetStr = s.toUpperCase().replaceAll("[^A-Z]", "");

        char[] charArr = replaceExceptAlphabetStr.toCharArray();

        int lt = 0, rt = charArr.length - 1;

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
        ValidateCircleOnlyAlphabetString T = new ValidateCircleOnlyAlphabetString();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        System.out.println(T.mySolution(s));
    }
}