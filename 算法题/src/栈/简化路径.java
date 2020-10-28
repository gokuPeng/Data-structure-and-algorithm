package 栈;

import java.util.Stack;

// 71. 简化路径 https://leetcode-cn.com/problems/simplify-path/
public class 简化路径 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String s : split) {
            switch (s){
                case "":
                    break;
                case ".":
                    break;
                case "..":
                    if (!stack.empty()) stack.pop();
                    break;
                default:
                    stack.push(s);
            }
        }
        if (stack.empty()) return "/";
        String result = "";
        for (String s : stack) {
            result = result + "/" + s;
        }
        return result;
    }
}
