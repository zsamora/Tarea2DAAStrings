package main;

import java.util.ArrayList;
import java.util.HashMap;

public class InnerNode implements Node {
    // Diccionario de aristas que referencian a un Nodo (interno o hoja)
    HashMap<String, Node> children = new HashMap<>();

    @Override
    public void addSuffix(Integer index, String subtext) {
        if (!subtext.equals(""))
            addSuffixRec(index, subtext, "");
    }
    @Override
    public void addSuffixRec(Integer index, String subtext, String rest) {
        while (!subtext.equals("")) {
            int tsize = subtext.length(); // Largo del subtexto
            // Si el sufijo exacto existe en el diccionario
            if (children.containsKey(subtext)) {
                Node childmatch = children.get(subtext);
                // Si el resto es vacio
                if (rest.equals("")) {
                    childmatch.addValue(index); // Agrega el nuevo indice
                    break;
                }
                else {
                    childmatch.addSuffix(index, rest);
                    break;
                }
                //System.out.println(children.get(subtext).getValues());
            }
            // Si no existe
            else {
                boolean found = false;
                // Si alguna arista contiene el sufijo en su texto
                for (String ckey : children.keySet()) {
                    if (ckey.startsWith(subtext)) {
                        found = true;
                        Node oldnode = children.get(ckey);
                        children.remove(ckey);
                        String restedge = ckey.substring(tsize);
                        InnerNode newnode = new InnerNode();
                        newnode.children.put(restedge, oldnode);
                        newnode.children.put(rest, new Leaf(index));
                        children.put(subtext, newnode);
                        break;
                    }
                }
                // Si se encontro un hijo que contenia el subtexto y se agrego
                if (found)
                    break;
                else {
                    // Solamente un caracter
                    if (tsize == 1) {
                        children.put(subtext+rest, new Leaf(index));
                        break;
                    }
                    else {
                        subtext = subtext.substring(0, tsize-1); // Se quita el ultimo caracter
                        rest = subtext.substring(tsize-1) + rest; // Nuevo caracter quitado mas el resto
                        //addSuffixRec(index, newsubtext, newrest);
                    }
                }
            }
        }
    }
    /*@Override
    public int countRec(String pattern) {
        for (int i = 1; i <= pattern.length(); i++ ) {
            String subpattern = pattern.substring(0,i);
            String restpattern = "";
            if (i < pattern.length())
                restpattern = pattern.substring(i);
            for (String ckey : children.keySet()) {
                // Si el subpatron se encuentra exactamente en alguna arista
                if (ckey.equals(subpattern)) {
                    Node n = children.get(ckey);
                    // Si el patron calzo completo, retornar la cantidad de indices
                    if (restpattern.equals("")) {
                        return n.getNValues();
                    }
                    else {
                        return n.countRec(restpattern);
                    }
                }
            }
        }
        return 0;
    }*/
    @Override
    public ArrayList<Integer> locate(String pattern) {
        for (int i = 1; i <= pattern.length(); i++ ) {
            String subpattern = pattern.substring(0,i);
            String restpattern = "";
            if (i < pattern.length())
                restpattern = pattern.substring(i);
            for (String ckey : children.keySet()) {
                // Si el subpatron se encuentra exactamente en alguna arista
                if (ckey.equals(subpattern)) {
                    Node n = children.get(ckey);
                    // Si el patron calzo completo, retornar la cantidad de indices
                    if (restpattern.equals("")) {
                        return n.getValues();
                    }
                    else {
                        return n.locate(restpattern);
                    }
                }
            }
        }
        return null;
    }
    @Override
    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();
        for (String ckey : children.keySet()) {
            Node n = children.get(ckey);
            result.addAll(n.getValues());
        }
        return result;
    }
    @Override
    public int getNValues() {
        int result = 0;
        for (String s : children.keySet()) {
            Node n = children.get(s);
            result += n.getNValues();
        }
        return result;
    }
    @Override
    public void addValue(Integer newindex) {}

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

    @Override
    public int getSize(){
        int size = 0;
        for (String s : children.keySet()) {
            size += s.length();
            size += children.get(s).getSize();
        }

        return size;
    }
}
