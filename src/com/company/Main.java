package com.company;

import com.company.algorythms.DHAlgorythm;
import com.company.algorythms.GeneratorBigNumbers;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        int n=5, t=10;
        GeneratorBigNumbers gen=new GeneratorBigNumbers();
        //print iterations and elapsed time to generate prime testNumber
        BigInteger testNumber=gen.printAndReturnTestPrimeNumber(n,t);
        gen.printElapsedTimeToAllPrimeNumber(testNumber,t);
        //print elapsed time to generate prime root list for range [2, testNumber]
        DHAlgorythm dha=new DHAlgorythm();
        dha.printPrimitiveRootList(testNumber, t);

        //DIFFIE-HELLMAN
        System.out.println("Diffie-Hellman");
        BigInteger nNumber=new BigInteger("1"), Xa=new BigInteger("1"), Xb=new BigInteger("1");
        Menu.callMenu(nNumber,Xa,Xb,n,t);

    }
}
