import java.util.*;

class findbridges {

    int V;
    ArrayList<ArrayList<Integer>>adj;
    int time=0;
    int NIL=-1;
    findbridges(int V){
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
    void bridge(){
        int low[]=new int[V];
        int disc[]=new int[V];
        int parent[]=new int[V];
        boolean visited[]=new boolean[V];
        Arrays.fill(parent,NIL);
        for(int i=0;i<V;i++){
            if(!visited[i]){
                bridgedfs(i,disc,visited,parent,low);
            }
        }
    }
    void bridgedfs(int u,int[] disc,boolean[] visited,int[]parent,int[]low){
        visited[u]=true;
        disc[u]=low[u]=++time;
        for(int v:adj.get(u)){
            if(!visited[v]){
                parent[v]=u;
                bridgedfs(v, disc, visited, parent, low);
                low[u]=Math.min(low[u],low[v]);

                if(low[v]>disc[u]){
                    System.out.println(u+" "+v);
                }
            }
            else if(v!=parent[u]){
                low[u]=Math.min(low[u],low[v]);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        findbridges f=new findbridges(v);

        for(int i=0;i<e;i++){
            f.addEdge(sc.nextInt(),sc.nextInt());
        }
        f.bridge();

    }
}
