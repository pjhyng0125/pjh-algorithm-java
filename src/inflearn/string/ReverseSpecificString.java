package inflearn.string;

/**
 * DES : 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 * IN : 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 * OUT : 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class ReverseSpecificString {
    public String mySolution(String s) {
        StringBuffer reverseBuf = new StringBuffer();

        int lt = 0, rt = s.length() - 1;
        char[] charArr = s.toCharArray();

        while (lt < rt) {
            char ltChar = charArr[lt];
            char rtChar = charArr[rt];

            if (isSpecialChar(ltChar)) {
                lt++;
            } else if (isSpecialChar(rtChar)) {
                rt--;
            } else {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        String answer = String.valueOf(charArr);

        return answer;
    }

    private boolean isSpecialChar(char c) {
        Pattern p = Pattern.compile("[!@#$%^&*(),.?\\\":{}|<>]");
        return p.matcher(String.valueOf(c)).find();
    }

    public static void main(String[] args) {
        ReverseSpecificString T = new ReverseSpecificString();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(T.mySolution(s));
    }
}