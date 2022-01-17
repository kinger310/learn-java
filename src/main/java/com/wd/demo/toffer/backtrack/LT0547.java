package com.wd.demo.toffer.backtrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: wangdi
 * @Date: 2022/1/17 22:55
 */
public class LT0547 {
    public static void main(String[] args) {
        System.out.println();
    }

    static class Solution {
        
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int counter = 0;
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    q.offer(i);
                    while (!q.isEmpty()) {
                        int j = q.poll();
                        visited[j] = true;
                        for (int k = 0; k < n; k++) {
                            if (isConnected[j][k] == 1 && !visited[k]) {
                                q.offer(k);
                            }
                        }
                    }
                    counter++;
                }
            }
            return counter;
        }
    }

}
