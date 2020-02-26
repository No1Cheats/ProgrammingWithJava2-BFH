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
        String s = null; //Not good there is a possibility for a Out of Bounds exception see how it is implemented in RandomNumberException
        try {
            s = strings[pos++];
            return Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            throw new InvalidNumberException(ex, s);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new InvalidNumberException(ex);
        }
   }
}
