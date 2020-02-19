package Exceptions.averageCalculator;

public class RandomNumberSource implements INumberSource {
    int number;
    public RandomNumberSource(int i) {
        number = i*16;
    }

    @Override
    public boolean hasMoreNumbers() {
        return false;
    }

    @Override
    public int nextNumber() {
        return 0;
    }
}
