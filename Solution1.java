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