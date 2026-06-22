import org.testng.Assert;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public void CheckCountStartsWIthAUsingNormal()
    {
        ArrayList<String> s=new ArrayList<String>();
        s.add("Abji");
        s.add("Ram");
        s.add("Ak");
        s.add("As");
        s.add("sa");
        int count=0;

        for(String n:s)
        {
            if(n.startsWith("A"))
            {
                count++;
            }
        }
        System.out.println(count);
    }

    public  void CheckCountStartsWIthAUsingStreams()
    {
        ArrayList<String> s=new ArrayList<String>();
        s.add("Abji");
        s.add("Ram");
        s.add("Ak");
        s.add("As");
        s.add("sa");
        int count=0;

       // System.out.println(s.stream().filter(s1->s1.startsWith("A")).count());
        System.out.println(Stream.of("Abhi","Ram","A1","A2","s1").filter(s2->s2.startsWith("A")).count());
    }

    public void PrintAllNamesInArrayListwithLengthGreaterthan4()
    {
        Stream.of("Abhi","Ram123","A1543","A22345","s1").filter(s->s.length()>4).
                forEach(s->System.out.println(s));
    }

    public void PrintOneNamesInArrayListwithLengthGreaterthan4()
    {
        Stream.of("Abhi","Ram123","A1543","A22345","s1").filter(s->s.length()>4).limit(1).
                forEach(s->System.out.println(s));
    }

    //Map method we will use to manipulate the stream
    public void PrintNamesEndingWithaInUpperCase()
    {
        Stream.of("Abhia","Ram123a","A15er43","A2rt2345a","s1").filter(s->s.endsWith("a")).
                map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    }

    public void PrintNamesStartingWithAInUpperCaseandSorted()
    {
        List<String> names = Arrays.asList("Aniruddha","Ram123a","Ashika","Abhi","s1");
        names.stream().filter(s->s.startsWith("A")).
                map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
    }
    public void MergeTwoArrays()
    {
        String n1[]={"A1","A2","B1"};
        String n2[]={"B2","A3","B3"};

        List<String> nn1=Arrays.asList(n1);
        List<String> nn2=Arrays.asList(n2);

        Stream<String> newStream= Stream.concat(nn1.stream(),nn2.stream());
        newStream.sorted().forEach(s-> System.out.println(s));

    }

    public void FindParticulatrValueinStream()
    {
       boolean flag= Stream.of("Abhia","Ram123a","A15er43","A2rt2345a","s1").
               anyMatch(s->s.equalsIgnoreCase("A15er43"));
       System.out.println(flag);
        Assert.assertTrue(flag);
    }

    public void ConvertTheStreamtoList()
    {
        List<String> lits=Stream.of("Abhia","Ram123a","A15er43","A2rt2345a","s1").filter(s->s.startsWith("A")).
                map(s->s.toUpperCase()).collect(Collectors.toList());

        System.out.println(lits.get(0));
    }

    public void PrintUniqueNoInSorted()
    {
        List<Integer> ls=Arrays.asList(1,3,8,2,1,3,4,3,2,6,5);
        ls.stream().distinct().sorted().forEach(s->System.out.println(s));
    }

    public void Print3rdIndexfromSorted()
    {
        List<Integer> ls=Arrays.asList(1,3,8,2,1,3,4,3,2,6,5);
        List<Integer> list=ls.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list.get(3));
    }


    public  static  void main(String[] args)
    {
        Streams s=new Streams();
        //s.CheckCountStartsWIthAUsingNormal();
        //s.CheckCountStartsWIthAUsingStreams();
        //s.PrintAllNamesInArrayListwithLengthGreaterthan4();
        //s.PrintOneNamesInArrayListwithLengthGreaterthan4();
        //s.PrintNamesEndingWithaInUpperCase();
        //s.PrintNamesStartingWithAInUpperCaseandSorted();
        //s.MergeTwoArrays();
        //s.FindParticulatrValueinStream();
        //s.ConvertTheStreamtoList();
        s.PrintUniqueNoInSorted();
        s.Print3rdIndexfromSorted();

    }
}
