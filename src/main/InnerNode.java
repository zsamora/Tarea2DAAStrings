package main;

import java.util.HashMap;

public class InnerNode implements Node {
    // Aristas que referencian a un Nodo (interno o hoja)
    HashMap<String, Node> edges = new HashMap<String, Node>();

    @Override
    public void addSuffix(int index, String subtext) {
        if (!edges.containsKey(subtext)) {
            int tsize = subtext.length();
            if (tsize == 1) {
                edges.put(subtext, new Leaf(index));
                edges.remove("subtext");
//                new Innernode ();
            }
//            addSuffix(index,);
        }
    }
    public void printEdges(){
        for (String s : edges.keySet()) {
            Node n = edges.get(s);
            System.out.println(s + ":" + String.valueOf(n.getValue()));
        }
    }

    @Override
    public int getValue() {
        return 0;
    }
}
