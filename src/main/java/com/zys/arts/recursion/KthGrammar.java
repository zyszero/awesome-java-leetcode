package com.zys.arts.recursion;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/4/13 17:54
 * @Modified By:
 */
public class KthGrammar {
    public int kthGrammar(int N, int K) {
        // 以已有的条件可得
        if (N == 1){
            return 0;
        }
        // 当前 N 行的长度
        int currMaxLength = (int)Math.pow(2, N-1);
        // 当前 N 行的一半长度，即上一行的长度
        int midLength = currMaxLength / 2;
        // 当 K 值小于等于当前行的一半长度时，第 N 行的第 K 位的值等于上一行的 第 K 位的值
        if (K <= midLength){
            return kthGrammar(N - 1, K);
        }else{
            // 当 K 值大于当前行的一半长度时，第 N 行的第 K 位的值等于上一行第 K - midLength 位的值与 1 的异或值
            return kthGrammar(N-1, K- midLength) ^ 1;
        }
    }


}
