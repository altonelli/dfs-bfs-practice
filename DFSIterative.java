import java.util.Stack;

public class DFSIterative {

    public static boolean dfs (Node source, Node sink) {

        Stack<Node> st = new Stack<Node>();
        st.push(source);
        while (!st.isEmpty()) {

            Node current = (Node)st.pop();

            if (!current.getVisited()){
              current.setVisited(true);

              if (current.getLabel().equals(sink.getLabel()))
                  return true;

              System.out.print(current.getLabel() + " ");
              for (int i = current.getNeighbors().size() - 1; i >= 0; i--) {
                Node nextNode = (Node)current.getNeighbors().get(i);
                if (!nextNode.getVisited()) {
                  st.push(nextNode);
                }
              }
            }

        }
        return false;
    }

}