public class Complex {
    private double real;
    private double imag;

    public Complex() {
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return this.real + this.imag +"i";
    }

    public void add(Complex complex){
        this.real+=complex.real;
        this.imag+=complex.imag;
    }

    public static Complex add(Complex complex1,Complex complex2){
        return new Complex(complex1.real+complex2.real,complex1.imag+complex2.imag);
    }

    public void minus(Complex complex){
        this.real-=complex.real;
        this.imag=complex.imag;

    }
}
