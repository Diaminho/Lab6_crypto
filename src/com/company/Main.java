package com.company;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int n=20, t=10;
        Date start, finish;
        start=new Date();
        GeneratorBigNumbers gen=new GeneratorBigNumbers();
        BigInteger number=gen.generatePrimeNumber(n, t);
        System.out.println("Generated prime number: "+number);
        finish=new Date();
        System.out.println("Elapsed time to generate Prime Number: "+((double)(finish.getTime()-start.getTime())/1000)+" seconds");
        start=new Date();
        gen.printAllPrimeNumbers(number,t);
        finish=new Date();
        System.out.println("Elapsed time to print Prime Numbers: "+((double)(finish.getTime()-start.getTime())/1000)+" seconds");
        start=new Date();
        DHAlgorythm dha=new DHAlgorythm();
        List list=dha.getAllPrimeDividersOfNumber(number.add(BigInteger.valueOf(1).negate()),t);
        List roots=dha.getPrimitiveRoot(number,list);
        finish=new Date();
        System.out.println("\nElapsed time for 100 roots: "+((double)(finish.getTime()-start.getTime())/1000)+" seconds");

        System.out.println("100 ROOTS");
        for (Object item:roots){
            System.out.print(item+" ");
        }

        //DIFFIE-HELLMAN
        BigInteger g=(BigInteger)roots.get(0);
        BigInteger nNumber=gen.generatePrimeNumber(n, t);
        BigInteger Xa=dha.getRandomBigInteger(nNumber);
        BigInteger Xb=dha.getRandomBigInteger(nNumber);
        System.out.println("N: "+nNumber+"; Xa: "+Xa+"; Xb: "+Xb+"; g: "+g);

        //1 subscriber
        BigInteger Ya=dha.getAPowBmodN(g,Xa,nNumber);

        //2 subscriber
        BigInteger Yb=dha.getAPowBmodN(g,Xb,nNumber);

        BigInteger key1=dha.getAPowBmodN(Yb,Xa,nNumber);
        BigInteger key2=dha.getAPowBmodN(Ya,Xb,nNumber);
        System.out.println("key1: "+key1+" key2: "+key2);

    }
}
