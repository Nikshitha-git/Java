public class maze {
    public static boolean findpath(int[][]maze,int i,int j)
    {
        int n=maze.length;
        if(i==n-1 && j==n-1 && maze[i][j]==1)
        {
            return true;
        }
        if(isSafe(maze,i,j)){
            if(findpath(maze, i+1, j)){
                return true;
            }
            if(findpath(maze, i, j+1)){
                return true;
            }
        }
        return false;
    }
    private static boolean isSafe(int[][]maze,int i,int j)
    {
        return i>=0 &&  j>=0 && i<maze.length && maze[i][j]==1;
    }
    public static void main(String[] args) {
        int[][] maze ={
            {1, 0, 0},
            {1, 1, 0},
            {0, 1, 1}
        };
        if(findpath(maze, 0, 0))
        {
            System.out.println("path exists");
        }
        else{
            System.out.println("no path exists");
        }
    }
}