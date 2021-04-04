package 贪心;

import java.util.TreeMap;

/**
 * @author 彭一鸣 1801. 积压订单中的订单总数 https://leetcode-cn.com/problems/number-of-orders-in-the-backlog/
 * @since 2021/4/4 16:21
 */
public class 积压订单中的订单总数 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        long ans = 0;
        TreeMap<Integer, Integer> buyMap = new TreeMap();
        TreeMap<Integer, Integer> saleMap = new TreeMap();
        for (int i = 0; i < orders.length; i++) {
            int num = orders[i][1];
            if (orders[i][2] == 0) {
                // 寻找销售订单中<=当前价格的订单
                while (num > 0) {
                    if (saleMap.size() == 0 || saleMap.firstKey() == null || saleMap.firstKey() > orders[i][0]) {
                        buyMap.put(orders[i][0], buyMap.get(orders[i][0]) != null ?
                                num + buyMap.get(orders[i][0]) : num);
                        break;
                    }
                    Integer firstKey = saleMap.firstKey();
                    Integer saleNum = saleMap.get(firstKey);
                    if (num < saleNum) {
                        saleMap.put(firstKey, saleNum - num);
                        break;
                    } else {
                        saleMap.remove(firstKey);
                        num -= saleNum;
                    }
                }
            } else {
                // 寻找采购订单中>=当前价格的订单
                while (num > 0) {
                    if (buyMap == null || buyMap.size() == 0 || buyMap.lastKey() == null || buyMap.lastKey() < orders[i][0]) {
                        saleMap.put(orders[i][0], saleMap.get(orders[i][0]) != null ?
                                num + saleMap.get(orders[i][0]) : num);
                        break;
                    }
                    Integer lastKey = buyMap.lastKey();
                    Integer saleNum = buyMap.get(lastKey);
                    if (num < saleNum) {
                        buyMap.put(lastKey, saleNum - num);
                        break;
                    } else {
                        buyMap.remove(lastKey);
                        num -= saleNum;
                    }
                }
            }
        }
        for (Integer integer : saleMap.values()) {
            ans += integer;
        }
        for (Integer value : buyMap.values()) {
            ans += value;
        }
        return (int) (ans  % (Math.pow(10, 9) + 7));
    }
}
