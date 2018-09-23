/**
 * Bag provides abstract methods for managing bag of generics
 * @author Graham Thompson
 * @version 
 */
public interface Bag <T>{
    
    /**
     * Returns the count of elements in the bag
     * @return 
     */
    public abstract int getCurrentSize();
    
    /**
     * Checks if the bag is empty,
     * returns true if empty
     * @return 
     */
    public abstract boolean isEmpty();
    
    /**
     * adds num to the bag
     * @param num 
     */
    public abstract void add(T num);
    
    /**
     * removes the first occurrence of num
     * from the bag
     * @param num 
     * @return  
     */
    public abstract boolean remove(T num);

    /**
     * removes a randomly selected selected entry 
     * from the bag
     * @return 
     */
    public abstract T remove();
    
    /**
     * removes all the elements from the bag
     */
    public abstract void clear();
    
    /**
     * returns a count of the number of times
     * num exists in the bag
     * @param num
     * @return 
     */
    public abstract int getFrequency(T num);
    
    /**
     * Tests whether the bag contains num.
     * Returns true when nm is contained in the bag
     * @param num
     * @return 
     */
    public abstract boolean contains(T num);
    
    /**
     * returns a String of the contents of the bag
     * @return 
     */
    @Override
    public abstract String toString();
    
    /**
     * returns true if the parameter o exactly matches
     * the contents of the bag.  Same numbers in the same order
     * @param o
     * @return 
     */
    @Override
    public abstract boolean equals(Object o);
}
