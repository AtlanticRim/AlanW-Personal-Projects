package chapter21Problems;

public class BSTOfIntegersNodes {
    TreeNode<Integer> root;
    
    
} // end BSTOfIntegersNodes class

class TreeNode<E>{
    E data;
    TreeNode<E> l;
    TreeNode<E> r;
    
    TreeNode(){
        
    }// no-arg constructor
    
    TreeNode(E e){
        this.data = e;
    }
}// end Node class