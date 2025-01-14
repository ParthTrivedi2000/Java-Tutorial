package org.allTopics.DynamicProgramming.DP2D;

// Problem Link :- https://leetcode.com/problems/dungeon-game/description/

public class DP03DungeonPrincessGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int health[][] = new int[n][m];
        int h=0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1&&j==m-1){
                    h = (1-dungeon[i][j])>0?1-dungeon[i][j]:1;
                    health[i][j] = h;
                }
                else if(i==n-1){
                    h = (health[i][j+1]-dungeon[i][j])>0?health[i][j+1]-dungeon[i][j]:1;
                    health[i][j] = h;
                }
                else if(j==m-1){
                    h = (health[i+1][j]-dungeon[i][j])>0?health[i+1][j]-dungeon[i][j]:1;
                    health[i][j] = h;
                }
                else{
                    int down = (health[i+1][j]-dungeon[i][j])>0?health[i+1][j]-dungeon[i][j]:1;
                    int right = (health[i][j+1]-dungeon[i][j])>0?health[i][j+1]-dungeon[i][j]:1;
                    health[i][j] = Math.min(down,right);
                }
            }
        }
        return health[0][0];
    }
}
