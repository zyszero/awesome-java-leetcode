package com.zys.arts.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/3/26 0:29
 * @Modified By:
 */
public class FibonacciNumber {
    class Solution {
        private Map<Integer, Integer> cacheMap = new HashMap<>();
        public int fib(int N) {
            if(cacheMap.containsKey(N)){
                return cacheMap.get(N);
            }
            int result;
            if (N < 2) {
                result =  N;
            }else {
                result = fib(N - 1) + fib(N - 2);
            }
            cacheMap.put(N, result);
            return result;
        }
    }


    class Solution1 {
        public int fib(int N) {
            if ( N == 0 || N == 1){
                return N;
            }
            return Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                    .limit(N + 1)
                    .mapToInt(f -> f[0])
                    .max()
                    .getAsInt();

        }
    }


    class Solution2 {
        public int fib(int N) {
            if(N == 0) {
                return 0;
            }

            return (int)Stream.iterate(
                    new long[]{1, 1},
                    f -> new long[]{f[1], f[0] + f[1]}
            ).mapToLong(f -> f[0]).limit(N).skip(N - 1).findFirst().orElse(0L);
        }
    }
}
