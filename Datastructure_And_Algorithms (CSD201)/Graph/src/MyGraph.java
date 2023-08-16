/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
public class MyGraph {
    
    public int [][] matrix;
    public boolean[] visited;
    public final int infinite = 999;
    public char[] vertices = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public MyGraph(int [][] matrix) {
        this.matrix = matrix;
    }

    public void displayMatrix(){
        int size = matrix.length;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Breadth First Search with Adjacency Matrix
    public void breadthFirstSearch(int startVertice, int numOfVertices){//startVertice start from 0
        MyQueue queue = new MyQueue();  //This queue is used to store the vertices that are visited
        visited = new boolean[numOfVertices]; //This array is used to check if a vertice is visited or not
        String result = "";
        queue.enqueue(startVertice);
        visited[startVertice] = true;
        //Each time print a vertice and enqueue all its adjacent vertices
        while(!queue.isEmpty()){
            int currV = queue.dequeue();
            result += vertices[currV] + "->";
            //Loop used to enqueue all adjacent vertices of v
            for(int i = 0; i < numOfVertices; i++){
                //Check if there is an edge between current vertice and i and if vertice i is not visited
                //Then enqueue vertice i and set it to visited
                if(matrix[currV][i] == 1 && !visited[i]){
                    queue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println(result.substring(0, result.length()-2));
    }

    
    public void depthFirstSearch(int startVertice, int numOfVertices){
        
    }

}
