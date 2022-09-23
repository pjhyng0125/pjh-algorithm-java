package stack;

/**
 * DES : 입력된 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 * IN : 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 * OUT : 남은 문자만 출력한다.
 */

import java.util.Scanner;
import java.util.Stack;

public class DeleteParentheses {
    // Stack 활용
    public String solution(String str) {
        StringBuffer buf = new StringBuffer();
        String answer = "";

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while(stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            buf.append(stack.get(i));
        }

        answer = buf.toString();

        return answer;
    }

    //
    public String mySolution(String str) {
        StringBuffer buf = new StringBuffer();
        String answer = "";

        Stack<Character> stack = new Stack<>();
        int pCnt = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                pCnt++;
            } else if (c == ')') {
                pCnt--;
            } else if (pCnt == 0) {
                buf.append(c);
            }
        }
        answer = buf.toString();

        return answer;
    }

    public static void main(String[] args) {
        DeleteParentheses T = new DeleteParentheses();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.mySolution(str));
    }
}