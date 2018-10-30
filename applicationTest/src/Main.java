import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<String> Arraylist=new ArrayList<>();
        Arraylist.add("hello");
        String str="abc";
        String strII="ab";
       String strIII="c";
        strII=strII+strIII;
        System.out.println(str==strII);
        Main m=new Main();
     int result=   m.testResult(1);
     System.out.println(result);
    }

    public int testResult(int i){
       int result=0;
       switch (i){
           case 1:
               result=1;
           case 2:
               result=result+i*2;
               case 3:
                   result=result+i*3;
       }
       return result;
    }
}
