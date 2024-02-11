import java.util.Scanner;

public class passwordchecker {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        System.out.println("enter your Password");
        String Password = sc.nextLine();
        int Strength=0;
        if(Password.length()>=8)
        {
            Strength++;
        }
        for(int i=0;i<Password.length();i++)
        {
            char ch = Password.charAt(i);
            if(Character.isLowerCase(ch))
            {
                Strength++;
                break;
            }
        }
        for(int i=0;i<Password.length();i++)
        {
            char ch = Password.charAt(i);
            if(Character.isUpperCase(ch))
            {
              Strength++;
              break;
            }
        }
        for(int i=0;i<Password.length();i++)
        {
            char ch = Password.charAt(i);
            if(Character.isDigit(ch))
            {
                Strength++;
                break;
            }
        }

        if (Password.matches(".*[!@#$%^&*()_=-\\[\\]{};':,.<>].*"))
        {
            Strength++;
        }
        System.out.println(Strength);

        if(Password.length()<8)
        {
           System.out.println("your password week...... password should be atleast 8 character  ");

        }

       else if(Strength==5)
       {
        System.out.println("Your Password is strong");
       }
       else if(Strength>3 && Strength<5)
       {
        System.out.println("your password is not strong");
       }
       else
       {
        System.out.println("your Passwrd is very week make sure it must be 8 character and  atleast 1 uppercase ,1 lowercase,1digita and 1 special character");
       }

    }
}
