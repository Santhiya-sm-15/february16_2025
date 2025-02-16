# february16_2025
The problem that i solved today in leetcode

1.Given an integer n, find a sequence that satisfies all of the following: The integer 1 occurs once in the sequence. Each integer between 2 and n occurs twice in the sequence. For every integer i between 2 and n, the distance between the two occurrences of i is exactly i. The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|. Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution. A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.

Code:
class Solution {
    public boolean f(int ind,int n,int[] res,boolean[] visited)
    {
        if(ind==res.length)
            return true;
        if(res[ind]!=0)
            return f(ind+1,n,res,visited);
        for(int i=n;i>=1;i--)
        {
            if(visited[i])
                continue;
            visited[i]=true;
            res[ind]=i;
            if(i==1)
            {
                if(f(ind+1,n,res,visited))
                    return true;
            }
            else if(ind+i<res.length && res[ind+i]==0)
            {
                res[ind+i]=i;
                if(f(ind+1,n,res,visited))
                    return true;
                res[ind+i]=0;
            }
            res[ind]=0;
            visited[i]=false;
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int[] res=new int[2*n-1];
        boolean[] visited=new boolean[n+1];
        f(0,n,res,visited);
        return res;
    }
}
