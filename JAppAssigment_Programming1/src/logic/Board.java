/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Estudiante
 */
public class Board {

    private int size;
    private Node aux;
    private Node aux1;
    private int node_counter;

    public Board(int size) {
        this.size = size;
        this.node_counter = 1;
        this.aux = null;
    }

    public void CreateBoard() {
        Node node = null;
        int levels = (size * 2) - 1;
        for (int i = 0; i < levels; i++) {

            for (int j = 1; j <= node_counter; j++) {

                node = new Node();
                if (aux == null) {
                    aux = node;
                } else {
                    //Caso del primer nodo
                    if (j == 1) {
                        node.setDown_right(aux);
                        aux.setUp_left(node);
                        aux = node;
                        //Caso del ultimo nodo
                    } else if (j == node_counter) {
                        node.setLeft(aux);
                        aux.setRight(node);
                        node.setDown_left(aux.getDown_right());
                        aux.getDown_right().setUp_right(node);
                        //Caso del ultimo nodo
                    } else {
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
            node_counter++;

        }

    }
}
