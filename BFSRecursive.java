import java.util.LinkedList;
import java.util.Queue;

public class BFSRecursive {

  public static boolean bfs (Node source, Node sink) {

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(source);
    return bfs_rec (queue, sink);
  }

  public static boolean bfs_rec (Queue<Node> queue, Node sink) {
    if (queue.isEmpty())
      return false;

    Node current = queue.poll();
    if (!current.getVisited()) {

      if (current.getLabel().equals(sink.getLabel()))
          return true;
        System.out.print(current.getLabel() + " ");

        current.setVisited(true);
        for (Node node : current.getNeighbors()) {
            if(!node.getVisited())
                queue.add(node);
          }
    }

    return bfs_rec (queue, sink);
  }

}