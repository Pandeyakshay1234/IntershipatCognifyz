import java.util.*;
public class Pass_Gen {
        public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter length of password which  you want");

         int length= sc.nextInt();

         System.out.println("enter y if  you want number otherwise n -> y/n");
         boolean number = sc.next().equalsIgnoreCase("y");
        //System.out.println(number);

         System.out.println("enter y  if  you want  uppercase otherwise n -> y/n");
         boolean uppercase = sc.next().equalsIgnoreCase("y");

         System.out.println("enter y  if  you want  lowercase otherwise n -> y/n");
         boolean lowercase = sc.next().equalsIgnoreCase("y");

         System.out.println("enter y if  you want special Character -> y/n");
         boolean specialchar = sc.next().equalsIgnoreCase("y");
  
        String password = Generate(length ,number,uppercase,lowercase,specialchar);

        System.out.println(password);

    }

    public static String Generate(int length,boolean number,boolean uppercase,boolean lowercase,boolean specialchar)
    {
      StringBuilder sb= new StringBuilder();
      
      if(length <=0)
      {
        System.out.println("you enterd wrong number enter atleast 1");
      }
      if(number)
      {
        sb.append("0123456789");
      }
      if(uppercase)
      {
        sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
      }
      if (lowercase) {
        sb.append("abcdefghijklmnopqrstuvwxyz");
      }
     if (specialchar) {
        sb.append("!@#$%^&*()_-={}[]><?");
     }
     StringBuilder password = new StringBuilder();
     for(int i=0;i<length;i++)
     {
        int index  = (int)(Math.random()*sb.length());
        password.append(sb.charAt(index));
     }
        return password.toString();
    }
}
