package level2;
import java.util.*;

public class Passchecker {
    public static void main(String[] args)
 {
   Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a password: ");
    String password = scanner.nextLine();
        int strength = 0;
        if (password.length() >= 8) 
        {
            strength++;
        }

        for (int i = 0; i < password.length(); i++)
         {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                strength++;
                break;
            }
        }

        for (int i = 0; i < password.length(); i++)
         {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) 
            {
                strength++;
                break;
            }
        }

        for (int i = 0; i < password.length(); i++)
         {
            char c = password.charAt(i);
            if (Character.isDigit(c))
             {
                strength++;
                break;
            }
        }

        if (password.matches(".*[!@#$%^&*()_=-\\[\\]{};':,.<>].*"))
        {
            strength++;
        }

        // for (int i = 0; i < password.length(); i++) {
        //     char c = password.charAt(i);
        //     if (isSpecialChar(c)) {
        //         strength++;
        //         break;
        //     }
        

       System.out.println("Strength is " +  strength);
        }
    }

    // public static boolean isSpecialChar(char c) {
    //     String specialChars = "!@#$%^&*(),.?-_+=\\[\\]{};:\"'<>,/\\\\";
    //     return specialChars.indexOf(c) != -1;
    // }


