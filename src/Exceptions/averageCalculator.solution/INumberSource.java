package Exceptions.averageCalculator.solution;

public interface INumberSource {

    boolean hasMoreNumbers();

    int nextNumber() throws InvalidNumberException;
}
