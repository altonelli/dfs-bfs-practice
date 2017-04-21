
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

}