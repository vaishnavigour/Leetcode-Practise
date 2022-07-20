class Solution {
public:
    
    bool find(int i, vector<int> adj[],vector<int>& vis, vector<int> &res){
        vis[i]=1;
        res[i]=1;
        
        for(int curr: adj[i]){
            if(vis[curr]==0){
                if(find(curr,adj,vis,res)){
                    return true;
                }
            }
            else{
                if(res[curr]==1){
                    return true;
                }
            }
        }
        res[i]=0;
        return false;
    }
    
    bool canFinish(int num, vector<vector<int>>& pre) {
        vector<int> adj[num];
        int m = pre.size();
        for(int i=0 ; i<m;i++){
            int u = pre[i][0];
            int v = pre[i][1];
            adj[v].push_back(u);
        }
        
        vector<int> vis(num,0);
        vector<int> res(num,0);
        for(int i=0 ; i<num; i++){
            if(vis[i]==0){
                if(find(i,adj,vis,res)){
                    return false;
                }
            }
        }
        return true;
    }
};