class Solution {
    bool flag = true;
    int n,m;
    void dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2,int row,int col)
    {
        if(row<0 || col<0 || row>=m || col >= n || !grid2[row][col]) return;
        if(!grid1[row][col]) flag = 0;

        grid1[row][col] = 0;
        grid2[row][col] = 0;
        
        dfs(grid1,grid2,row+1,col);
        dfs(grid1,grid2,row-1,col);
        dfs(grid1,grid2,row,col-1);
        dfs(grid1,grid2,row,col+1);
    }
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        m = grid1.size();
        n = grid1[0].size();
        int count = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid2[i][j])
                {
                    flag = true;
                    // Call DFS Here
                    dfs(grid1,grid2,i,j);
                    count += flag;
                }
            }
        }

        return count;
    }
};
