/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        helper(0,0,0,tempList,k,n, answer);

        return answer;
    }

    public static void helper(int sum, int i, int cnt, List<Integer> temp, int k, int n, List<List<Integer>> ans)
    {
        if(k>n)
        return;

        if(sum == n && cnt == k)
        {
            ans.add(temp);
            return;
        }

        i+=1;
        if(i>9 || sum > n)
        return;
      
        List<Integer> t2 = new ArrayList<Integer>(temp);
        temp.add(i);
        helper(sum+i, i, cnt+1, temp, k, n, ans);
        helper(sum,i,  cnt, t2, k, n, ans);
       
    }
        
}
