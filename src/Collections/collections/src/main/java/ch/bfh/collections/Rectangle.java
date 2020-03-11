package ch.bfh.collections;

public class Rectangle {

    int x;
    int y;
    int w;
    int h;

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getW() { return w; }
    public int getH() { return h; }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (getClass() != o.getClass()) return false;
        Rectangle r = (Rectangle)o;
        return (x == r.getX() && y == r.getY() && w == r.getW() && h == r.getH());
    }

    @Override
    public int hashCode() {
        return x + 16 * y + 64 *w + 512 * h;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 10, 100, 50);
        Rectangle r2 = r1;
        Rectangle r3 = new Rectangle(10, 10, 100, 50);
        Rectangle r4 = new Rectangle(0, 20, 50, 100);

        System.out.println(r1 == r2);                       // returns true
        System.out.println(r1 == r3);                       // returns false
        System.out.println(r1 == r4);                       // returns false
        System.out.println(r1.equals(r2));                  // returns true
        System.out.println(r1.equals(r3));                  // returns true
        System.out.println(r1.equals(r4));                  // returns false
        System.out.println(r1.hashCode() == r2.hashCode()); // returns true
        System.out.println(r1.hashCode() == r3.hashCode()); // returns true
        System.out.println(r1.hashCode() == r4.hashCode()); // can return true or false
    }
}