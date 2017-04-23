import java.util.ArrayList;

public class Search {
    private static ArrayList<Node> graph = new ArrayList<Node>();

    private static void resetNodes() {
        for (Node node : graph) {
            node.setVisited(false);
        }
    }

    private static void printPathList (ArrayList<ArrayList<Node>> paths) {
        for (ArrayList<Node> path : paths) {
            for (Node node : path) {
                System.out.print(node.getLabel());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node node0 = new Node("0");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");

        Node node6 = new Node("6");

        node0.addNeighbors(new Node[]{node1, node5});
        node1.addNeighbors(new Node[]{node0, node2, node5});
        node2.addNeighbors(new Node[]{node1, node3, node4});
        node3.addNeighbors(new Node[]{node2, node4});
        node4.addNeighbors(new Node[]{node2, node3, node5});
        node5.addNeighbors(new Node[]{node0, node1, node4});

        graph.add(node0);
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);
        graph.add(node6);


/*

  This is a visual depiction of the graph

            (1) -- (2)
           / |      | \
        (0)  |      |  (3)
           \ |      | /
            (5) -- (4)

                      (6)

*/

        // Compare DFS Success
        boolean DFSRecursiveSuccess = DFSRecursive.dfs(node0, node4);
        System.out.println(DFSRecursiveSuccess);
        resetNodes();

        boolean DFSIterativeSuccess = DFSIterative.dfs(node0, node4);
        System.out.println(DFSIterativeSuccess);
        resetNodes();

        // Compare BFS Success
        boolean BFSRecursiveSuccess = BFSRecursive.bfs(node0, node4);
        System.out.println(BFSRecursiveSuccess);
        resetNodes();

        boolean BFSIterativeSuccess = BFSIterative.bfs(node0, node4);
        System.out.println(BFSIterativeSuccess);
        resetNodes();

        // Compare DFS Failure
        boolean DFSRecursiveFailure = DFSRecursive.dfs(node0, node6);
        System.out.println(DFSRecursiveFailure);
        resetNodes();

        boolean DFSIterativeFailure = DFSIterative.dfs(node0, node6);
        System.out.println(DFSIterativeFailure);
        resetNodes();

        // Compare BFS Failure
        boolean BFSRecursiveFailure = BFSRecursive.bfs(node0, node6);
        System.out.println(BFSRecursiveFailure);
        resetNodes();

        boolean BFSIterativeFailure = BFSIterative.bfs(node0, node6);
        System.out.println(BFSIterativeFailure);
        resetNodes();

        ArrayList<ArrayList<Node>> paths = DFSRecursive.dfsAllPaths(node0, node4);
        printPathList(paths);
        resetNodes();
    }
}