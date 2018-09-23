
import java.util.Random;

/**
 *
 * @author Graham Thompson
 * @version
 */
public class ArrayBag <T> implements Bag<T>{

    public T[] list;
    private int count;
    
    
    public ArrayBag(){
        this.list = (T[]) new Object[50];
        this.count = 0;
    }
    
    public ArrayBag(int length){
        this.list = (T[]) new Object[length];
        this.count=0;
    }
    /**
     * Returns the count of elements in the bag
     * @return 
     */
    @Override
    public int getCurrentSize() {
        return this.count;
    }
    
    public int[] getIntArray(){
        int[] sample = new int[this.count];
        for(int i = 0; i<this.count; i++){
            sample[i] = (Integer) list[i];
        }
        return sample;
    }
    /**
     * Checks if the bag is empty,
     * returns true if empty
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return this.count==0;
    }

    /**
     * adds num to the bag
     * @param num 
     */
    @Override
    public void add(T num) {
        if(this.count == this.list.length){
            T[] temp = (T[]) new Object[this.list.length*2];
            for(int i = 0; i < this.list.length; i++){
                temp[i] = this.list[i];
            }
            temp[this.count++] = num;
            this.list = temp;
        }
        
        else{
            this.list[this.count++] = num;
        }
        
    }

    /**
     * removes the first occurrence of num
     * from the bag
     * @param num 
     * @return  
     */
    @Override
    public boolean remove(T num) {
        int i = 0;
        while(!(this.list[i].equals(num)) && i < this.count){
            i++;
        }
        if((this.list.length-1) == i){
            this.list[i] = null;
            this.count--;
            return true;
    }
        else if(this.list.length == i){
            return false;
        }
        else{
            for(int y = i; y < this.list.length-1; y++){
                this.list[y] = this.list[y+1];
            }
            this.count--;
            return true;
        }
        
    }

    /**
    * removes a randomly selected selected entry 
    * from the bag
    * @return 
    */
    @Override
    public T remove() {
        Random rand = new Random();
        int index = rand.nextInt(this.count);
        T temp = this.list[index];
        this.list[index] = null;
        for(int y = index; y < this.count-1; y++){
                this.list[y] = this.list[y+1];
            }
            this.count--;
        return temp;
    }

    /**
     * removes all the elements from the bag
     */
    @Override
    public void clear() {
        for(int i = this.count-1; i>=0; i--){
            this.list[i] = null;
        }
        this.count=0;
    }

    /**
     * returns a count of the number of times
     * num exists in the bag
     * @param num
     * @return 
     */
    @Override
    public int getFrequency(T num) {
        int instances = 0;
        int i = 0;
        while(i < this.count){
            instances = num.equals(this.list[i]) ? instances+1 : instances;
            i++;
        }
        return instances;
    }

    /**
     * Tests whether the bag contains num.
     * Returns true when nm is contained in the bag
     * @param num
     * @return 
     */
    @Override
    public boolean contains(T num) {
        int i = 0;
        while(i < this.count){
            if(num.equals(this.list[i])){
                return true;
            }
            i++;
        }
        return false;
    }
    
    /**
     * returns a String of the contents of the bag
     * @return 
     */
    @Override
    public String toString(){
        String print = "";
        for(int i = 0; this.count-1 > i; i++){
            print += this.list[i].toString() + "; ";
        }
        print += this.list[this.count-1].toString();
        return print;
    }
    
    /**
     * returns true if the parameter o exactly matches
     * the contents of the bag.  Same numbers in the same order
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof ArrayBag)){
            return false;
        }
        else{
            ArrayBag a = (ArrayBag) o;
            if(!(this.count == a.count)){
                return false;
            }
            
           for(int i = 0; i < this.count; i++){
               if(!(this.list[i].equals(a.list[i]))){
                   return false;
               }
           }
           return true;
        }
    }
    
    /**
     * returns T at i index, but if not returns null
     * if index is inside the currently filled section of array
     * @param i
     * @return 
     */
    public T get(int i){
        if(0 <= i && i<=(this.count-1)){
            return this.list[i];
        }
        else{
            return null;
        }
    }
    
}
