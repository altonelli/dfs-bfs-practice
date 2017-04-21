import java.util.ArrayList;

public class Node {
    private String label;
    private ArrayList<Node> neighbors;
    private boolean visited;

    public Node (String label) throws IllegalArgumentException {
        if (label == null)
            throw new IllegalArgumentException("label must be entered");
        this.label = label;
        this.neighbors = new ArrayList<Node>();
        this.visited = false;
    }

    public String getLabel () {
        return this.label;
    }

    public ArrayList<Node> getNeighbors () {
        return this.neighbors;
    }

    public boolean addNeighbor (Node node) {
        if (this.neighbors.contains(node) || node == null) {
            return false;
        }
        this.neighbors.add(node);
        return true;
    }

    public void addNeighbors(Node[] nodes) {
        for (Node node : nodes) {
            this.addNeighbor(node);
        }
    }

    public void setVisited (boolean visited) {
        this.visited = visited;
    }

    public boolean getVisited () {
        return this.visited;
    }

    public String neighborsToString() {
        String str = "[";
        int size = this.neighbors.size();
        for (int i = 0; i < size; i++) {
            str = str + this.neighbors.get(i).getLabel();
            if (i < size - 1) {
                str = str + ", ";
            }
        }
        return str + "]";
    }

}