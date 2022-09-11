package org.example.course.base.p5;

// 判断一颗二叉树是否是满二叉树
public class Code055_IsFT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isF(Node head) {
        if (head == null) {
            return true;
        }

        Info data = f(head);
        return data.nodes == (1 << data.height - 1);
    }

    public static class Info {
        public int height;
        public int nodes;

        public Info(int h, int n) {
            height = h;
            nodes = n;
        }
    }

    public static Info f(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftData = f(x.left);
        Info rightData = f(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }
}