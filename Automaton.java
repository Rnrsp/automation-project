import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    // Question 12
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells + 1];
        reset();
    }
    
    // Question 12
    public void print()
    {
        for(int i = 0; i < numberOfCells; i++) {
            if(state[i] == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    // Question 6,7,8,9,10,12
    public void update()
    {
        int[] nextState = new int[state.length];
        int left = 0;
        int center = state[0];
        for(int i = 0; i < numberOfCells; i++) {
            int right = state[i + 1];
            nextState[i] = calculateNextState(left, center, right);
        
            left = center;
            center = right;
        }
        state = nextState;
    }
    
    // Question 5
    public void reset()
    {
        Arrays.fill(state, 0);
        state[numberOfCells / 2] = 1;
        state[(numberOfCells / 2) - 2] = 1;
        state[(numberOfCells / 2) + 2] = 1;
    }
    
    //Question 10,11
    public int calculateNextState(int left, int center, int right)
    {
        return (left + right) % 2;
    }
}