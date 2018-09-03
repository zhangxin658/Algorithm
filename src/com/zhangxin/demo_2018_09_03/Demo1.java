/**
 * 给定一个N叉树，返回其节点值的前序遍历。
 */

package com.zhangxin.demo_2018_09_03;

import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Demo1 {
    public static void main(String[] args){
        Demo1 demo = new Demo1();
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        List<Node> val2 = new LinkedList<>();
        val2.add(node5);
        val2.add(node6);
        Node node3 = new Node(3, val2);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        List<Node> val1 = new LinkedList<>();
        val1.add(node3);
        val1.add(node2);
        val1.add(node4);
        Node node1 = new Node(1, val1);
        List<Integer> val = demo.preorder(node1);
        for (int i : val){
            System.out.println(i);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> val = new LinkedList<>();
        return helper(root, val);
    }
    public List<Integer> helper(Node root, List<Integer> val){
        if (root == null){
            return val;
        }
        val.add(root.val);
        if (root.children != null) {
            for (Node val1 : root.children) {
                helper(val1, val);
            }
        }
        return val;
    }
}


