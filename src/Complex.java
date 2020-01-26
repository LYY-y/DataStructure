import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Complex {
    private double real;
    private double imag;
    private int plusPosition;
    private int iPosition;
    private String realStr;
    private String imagStr;

    public Complex() {
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex(String complexStr){
        this.plusPosition=complexStr.indexOf("+");
        this.iPosition=complexStr.indexOf("i");
        this.realStr=complexStr.substring(0,plusPosition);
        this.imagStr=complexStr.substring(plusPosition,iPosition);


        this.real=Integer.parseInt(realStr);
        this.imag=Integer.parseInt(imagStr);
    }

    public boolean isMatchComplex(String complexStr){
        boolean isMatchReal = Pattern.matches("^([1-9][0-9]*)$", this.realStr); //非0开头的数字组合
        boolean isMatchImag = Pattern.matches("^([1-9][0-9]*)$", this.imagStr); //非0开头的数字组合
        boolean isMatchIPosition =
        if(iPosition==complexStr.length()-1 &&  ){
            try {
                throw new ComplexException("复数格式错误！");
            } catch (ComplexException e) {
                e.printStackTrace();
            }
        }
        return true;
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

    public void sub(Complex complex){
        this.real-=complex.real;
        this.imag=complex.imag;

    }

    public static Complex sub(Complex complex1,Complex complex2){
        return new Complex(complex1.real-complex2.real,complex1.imag-complex2.imag);
    }


    private class ComplexException extends Exception {
        public ComplexException(String message) {
            super(message);
        }
    }
}
