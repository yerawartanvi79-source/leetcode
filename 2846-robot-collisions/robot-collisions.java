import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // Step 1: store all info together
        int[][] robots = new int[n][4]; 
        // {position, health, direction(0=L,1=R), original index}

        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i) == 'R' ? 1 : 0;
            robots[i][3] = i;
        }

        // Step 2: sort by position
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);

        Stack<Integer> stack = new Stack<>();

        // Step 3: process robots
        for (int i = 0; i < n; i++) {

            // If moving right → push index
            if (robots[i][2] == 1) {
                stack.push(i);
            } 
            else { // moving left

                while (!stack.isEmpty() && robots[i][1] > 0) {
                    int top = stack.peek();

                    // If right-moving robot exists
                    if (robots[top][2] == 1) {

                        if (robots[top][1] < robots[i][1]) {
                            // right robot dies
                            stack.pop();
                            robots[i][1]--; 
                            robots[top][1] = 0;

                        } else if (robots[top][1] > robots[i][1]) {
                            // left robot dies
                            robots[top][1]--;
                            robots[i][1] = 0;

                        } else {
                            // both die
                            stack.pop();
                            robots[top][1] = 0;
                            robots[i][1] = 0;
                        }

                    } else {
                        break;
                    }
                }
            }
        }

        // Step 4: collect survivors
        List<int[]> survivors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (robots[i][1] > 0) {
                survivors.add(new int[]{robots[i][3], robots[i][1]});
            }
        }

        // Step 5: sort by original index
        Collections.sort(survivors, (a, b) -> a[0] - b[0]);

        // Step 6: extract answer
        List<Integer> result = new ArrayList<>();
        for (int[] s : survivors) {
            result.add(s[1]);
        }

        return result;
    }
}