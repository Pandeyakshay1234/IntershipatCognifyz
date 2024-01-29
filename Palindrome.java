
import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter String or phrase");
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String string = st.replaceAll("\\s", "").toLowerCase();
        if(ispalidrome(string))
        {
          System.out.println("string is palindrom");
        }
        else 
           System.out.println("string is not palindrom");

    }
    public static boolean ispalidrome(String st)
    {
       int i=0;
       int j=st.length()-1;
       while(i<=j)
       {
         char ch1 = st.charAt(i);
         char ch2=st.charAt(j);
         if(ch1!=ch2)
         {
            return false;
         }
         else 
         {
            i++;
            j--;
         }
       }

       return true;
    }
}
