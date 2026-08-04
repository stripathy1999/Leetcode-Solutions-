class Solution {
    public int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int lastRow = heights.length;
        int lastCol = heights[0].length;

        boolean[][] visitedAtlantic = new boolean[lastRow][lastCol];
        boolean[][] visitedPacific = new boolean[lastRow][lastCol];

        //start traversing from both the top and bottom borders. Top - Pacific, Bottom - Atlantic. These are Rows, need col to traverse
        for(int col = 0; col < lastCol; col++){
            dfs(0, col, visitedPacific, heights);
            dfs(lastRow-1, col, visitedAtlantic, heights);
        }

        //start traversing from both left and right borders. Left - Pacific, Right - Atlantic. These are Columns, need rows to traverse
        for(int row = 0; row < lastRow; row++){
            dfs(row, 0, visitedPacific, heights);
            dfs(row, lastCol-1, visitedAtlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int row = 0; row<heights.length; row++){
            for(int col = 0; col<heights[0].length; col++){
                //check if from all the borders and if theres any cell which is true for both the oceans, then add it to list
                if(visitedPacific[row][col] == true && visitedAtlantic[row][col] == true){
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }
    public void dfs(int row, int col, boolean[][] visitedOcean, int[][] heights){
        if(row<0 || row>=heights.length || col<0 || col>=heights[0].length){
            return;
        }

        visitedOcean[row][col] = true;
        for(int[] direction : directions){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(nextRow<0 || nextRow >= heights.length || nextCol < 0 || nextCol >= heights[0].length){
                continue;
            }

            if(visitedOcean[nextRow][nextCol] == false && heights[nextRow][nextCol] >= heights[row][col]){
                dfs(nextRow, nextCol, visitedOcean, heights);
            }
        }
    }
}