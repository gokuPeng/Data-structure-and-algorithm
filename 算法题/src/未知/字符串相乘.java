package 未知;

/**
 * @author 彭一鸣  43. 字符串相乘   https://leetcode-cn.com/problems/multiply-strings/
 * @since 2020/12/9 19:18
 */
public class 字符串相乘 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder stringBuilder = new StringBuilder(num2);
            for (int j = 0; j < num1.length() - 1 - i; j++) {
                stringBuilder.append("0");
            }
            String temp = oneMultiply(num1.charAt(i), stringBuilder.toString());
            result = add(result, temp);
        }
        return result;
    }

    public String oneMultiply(char num1, String num2) {
        StringBuilder sb = new StringBuilder();
        String a = String.valueOf(num1);
        Integer one = new Integer(a);
        int p = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            String b = String.valueOf(num2.charAt(i));
            Integer two = new Integer(b);
            sb.append((one * two + p) % 10);
            p = (one * two + p) / 10;
        }
        if (p > 0) {
            sb.append(p);
        }
        return sb.reverse().toString();
    }

    public String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        int curOne = num1.length() - 1;
        int curTwo = num2.length() - 1;
        while(curOne != -1 || curTwo != -1) {
            if (curOne != -1 && curTwo != -1) {
                String a = String.valueOf(num1.charAt(curOne));
                String b = String.valueOf(num2.charAt(curTwo));
                Integer one = new Integer(a);
                Integer two = new Integer(b);
                sb.append((one + two + p) % 10);
                p = (one + two + p) / 10;
                curOne--;
                curTwo--;
            } else if (curOne != -1 && curTwo == -1) {
                String a = String.valueOf(num1.charAt(curOne));
                Integer one = new Integer(a);
                sb.append((one + p) % 10);
                p = (one + p) / 10;
                curOne--;
            } else {
                String b = String.valueOf(num2.charAt(curTwo));
                Integer two = new Integer(b);
                sb.append((two + p) % 10);
                p = (two + p) / 10;
                curTwo--;
            }
        }
        if (p > 0) {
            sb.append(p);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        字符串相乘 c = new 字符串相乘();
        String multiply = c.multiply("123", "456");
        System.out.println(multiply);
    }
}
