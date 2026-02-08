package org.example;

public class CoreJava_2 {

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
    }
}
