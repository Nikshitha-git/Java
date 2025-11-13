import java.util.*;
class Compo{
    int V;
    ArrayList<ArrayList<Integer>>adj;
    int count=0;
    Compo(int V){
        this.V=V;
        adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int src,int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
    void findcomp(){
        boolean[]vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis);
                count++;
            }
        }
    }
    void dfs(int x,boolean[]vis){
        vis[x]=true;
        
        for(int v:adj.get(x)){
            if(!vis[v]){
                dfs(v, vis);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Compo g = new Compo(v);
        for(int i=0;i<e;i++){
            g.addEdge(sc.nextInt(),sc.nextInt());
        }
        g.findcomp();
        System.out.println(g.count);
    }
}