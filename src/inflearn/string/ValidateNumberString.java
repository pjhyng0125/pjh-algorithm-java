package inflearn.string;

/**
 * DES : 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 *      만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 *      추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 * IN : 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 * OUT : 첫 줄에 자연수를 출력합니다.
 */

import java.util.Scanner;

public class ValidateNumberString {
    public String solution1(String s) {
        int CHAR_ZERO = 48;
        int CHAR_NINE = 57;
        char[] charArr = s.toCharArray();
        int answer = 0;

        // char는 원래 숫자! ex) '0' = 48, '9' = 57
        for (char c : charArr) {
            if (c >= CHAR_ZERO && c <= CHAR_NINE) {
                answer = answer * 10 + (c - 48);
            }
        }
        return String.valueOf(answer);
    }

    public int solution2(String s) {
        char[] charArr = s.toCharArray();
        String answer = "";

        // char는 원래 숫자! ex) '0' = 48, '9' = 57
        for (char c : charArr) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        return Integer.parseInt(answer);
    }

    public String mySolution(String s) {
        String replaceExceptNumberStr = s.replaceAll("[^0-9]", "");
        int answer = Integer.parseInt(replaceExceptNumberStr);
        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        ValidateNumberString T = new ValidateNumberString();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.mySolution(s));
    }
}