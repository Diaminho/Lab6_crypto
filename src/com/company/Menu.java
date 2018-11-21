package com.company;

import com.company.algorythms.DHAlgorythm;
import com.company.algorythms.GeneratorBigNumbers;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void callMenu(BigInteger nNumber,BigInteger Xa, BigInteger Xb, int n, int t){
        Scanner sc=new Scanner(System.in);
        GeneratorBigNumbers gen=new GeneratorBigNumbers();
        DHAlgorythm dha=new DHAlgorythm();
        System.out.print("Input 1 to generate n, Xa, Xg\nInput 2 to manually input n,Xa,Xb\n");
        int menu=sc.nextInt();
        switch (menu){
            case 1:
                nNumber=gen.generatePrimeNumber(n, t);
                Xa=dha.getRandomBigInteger(nNumber);
                Xb=dha.getRandomBigInteger(nNumber);
                break;
            case 2:
                System.out.println("Input n: ");
                n=sc.nextInt();
                nNumber=gen.generatePrimeNumber(n, t);
                System.out.println("generated number: "+nNumber);
                System.out.println("Input Xa: ");
                Xa=sc.nextBigInteger();
                System.out.println("Input Xb: ");
                Xb=sc.nextBigInteger();
                break;
            default:
                System.out.println("Input 1 or 2");
        }
        List list=dha.getAllPrimeDividersOfNumber(nNumber.add(BigInteger.valueOf(1).negate()),t);
        List roots=dha.getPrimitiveRoot(nNumber,list);
        BigInteger g=(BigInteger)roots.get(0);

        System.out.println("generated Number: "+nNumber+"; Xa: "+Xa+"; Xb: "+Xb+"; g: "+g);

        //1 subscriber
        BigInteger Ya=dha.getAPowBmodN(g,Xa,nNumber);

        //2 subscriber
        BigInteger Yb=dha.getAPowBmodN(g,Xb,nNumber);

        //Keys
        BigInteger key1=dha.getAPowBmodN(Yb,Xa,nNumber);
        BigInteger key2=dha.getAPowBmodN(Ya,Xb,nNumber);
        System.out.println("key1: "+key1+"\nkey2: "+key2);

    }
}
