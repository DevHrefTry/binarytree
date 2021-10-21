package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree bin = new BinaryTree();
        Car car1 = new Car("Tesla");
        /*
        bin.root = new Node("AAA", car1);
        bin.root.left = new Node("AAB" , car1);
        bin.root.left.left = new Node("AAC" , car1);
        bin.root.left.right = new Node("AAD" , car1);
        bin.root.right = new Node("AAE" , car1);
        bin.root.right.left = new Node("AAF" , car1);
        bin.root.right.right = new Node("AAG" , car1);
        */
        bin.insert(bin.root, "AAA", car1);
        bin.insert(bin.root, "AAB", car1);
        bin.insert(bin.root, "AAC", car1);
        bin.insert(bin.root, "AAD", car1);
        bin.insert(bin.root, "AAE", car1);
        System.out.print("Inorder traversal " +
                "before deletion:");
        bin.inorder(bin.root);

        String key = "AAC";
        Car deletedCar = bin.delete(bin.root, key);

        System.out.print("\nDeleted car: " +deletedCar.name +" SPZ: " + key);

        System.out.print("\nInorder traversal " +
                "after deletion:");
        bin.inorder(bin.root);
    }
}
