package com.company.algorythms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DHAlgorythm {
    GeneratorBigNumbers gen;

    public DHAlgorythm(){ gen=new GeneratorBigNumbers();}

    public List getAllPrimeDividersOfNumber(BigInteger number, int t){
        BigInteger newNumber=new BigInteger("2");
        List<BigInteger> list=new ArrayList();
        //System.out.println("Prime numbers in range [2, "+number+"]");
        while (newNumber.compareTo(number)<=0){
            if (gen.checkNumber(newNumber,t) && number.mod(newNumber).compareTo(BigInteger.valueOf(0))==0){
                //System.out.print(newNumber+" ");
                list.add(newNumber);
            }
            newNumber=newNumber.add(new BigInteger("1"));
        }
        return list;
    }

    public List getPrimitiveRoot(BigInteger number, List dividers){
        List<BigInteger> list=new ArrayList<>();
        BigInteger primitiveRoot=new BigInteger("2");
        BigInteger divider, dividend;
        int count=0;
        while (list.size()<100){
            count=0;
            for (int i=0;i<dividers.size();i++){
                divider=(BigInteger)dividers.get(i);
                dividend=number.add(BigInteger.valueOf(1).negate());
                if(primitiveRoot.modPow(dividend.divide(divider),number).compareTo(BigInteger.valueOf(1))!=0){
                    count++;
                }
            }

            if(count==dividers.size()){
                list.add(primitiveRoot);
            }
            //System.out.println("primitive root "+primitiveRoot);
            primitiveRoot=primitiveRoot.add(BigInteger.valueOf(1));
        }

        return list;
    }


    public BigInteger getAPowBmodN(BigInteger a, BigInteger b, BigInteger n){
       return a.modPow(b,n);
    }

    public  BigInteger getRandomBigInteger(BigInteger upperLimit) {
        Random rand = new Random();
        BigInteger result=new BigInteger("0");
        while(result.compareTo(upperLimit) >= 0 || result.compareTo(BigInteger.valueOf(2)) < 0 || !gen.checkNumber(result,5) ) {
            result = new BigInteger(upperLimit.bitLength(), rand);
        }
        return result;
    }

    public void printPrimitiveRootList(BigInteger number, int t){
        Date start=new Date();
        DHAlgorythm dha=new DHAlgorythm();
        List list=dha.getAllPrimeDividersOfNumber(number.add(BigInteger.valueOf(1).negate()),t);
        List roots=dha.getPrimitiveRoot(number,list);
        Date finish=new Date();
        System.out.println("\nElapsed time for 100 roots: "+((double)(finish.getTime()-start.getTime())/1000)+" seconds");

        System.out.println("100 ROOTS");
        for (Object item:roots){
            System.out.print(item+" ");
        }
        System.out.println();
    }

}
