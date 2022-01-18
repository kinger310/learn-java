package com.wd.demo.toffer.backtrack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: wangdi
 * @Date: 2022/1/17 21:59
 */
public class Offer105 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
        // System.out.println(new Solution().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));

    }

    private static class Solution {
        boolean[][] visited;
        int m, n;
        int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int maxAreaOfIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            visited = new boolean[m][n];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        ans = Math.max(ans, bfs(grid, i, j));
                    }
                }
            }
            return ans;
        }

        private int bfs(int[][] grid, int i, int j) {
            int counter = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i * n + j);
            while (!q.isEmpty()) {
                int loc = q.poll();
                int x = loc / n, y = loc % n;
                visited[x][y] = true;
                counter++;
                for (int[] dt : d) {
                    int xt = x + dt[0], yt = y + dt[1];
                    if (0 <= xt && xt < m && 0 <= yt && yt < n && grid[xt][yt] == 1
                            && !visited[xt][yt]) {
                        q.offer(xt * n + yt);
                        visited[xt][yt] = true;
                    }
                }
            }
            return counter;
        }
    }
}
