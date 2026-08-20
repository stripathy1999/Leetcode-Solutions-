class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];

            adjList.get(prereq).add(course);
            inDegree[course]++;
        }

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            result.add(currentCourse);

            for(int nextCourse : adjList.get(currentCourse)){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0){
                    queue.add(nextCourse);
                }
            }
        }
        if(result.size() != numCourses){
            return new int[0];
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}