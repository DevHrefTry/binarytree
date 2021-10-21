package com.company;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree{

    //kořen a nastavení dočasného oběktu Node jako klon kořenu
    public static Node root;
    public static Node temp = root;

    //rekurzivni vypsani stromu...
    static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    static Car deleteDeepest(Node root,
                              Node delNode)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Car car = new Car("");
        Node temp = null;

        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp == delNode)
            {
                car = temp.car;
                temp = null;
                return car;

            }
            if (temp.right!=null)
            {
                if (temp.right == delNode)
                {
                    car = temp.car;
                    temp.right = null;
                    return car;
                }
                else
                    q.add(temp.right);
            }

            if (temp.left != null)
            {
                if (temp.left == delNode)
                {
                    car = temp.car;
                    temp.left = null;
                    return car;
                }
                else
                    q.add(temp.left);
            }
        }
        return car;
    }

    static Car delete(Node root, String key)
    {
        Car car = new Car("");
        if (root == null)
            return car;

        if (root.left == null &&
                root.right == null)
        {
            if (root.key.compareTo(key) > 0 )
            {
                car = root.car;
                root=null;
                return car;
            }
            else
                return car;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;

        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp.key == key)
                keyNode = temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (keyNode != null)
        {
            String x = temp.key;
            car = deleteDeepest(root, temp);
            keyNode.key = x;
        }
        return car;
    }
    public static void insert(Node temp, String key, Car car)
    {

        if (temp == null) {
            root = new Node(key, car);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key, car);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key, car);
                break;
            }
            else
                q.add(temp.right);
        }
    }
}

