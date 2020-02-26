package Exceptions.averageCalculator.solution;

public class StringNumberSource implements INumberSource {

    String[] strings;
    int pos;

    public StringNumberSource(String str) {
        strings = str.split(",");
        pos = 0;
    }

    public boolean hasMoreNumbers() {
        return pos < strings.length;
    }

    public int nextNumber() throws InvalidNumberException {
        String s = strings[pos++];
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            throw new InvalidNumberException(ex, s);
        }
   }
}
