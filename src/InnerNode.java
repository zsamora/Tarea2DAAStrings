import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class InnerNode implements Node {
    // Diccionario de aristas que referencian a un Nodo (interno o hoja)
    HashMap<String, Node> children = new HashMap<String, Node>();

    @Override
    public void addSuffix(int index, String subtext) {
        if (!subtext.equals("")) {
            addSuffixRec(index, subtext, "");
        }
    }
    @Override
    public void addSuffixRec(int index, String subtext, String rest) {
        int tsize = subtext.length(); // Largo del subtexto
        // Si el sufijo exacto existe en el diccionario
        if (children.containsKey(subtext)) {
            Node childmatch = children.get(subtext);
            // Si el resto es vacio
            if (rest.equals(""))
                childmatch.addValue(index); // Obtiene el nodo y agrega el nuevo indice
            else
                childmatch.addSuffix(index, rest);
            System.out.println(children.get(subtext).getValues());
        }
        // Si no existe
        else {
            boolean found = false;
            // Si alguna arista contiene el sufijo en su texto
            for (String ckey : children.keySet()) {
                boolean empieza = ckey.startsWith(subtext);
                if (ckey.startsWith(subtext)) {
                    found = true;
                    Node oldnode = children.get(ckey);
                    children.remove(ckey);
                    String restedge = ckey.substring(tsize);
                    InnerNode newnode = new InnerNode();
                    newnode.children.put(restedge, oldnode);
                    newnode.addSuffix(index, rest);
                    children.put(subtext, newnode);
                    break;
                }
            }
            if (!found) {
                // Solamente un caracter
                if (tsize == 1)
                    children.put(subtext+rest, new Leaf(index));
                else {
                    String newsubtext = subtext.substring(0, tsize-1); // Se quita el ultimo caracter
                    String newrest = subtext.substring(tsize-1) + rest; // Nuevo caracter quitado mas el resto
                    if (!newsubtext.equals("")) {
                        addSuffixRec(index, newsubtext, newrest);
                    }
                }
            }
        }
    }
    @Override
    public ArrayList<Integer> getValues() {
        return new ArrayList<Integer>(-1);
    }
    @Override
    public void addValue(int newindex) {

    }
    @Override
    public void printEdges(boolean breakline){
        for (String s : children.keySet()) {
            Node n = children.get(s);
            if (breakline) {
                System.out.print(s + " => {");
                n.printEdges(false);
                System.out.println("}");
            }
            else {
                System.out.print(s + " => {");
                n.printEdges(false);
                System.out.print("} ");
            }
        }
    }
}
