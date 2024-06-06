public class ValuePair {
    private int a;
    private double b;

    public ValuePair(int a, double b) {
        modifyA(a);
        modifyB(b);
    }

    public int getOddInt() {
        return this.a;
    }

    public double getRealNum() {
        return this.b;
    }

    public void modifyA(int a) {
        if (a % 2 == 0) {
            throw new IllegalArgumentException();
        } else {
            this.a = a;
        }
    }

    public void modifyB(double b) {
        if (b > 0.0) {
            this.b = b;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double product() {
        return this.a * this.b;
    }

    public static void main(String[] args) {
        ValuePair vp1 = new ValuePair(7, 15.5);
        ValuePair vp2 = new ValuePair(3, 11.11);
        System.out.println(vp1.product());
        vp1.modifyA(25);
        System.out.println(vp1.product());
        double b1 = vp1.getRealNum();
        vp2.modifyA(vp2.getOddInt() + 2);
        System.out.println(b1);
        System.out.println(vp2.getOddInt());
    }
}
