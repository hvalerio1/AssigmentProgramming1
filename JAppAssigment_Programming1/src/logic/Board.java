
package logic;

import java.util.LinkedList;
import java.util.Stack;

/*
 * @author Estudiante
 */
public class Board {

    private int size;
    private Node aux;    
    private int node_counter;

    public Board(int size) {
        this.size = size;
        this.node_counter = 1;
        this.aux = null;
    }

    public void CreateBoard() {
        Node node = null;
        int levels = (size * 2) - 1;
        for (int i = 0; i < size; i++) { // half of the board
            
            node_counter++; // quantity of node to create
            
            for (int j = 1; j <= node_counter; j++) {
                node = new Node();
                if (aux == null) {
                    aux = node;
                } else {
                    if (j == 1) { // first node to create
                        node.setDown_right(aux);
                        aux.setUp_left(node);
                        aux = node;
                    } else if (j == node_counter) { // last node to create
                        node.setLeft(aux);
                        aux.setRight(node);
                        node.setDown_left(aux.getDown_right());
                        aux.getDown_right().setUp_right(node);
                    } else { // Middle node to create
                        aux.setRight(node);
                        node.setLeft(aux);
                        node.setDown_left(aux.getDown_right());
                        aux.getDown_right().setUp_right(node);
                        node.setDown_right(aux.getDown_right().getRight());
                        aux.getDown_right().getRight().setUp_left(node);
                        aux = node;
                    }
                }
            }
            
            while (aux.getLeft() != null) {
                aux = aux.getLeft();
            }            
        } //for (int i = 0; i < size; i++) { // half of the board
        
        for (int i = 0; i < (size-1); i++) {
            
            node_counter--; // quantity of node to create
            
            for (int j = node_counter; j > 0; j--) {
                node = new Node();
                
                if (j == node_counter) { // first node to create
                    node.setDown_left(aux);                                
                    aux.setUp_right(node);                    
                    node.setDown_right(aux.getRight());
                    aux.getRight().setUp_left(node);
                    aux = aux.getRight();                                    
                } else { // Middle node to create                    
                    node.setLeft(aux.getUp_left());
                    aux.getUp_left().setRight(node);
                    node.setDown_left(aux);
                    aux.setUp_right(node);
                    node.setDown_right(aux.getRight());
                    aux.getRight().setUp_left(node);
                }
            }
            while (aux.getLeft() != null) {                
                aux = aux.getLeft();
            }
            aux = aux.getUp_right();
        }

    }
}
