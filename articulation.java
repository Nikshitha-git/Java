import java.util.*;
class art{
    ArrayList<ArrayList<Integer>>graph;
    int V;
    int time=0;
    art(int v){
        this.V=v;
        graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
    } 
    void AddEdge(int u,int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    void dfs(int u,int[]disc,int[]low,boolean[]visited,int parent,boolean[] isAp){
        visited[u]=true;
        disc[u]=low[u]=++time;
        int child=0;
        for(int v:graph.get(u)){
            if(!visited[v]){
                child++;
                dfs(v, disc, low, visited, u, isAp);
                low[u]=Math.min(low[u],low[v]);

                if(parent!=-1 && low[v]>=disc[u]){
                    isAp[u]=true;
                }
                else if(v!=parent){
                    low[u]=Math.min(low[u],disc[v]);
                }
            }
        }
        if(parent==-1 && child>1){
                isAp[u]=true;
            }
    }
    void arti(){
        int[]disc=new int[V];
        int[]low=new int[V];
        boolean[]visited=new boolean[V];
        boolean[]isAp=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,disc,low,visited,-1,isAp);
            }
        }
        int count=0;
        for(int i=0;i<V;i++){
            if(isAp[i]){
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println("articulation points : "+count);
    }
}
public class articulation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        art a=new art(v);
        for(int i=0;i<e;i++){
            a.AddEdge(sc.nextInt(), sc.nextInt());
        }
        a.arti();   
    }
    
}
