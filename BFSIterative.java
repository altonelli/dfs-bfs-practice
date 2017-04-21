import java.util.LinkedList;
import java.util.Queue;

public class BFSIterative {

    public static boolean bfs (Node source, Node sink) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Node current = (Node)queue.poll();
            if(!current.getVisited()) {
                current.setVisited(true);

                if (current.getLabel().equals(sink.getLabel()))
                    return true;

                System.out.print(current.getLabel() + " ");
                for (Node node : current.getNeighbors()) {
                    if(!node.getVisited()) {
                        queue.add(node);
                    }
                }
            }
        }

        return false;
    }

}