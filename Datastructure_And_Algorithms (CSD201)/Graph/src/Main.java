/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrixAdj = {   {0, 1, 0, 0, 1, 0, 1, 0},
                                {1, 0, 1, 1, 1, 0, 0, 0},
                                {0, 1, 0, 1, 0, 1, 0, 0},
                                {0, 1, 1, 0, 0, 1, 0, 0},
                                {1, 1, 0, 1, 0, 0, 0, 0},
                                {0, 0, 1, 1, 0, 0, 1, 0},
                                {1, 0, 0, 0, 1, 1, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] weightedMatrix = {  {0, 1, 2, 0, 3, 0},
                                    {1, 0, 4, 0, 5, 0},
                                    {2, 4, 0, 6, 0, 7},
                                    {0, 0, 6, 0, 8, 9},
                                    {3, 5, 0, 8, 0, 0},
                                    {0, 0, 7, 9, 0, 0}};

        MyGraph graph = new MyGraph(matrixAdj);
        graph.displayMatrix();

        System.out.println("Breadth First Search: ");
        graph.breadthFirstSearch(3, 7);

        System.out.println("Depth First Search: ");
        graph.depthFirstSearch(0, 6);
    }
}
