package 贪心;

/**
 * @author 彭一鸣  860. 柠檬水找零  https://leetcode-cn.com/problems/lemonade-change/
 * @since 2021/2/3 11:30
 */
public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        // a,b,c分别代表商家手里5,10,20美元的钱
        int a = 0, b = 0, c = 0;
        for (int bill : bills) {
            // 先把钱拿到手再说
            switch (bill) {
                case 5:
                    a++;
                    break;
                case 10:
                    b++;
                    break;
                case 20:
                    c++;
                    break;
            }
            // 开始找钱
            switch (bill) {
                case 10:
                    if (a == 0) {
                        return false;
                    }
                    a--;
                    break;
                case 20:
                    if (b > 0) {
                        // 找一张十块，一张五块
                        b--;
                        if (a < 1) {
                            return false;
                        }
                        a--;
                    } else {
                        // 找三张五块
                        if (a < 3) {
                            return false;
                        }
                        a -= 3;
                    }
                    break;
            }
        }
        return true;
    }
}
