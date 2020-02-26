package Exceptions.averageCalculator.solution;

import java.util.Random;

public class RandomNumberSource implements INumberSource {

    int length;
    int pos;
    Random rand;

    public RandomNumberSource(int length) {
        this.length = length;
        pos = 0;
        rand = new Random();
    }

    public boolean hasMoreNumbers() {
        return pos < length;
    }

    public int nextNumber() throws InvalidNumberException {
        if (!hasMoreNumbers())
            throw new InvalidNumberException("no more numbers available");
        pos++;
        return rand.nextInt(1000);
    }
}
