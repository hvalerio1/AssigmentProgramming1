/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Estudiante
 */
public class Node {
    private Node up_left;
    private Node up_right;
    private Node left;
    private Node right;
    private Node down_left;
    private Node down_right;
    
    private boolean active;
    private int color; // 1 naranja , 2 azul

    public Node() {
        this.active = false;
        this.color = 0;
    }

    public Node getUp_left() {
        return up_left;
    }

    public void setUp_left(Node up_left) {
        this.up_left = up_left;
    }

    public Node getUp_right() {
        return up_right;
    }

    public void setUp_right(Node up_right) {
        this.up_right = up_right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getDown_left() {
        return down_left;
    }

    public void setDown_left(Node down_left) {
        this.down_left = down_left;
    }

    public Node getDown_right() {
        return down_right;
    }

    public void setDown_right(Node down_right) {
        this.down_right = down_right;
    }
    
    


    
}
