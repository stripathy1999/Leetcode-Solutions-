class Solution {
    public int numDistinctIslands2(int[][] grid) {
        HashSet<String> islandSet = new HashSet<>();
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col] == 1){
                    List<int[]> islandCellCoordinates = new ArrayList<>();
                    dfs(row, col, grid, islandCellCoordinates);
                    String shape = getIslandShape(islandCellCoordinates);
                    islandSet.add(shape);
                }
            }
        }
        return islandSet.size();
    }
    public void dfs(int row, int col, int[][] grid, List<int[]> islandCellCoordinates){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;
        islandCellCoordinates.add(new int[]{row, col});

        dfs(row+1, col, grid, islandCellCoordinates);
        dfs(row-1, col, grid, islandCellCoordinates);
        dfs(row, col+1, grid, islandCellCoordinates);
        dfs(row, col-1, grid, islandCellCoordinates);
    }
    public String getIslandShape(List<int[]> islandCellCoordinates){
        List<List<int[]>> transformedIslands = new ArrayList<>();
        for(int i=0; i<8; i++){
            transformedIslands.add(new ArrayList<>());
        }

        for(int[] cell : islandCellCoordinates){
            int x = cell[0];
            int y = cell[1];

            transformedIslands.get(0).add(new int[]{x,y});
            transformedIslands.get(1).add(new int[]{-x,y});
            transformedIslands.get(2).add(new int[]{x,-y});
            transformedIslands.get(3).add(new int[]{-x,-y});
            transformedIslands.get(4).add(new int[]{y,x});
            transformedIslands.get(5).add(new int[]{-y,x});
            transformedIslands.get(6).add(new int[]{-y,-x});
            transformedIslands.get(7).add(new int[]{y,-x});
        }

        List<String> shapePatterns = new ArrayList<>();

        for(List<int[]> transformedIsland : transformedIslands){
            transformedIsland.sort((a,b) -> {
                if(a[0] != b[0]){
                    return a[0] - b[0];
                }
                else{
                    return a[1] - b[1];
                }
            });

            int baseRow = transformedIsland.get(0)[0];
            int baseCol = transformedIsland.get(0)[1];

            StringBuilder shape = new StringBuilder();
            for(int[] point : transformedIsland){
                int rowDiff = baseRow - point[0];
                int colDiff = baseCol - point[1];
                shape.append("(").append(rowDiff).append(",").append(colDiff).append(")");
            }

            shapePatterns.add(shape.toString());
        }
        Collections.sort(shapePatterns);

        return shapePatterns.get(0);
    }
}