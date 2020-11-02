package 栈;

import java.util.LinkedList;

public class 字符串解码 {

}
class Solution {
    int p = 0;
    public String decodeString(String s) {
        LinkedList<String> list = new LinkedList<>();
        while (p < s.length()) {
            char c = s.charAt(p);
            System.out.println(c);
            if (Character.isDigit(c)) {
                String num = getDigit(s);
                list.addLast(num);
            } else if ("[".equals(c) || Character.isLetter(c)) {
                p++;
                list.addLast(String.valueOf(c));
            } else {
                p++;
                StringBuffer sb = new StringBuffer();
                while (!"[".equals(list.peekLast())) {
                    String removeLast = list.removeLast();
                    new StringBuffer(removeLast).reverse();
                    sb.append(removeLast);
                }
                sb.reverse();
                // pop出[
                list.removeLast();
                // pop出数字
                String numStr = list.removeLast();
                int num = Integer.valueOf(numStr);
                StringBuffer n = new StringBuffer();
                while (num-- > 0) {
                    n.append(sb);
                }
                list.addLast(n.toString());
            }
            System.out.println(list);
        }
        return getString(list);

    }
    public String getDigit(String s) {
        StringBuffer sb = new StringBuffer();
        while(Character.isDigit(s.charAt(p))) {
            sb.append(s.charAt(p++));
        }
        return sb.toString();
    }
    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}