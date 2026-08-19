class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we basically have to detect cycle in the prereq -> course directed graph

        boolean[] inCurrentPath = new boolean[numCourses];//to keep a check that the current course is in the current dfs stack, or call stack path. 
        boolean[] visited = new boolean[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];
            adjList.get(prereq).add(course);
        }

        for(int course = 0; course < numCourses; course++){
            if(visited[course] == false){
                if(dfs(course, inCurrentPath, visited, adjList) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int course, boolean[] inCurrentPath, boolean[] visited, List<List<Integer>> adjList){

        if(inCurrentPath[course] == true){ //found a cycle because we found a course in the same path
            return false;
        }

        if(visited[course] == true){
            return true;
        }

        inCurrentPath[course] = true;
        
        for(int preReq : adjList.get(course)){
            if(visited[preReq] == false){
                if(dfs(preReq, inCurrentPath, visited, adjList) == false){
                    return false;
                }
            }
        }

        inCurrentPath[course] = false;
        visited[course] = true;

        return true;
    }
}