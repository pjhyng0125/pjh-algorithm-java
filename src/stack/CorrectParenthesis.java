package stack;

/**
 * DES : 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 *      (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 * IN : 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 * OUT : 첫 번째 줄에 YES, NO를 출력한다.
 */

import java.util.Scanner;
import java.util.Stack;

public class CorrectParenthesis {
    public String mySolution(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty())
                    return "NO";
                stack.pop();
            }
        }

        answer = stack.isEmpty() ? "YES" : "NO";

        return answer;
    }

    public static void main(String[] args) {
        CorrectParenthesis T = new CorrectParenthesis();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.mySolution(str));
    }
}