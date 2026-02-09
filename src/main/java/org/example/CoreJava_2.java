package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class CoreJava_2 {

    public  void getData()
    {
        System.out.println("getData");
    }

    public  String getData2()
    {
        System.out.println("getData");
        return "Shivaraj";
    }
    public static void  main(String[] args)
    {
        int a2[]={3425,3465,457758};
        for(int i=0;i< a2.length;i++)
        {
            if(a2[i]%2==0)
            {
                System.out.println(a2[i] + " Is multiple of 2");
            }
            else{
                System.out.println(a2[i] + " Is not multiple of 2");
            }
        }

        ArrayList<String> a=new ArrayList<String>();
        a.add("Shivaraj");
        a.add("M1");
        a.add(0,"C1");
        a.add("H10");
        a.remove(2);
        //System.out.println(a.get(0));

        for(int i=0;i<a.size();i++)
        {
            System.out.println(a.get(i));
        }

        for(String v : a)
        {
            System.out.println(v);
        }

        System.out.println(a.contains("H10"));

        //String Literal
        String s1="C1";
        String s2="C1";

        //Using New Keyword
        String S3= new String("S1");
        String S4= new String("S1");

        if(s1==s2)
            System.out.println("Yes");
        else
            System.out.println("No");

        if(S3==S4)
            System.out.println("Yes");
        else
            System.out.println("No");

        String s="Shivaraj B Sajjan";
        String[] sp=s.split("B");
        for(String v : sp)
        {
            System.out.println(v.trim());
        }

        for(int i=0;i<s.length();i++)
        {
            System.out.print(s.charAt(i));
        }

        for(int i=s.length()-1;i>=0;i--)
        {
            System.out.print(s.charAt(i));
        }
        System.out.println();
        CoreJava_2 cj=new CoreJava_2();
        cj.getData();
        String data2 = cj.getData2();
        System.out.println(data2);
        CoreJava_BrushUp cb=new CoreJava_BrushUp();
        cb.SetData();
    }
}
