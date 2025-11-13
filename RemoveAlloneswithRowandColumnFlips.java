/*3.Remove All Ones with Row and Column Flips

You are given an m x n binary matrix grid.
In one operation, you can choose any row or column and flip each value in that row or column 
(i.e., changing all 0's to 1's, and all 1's to 0's).
Return true if it is possible to remove all 1's from grid using any number of operations or false otherwise.

Example 1:
0   1   0           0   1   0           0   0   0
1   0   1 ------>   0   1   0  ------>  0   0   0
0   1   0           0   1   0           0   0   0
Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
Output: true
Explanation: One possible way to remove all 1's from grid is to:
- Flip the middle row
- Flip the middle column

Example 2:
1   1   0           0   0   1           1   1   0
0   0   0  ----->   0   0   0  ----->   0   0   0
0   0   0           0   0   0           0   0   0
Input: grid = [[1,1,0],[0,0,0],[0,0,0]]
Output: false
Explanation: It is impossible to remove all 1's from grid.

Example 3:
Input: grid = [[0]]
Output: true
Explanation: There are no 1's in grid.


case =1
input =3 3
1 0 1
0 1 0
1 0 1
output =true

case =2
input =4 5
0 1 0 0 0
1 0 0 1 0
1 0 1 1 1
1 0 0 0 1
output =false

case =3
input =6 7
1 0 1 0 1 0 1
0 1 0 1 0 1 0
1 0 1 0 1 0 1
0 1 0 1 0 1 0
1 0 1 0 1 0 1
0 1 0 1 0 1 0
output =true

case =4
input =4 5
0 0 1 1 1
1 1 0 0 0
0 0 1 1 1
1 1 0 0 0
output =true

case =5
input =6 7
1 0 1 0 1 0 1
0 1 0 1 0 1 0
1 1 1 0 1 0 1
0 1 0 1 0 1 0
1 0 1 0 1 0 1
0 1 0 1 0 1 0
output =false

case =6
input =8 5
0 0 0 1 1
1 1 0 0 1
1 1 0 0 1
1 0 1 1 1
1 0 0 0 0
1 1 1 1 1
1 1 0 0 1
1 0 1 0 0
output =false



*/

import java.util.*;
class RemoveAllOneswithFlips
{
    public boolean removeOnes(int[][] grid)
 {
        int row = grid.length; // get dimensions of grid
        int col = grid[0].length;

        for (int c= 0; c < col; c++) 
      { // flip columns so that first row only has 0's
            if (grid[0][c] == 1)
              {
                for (int r = 0; r < row; r++) 
                   { // flips a column
                    grid[r][c] ^= 1;
                }
            }
        }
        
        for (int r = 1; r < row; r++)
         { // checks if each row has all 0's or all 1's
            int sum = 0;
            for (int c = 0; c < col; c++)
             {
                sum += grid[r][c];
            }
            if (sum!=0 && sum!=col) 
            {
                return false;
            }
            
        }
        return true;
    }

public static void main(String args[])
   {
    Scanner sc=new Scanner(System.in);
    int m=sc.nextInt();

    int n=sc.nextInt();

    int grid[][]=new int[m][n];
    
    for(int i=0;i<m;i++)
    {
    for(int j=0;j<n;j++)
       {
        grid[i][j]=sc.nextInt();
      }
   } 
    System.out.println(new RemoveAllOneswithFlips().removeOnes(grid));
   }
}

