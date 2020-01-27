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
        if (this.iPosition==-1){
            if(isMatchNum(realStr)) {
                this.real=Double.parseDouble(realStr);
                this.imag=0;
            }
        }else {
            this.imagStr=complexStr.substring(plusPosition+1,iPosition);
            if (this.iPosition==complexStr.length()-1 && isMatchNum(realStr) && isMatchNum(imagStr)){
                this.real=Double.parseDouble(realStr);
                this.imag=Double.parseDouble(imagStr);
            }
        }
        System.out.println(toString());
    }

    public boolean isMatchNum(String str){
        boolean isMatch = Pattern.matches("^-?([1-9]\\d*\\.\\d*|0\\.\\d*|0)$", str); //非0开头的数字组合
        if(isMatch){
            return true;
        }else {
            try {
                throw new ComplexException("数字格式错误！");
            } catch (ComplexException e) {
                e.printStackTrace();
            }
            return false;
        }
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
        return this.real + "+" + this.imag +"i";
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

    public  static boolean equals(Complex complex1,Complex complex2){
        if (complex1.real==(complex2.real)  && complex1.imag==complex2.imag){
            return true;
        }else {
            return false;
        }
    }

    public boolean equals(String comStr1, String comStr2){
        Complex complex1=new Complex(comStr1);
        Complex complex2=new Complex(comStr2);
        return equals(complex1,complex2);
    }

    private class ComplexException extends Exception {
        public ComplexException(String message) {
            super(message);
        }
    }
}
