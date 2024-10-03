import java.util.Stack;

/**
 * A programmatic solution to the Tower of Hanoi using iteration
 * @author H9
 * @version 1.0
 */
public class IterativeHanoi {

    /**
     * Constructs a Hanoi game.
     * @param count The number of discs to use
     */
    public IterativeHanoi(int count)
    {
        // Move the number of discs from pole1 to peg pole3
        // using pole2 as a temporary storage location.
        iterateHanoi(1, 3, 2, count);
    }

    /**
     * Moves discs with iteration
     * @param count The number of discs to move
     * @param source The pole to move from
     * @param destination The pole to move to
     * @param spare The temporary pole
     */
    public void iterateHanoi(int source, int destination, int spare, int count) {
        // Creates initial Hanoi
        HanoiState hanoi = new HanoiState(count, source, destination, spare);

        // Uses stack to implement iteration
        Stack<HanoiState> stack = new Stack<>();
        stack.push(hanoi);

        // Temp variables to record current moving information
        int countTemp, sourceTemp, destinationTemp, spareTemp;
        HanoiState HanoiTemp;
        while (!(stack.isEmpty())) {
            HanoiTemp = stack.pop();
            countTemp = HanoiTemp.count;
            sourceTemp = HanoiTemp.source;
            destinationTemp = HanoiTemp.destination;
            spareTemp = HanoiTemp.spare;

            // When there has only 1 disc on source pole, move it to destination directly
            if (countTemp == 1) {
                System.out.println(sourceTemp + "————>" + destinationTemp);
            } else {
                // Because the character of stack is first-in-last-out
                // so the moving order is on the contrary
                // move n-1 discs from spare to destination
                stack.push(new HanoiState(countTemp - 1, spareTemp, destinationTemp, sourceTemp));
                // move the last one disc from source to destination directly
                stack.push(new HanoiState(1, sourceTemp, destinationTemp, spareTemp));
                // move n-1 discs from source to spare
                stack.push(new HanoiState(countTemp - 1, sourceTemp, spareTemp, destinationTemp));
            }
        }
    }

    /**
     * Record the state of Hanoi
     */
    static class HanoiState {
        // number of discs
        int count;
        // The pole to move from
        int source;
        // The temporary pole
        int spare;
        // The pole to move to
        int destination;

        public HanoiState(int count, int source, int destination, int spare) {
            this.count = count;
            this.source = source;
            this.destination = destination;
            this.spare = spare;
        }
    }
}
