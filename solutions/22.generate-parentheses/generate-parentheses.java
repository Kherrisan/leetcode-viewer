class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new LinkedList();
        if(n==0){
            return res;
        }
        dfs(res,n,n,"");
        return res;
    }

    void dfs(List<String> res,int left,int right,String s){
        if(left==0&&right==0){
            res.add(s);
            return;
        }
        if(left>right){
            //如果使用的右括号数大于左括号数，剪枝
            return;
        }
        if(left>0){
            dfs(res,left-1,right,s+"(");
        }
        if(right>0){
            dfs(res,left,right-1,s+")");
        }
    }
}