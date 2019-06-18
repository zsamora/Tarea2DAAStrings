import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class InnerNode implements Node {
    // Diccionario de aristas que referencian a un Nodo (interno o hoja)
    HashMap<String, Node> children = new HashMap<>();

    @Override
    public void addSuffix(long index, String subtext) {
        if (!subtext.equals(""))
            addSuffixRec(index, subtext, "");
    }
    @Override
    public void addSuffixRec(long index, String subtext, String rest) {
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
    public int countRec(InnerNode node, String pattern) {
        for (int i = 1; i <= pattern.length(); i++ ) {
            String subpattern = pattern.substring(0,i);
            String restpattern = "";
            if (i < pattern.length())
                restpattern = pattern.substring(i);
            for (String ckey : node.children.keySet()) {
                // Si el subpatron se encuentra exactamente en alguna arista
                if (ckey.equals(subpattern)) {
                    Node n = node.children.get(ckey);
                    // Si el patron calzo completo, retornar la cantidad de indices
                    if (restpattern.equals("")) {
                        return n.getNValues();
                    }
                    else {
                        return countRec((InnerNode) n, restpattern);
                    }
                }
            }
        }
        return 0;
    }
    @Override
    public ArrayList<Long> getValues() {
        return null;
    }
    @Override
    public int getNValues() {
        return children.size();
    }
    @Override
    public void addValue(long newindex) {}
    @Override
    public void printEdges(boolean breakline){
        for (String s : children.keySet()) {
            Node n = children.get(s);
            if (breakline) {
                System.out.print("  °===> " + s + " => {");
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
