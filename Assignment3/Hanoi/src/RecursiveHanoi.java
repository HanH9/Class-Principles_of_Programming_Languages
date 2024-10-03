/**
 * A programmatic solution to the Tower of Hanoi using recursion
 * @author H9
 * @version 1.0
 */
public class RecursiveHanoi
{

    /**
     * Constructs a Hanoi game.
     * @param count The number of discs to use
     */
    public RecursiveHanoi(int count)
    {
        // Move the number of discs from pole1 to peg pole3
        // using pole2 as a temporary storage location.
        moveDiscs(count, 1, 3, 2);
    }

    /**
     * Displays a disc move.
     * @param count The number of discs to move
     * @param source The pole to move from
     * @param destination The pole to move to
     * @param spare The temporary pole
     */
    private void moveDiscs(int count, int source,int destination, int spare){
        // Recursion process
        if(count > 0)
        {
            moveDiscs(count - 1, source, spare, destination);
            System.out.println(source + "-->" + destination);
            moveDiscs(count - 1, spare, destination, source);
        }
    }
}
