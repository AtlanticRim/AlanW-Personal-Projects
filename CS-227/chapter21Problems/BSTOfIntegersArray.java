package chapter21Problems;

public class BSTOfIntegersArray {
    protected Integer[] array;
    
    public BSTOfIntegersArray() {
        array  = new Integer[1];
    }
    
    void increaseSize() {
        Integer[] newArray = new Integer[(array.length*2)+1];
        array = newArray;
    }
    
    
    
}
