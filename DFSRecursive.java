import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class DFSRecursive {

    public static boolean dfs (Node source, Node sink) {
        return dfs_rec (source, sink);
    }

    static boolean dfs_rec (Node current, Node sink) {
        current.setVisited(true);
        if (current.getLabel().equals(sink.getLabel())) {
            return true;
        }
        System.out.print(current.getLabel() + " ");
        // System.out.println(current.neighborsToString());
        for (Node nextNode : current.getNeighbors() ) {
            if (!nextNode.getVisited()) {
                boolean nodeSearch = dfs_rec (nextNode, sink);
                if (nodeSearch)
                    return nodeSearch;
            }
        }
        return false;
    }

    public static ArrayList<ArrayList<Node>> dfsAllPaths (Node source, Node sink) {
        ArrayList<ArrayList<Node>> listOfPaths = new ArrayList<ArrayList<Node>>();
        Stack<Node> path = new Stack<Node>();

        dfsAllPaths_rec (source, sink, listOfPaths, path);

        return listOfPaths;
    }

    private static void dfsAllPaths_rec (Node current, Node sink, ArrayList<ArrayList<Node>> paths, Stack<Node> path) {
        path.push(current);
        current.setVisited(true);

        // System.out.println (path.peek().getLabel());
        // System.out.println (sink.getLabel());

        if (current.getLabel().equals(sink.getLabel())) {
            processPath(paths, path);
        } else {
            for (Node node : current.getNeighbors()) {
                if (!node.getVisited()) {
                    dfsAllPaths_rec(node, sink, paths, path);
                }
            }
        }

        current.setVisited(false);
        path.pop();
    }

    private static void processPath(ArrayList<ArrayList<Node>> paths, Stack<Node> path) {
        ArrayList<Node> newPath = new ArrayList<Node>();
        Stack<Node> pathCopy = new Stack<Node>();
        pathCopy.addAll(path);
        while (!pathCopy.empty()) {
            newPath.add(pathCopy.pop());
        }
        Collections.reverse(newPath);
        paths.add(newPath);
    }

}