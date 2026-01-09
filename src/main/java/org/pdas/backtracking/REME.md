### What is backtracking?

**Backtracking = systematic trial + undo + try next option**

Make a choice -> Explore consequences -> Undo the choice -> Try next choice


Think of decision trees: 
              []
          /     |     \
        A       B       C
      / | \   / | \

Backtracking:

* Walks this tree depth-first
* Prunes branches early when invalid
* Never keeps junk state

To master backtracking we have to:
1. Base case
2. Recursive case
3. Stack behavior
4. Parameter vs global state

Golden Template would be:

`       public void backtrack(State state){
            if(isGoal(state)){
                record(state);
                return;
            }
            for(Choice choice: choices){
                apply(choice, state);
                backtrack(state);
                undo(choice, state);
            }
        }`

^^ This is what backtracking is

### State Representation:
Every problem boils down to - **What is my state??**


### Core Backtracking Patterns:

#### Subsets/Combination

`void backtrack(int index, List<Integer> path) {
    result.add(new ArrayList<>(path));
    for (int i = index; i < nums.length; i++) {
        path.add(nums[i]);
        backtrack(i + 1, path);
        path.remove(path.size() - 1);
    }
}`
Key idea: choose or skip

#### Permutations:
`   void backtrack(List<Integer> path) {
        if (path.size() == nums.length) {
        result.add(new ArrayList<>(path));
        return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(path);
            path.remove(path.size() - 1);
            used[i] = false;
    }
}
`
Key idea: used array

#### Permutations with Duplicates:
`if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
`
Key idea: sorting + skip duplicates

#### Grid Backtracking (DFS)
`void dfs(int r, int c) {
    if (outOfBounds || visited[r][c]) return;
    visited[r][c] = true;
    for (dir : directions) dfs(next);
    visited[r][c] = false;
}
`
Used in:
Word Search
Maze
Flood Fill

#### Constraint Satisfaction (N-Queens, Sudoku):
`if (cols.contains(col)) continue;
if (diag1.contains(row - col)) continue;
if (diag2.contains(row + col)) continue;`


#### Expression / Partition Backtracking:
**Used in:**
1. Palindrome partitioning
2. Expression add operators

`for (int i = start; i < s.length(); i++) {
    if (isValid(s.substring(start, i + 1))) {
        path.add(...);
        backtrack(i + 1);
        path.remove(path.size() - 1);
    }
}
`