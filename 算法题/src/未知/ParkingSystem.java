package 未知;

/**
 * @author 彭一鸣 1603. 设计停车系统 https://leetcode-cn.com/problems/design-parking-system/
 * @since 2021/3/19 15:29
 */
public class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean ans = false;
        if (carType == 1 && this.big-- > 0) {
            ans = true;
        }
        if (carType == 2 && this.medium-- > 0) {
            ans = true;
        }
        if (carType == 3 && this.small-- > 0) {
            ans = true;
        }
        return ans;
    }
}
