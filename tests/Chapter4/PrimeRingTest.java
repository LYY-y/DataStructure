package Chapter4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeRingTest {
    @Test
    public void testConstructor(){
        PrimeRing primeRing=new PrimeRing(10);
    }

    @Test
    public void testCreatePrime() {
        System.out.println(PrimeRing.createPrime(10));
    }
}