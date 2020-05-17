class Solution {
   public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }

        res = new int[numCourses];
        index = numCourses - 1;
        visited = new int[numCourses];

        for (int i = 0; i < edges.size(); i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (invalid) {
            return new int[0];
        }
        return res;
    }


    List<List<Integer>> edges;
    int[] visited;
    boolean invalid = false;
    int[] res;
    int index;

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (invalid) {
                    return;
                }
            } else if (visited[v] == 1) {
                invalid = true;
            }
        }

        visited[u] = 2;
        res[index--] = u;
    }
}
