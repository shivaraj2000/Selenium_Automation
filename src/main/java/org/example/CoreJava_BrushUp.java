package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJava_BrushUp {

    public static void  main(String[] args)
    {
        //Varibale and Data Types
        int n=5;
        String s="Shiva";
        char c ='s';
        boolean x=true;
        float a= 46.4F;
        float v= 44.455F;

        System.out.println(n + s + c + x + a);

        //Arrays
        int arr[]=new int[3];
        arr[0]=3;
        arr[1]=4;
        arr[2]=6;
        //arr[3]=7;

        //System.out.println(arr[2]);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        int a2[]={3425,3465,457758,879780,5,453,3465,3465,4365};
        for(int j=0;j<a2.length;j++)
        {
            System.out.println(a2[j]);
        }

        String SD[]={"S1","s2","s3"};
        for(int k=0;k<SD.length;k++)
        {
            System.out.println(SD[k]);
        }

        for(String ss:SD)
        {
            System.out.println(ss);
        }

        List<String> AL=Arrays.asList(SD);
        for(String va : AL)
        {
            System.out.println(va);
        }


    }
    public  void SetData(){
        System.out.println("Shiva");
    }
}
