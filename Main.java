
import java.util.*;

public class Main {
    public static void second_type(String str, int n) {
        int index;
        if(str.contains("00") && !str.contains("000"))
        {
            System.out.println("second type : " + str);
        }
        else if (str.contains("000")) {
            index = str.indexOf("000");
            System.out.println("second type : " + str.substring(0, index + 2));
            second_type(str.substring(index + 2, str.length()), str.length() - index - 2);
        } else {
            System.out.println(str);
        }
    }
    public static void first_type(String str, int n) {
        int index = 0;
        String someString = str;
        char b_char = 'b';
        int b_counter = 0;
        int index2 = 0;
        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == b_char) {
                b_counter++;
                if(b_counter == 2)
                {
                    index2 = i;
                }
                if (b_counter == 3) {
                    index = i;
                }
            }
        }
        if(str.contains("a") && (b_counter == 2))
        {
            System.out.println("first type : " + str);
        }
        else if (b_counter > 2 && (str.substring(index2,str.length()).contains("a") || str.substring(0,index2).contains("a")) ){
            System.out.println("first type : " + str.substring(0, index));
            first_type(str.substring(index, str.length()), str.length() - index-1);
        }
        else if(!str.contains("a")){
            System.out.println("third type : "+str);
        }
        else {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int tail = str.length();
        int head = 0;
        int index01;
        int indexab;
        indexab = Math.min(str.indexOf("a"),str.indexOf("b"));
        index01 = Math.min(str.indexOf("0"),str.indexOf("1"));
        while(head != tail)
        {
            if(index01 == -1)
            {
                first_type(str, str.length());
                break;
            }
            else if(indexab == -1)
            {
                second_type(str, str.length());
                break;
            }
            else if(index01 < indexab)
            {
                second_type(str.substring(index01,indexab), indexab-index01);
            }
            else
            {
                first_type(str.substring(indexab,index01),index01-indexab);
            }
            head += Math.max(index01,indexab);
            str = str.substring(Math.max(index01,indexab),str.length());
            indexab = Math.min(str.indexOf("a"),str.indexOf("b"));
            index01 = Math.min(str.indexOf("0"),str.indexOf("1"));
        }

    }
}
