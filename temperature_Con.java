
import java.util.*;
public class temperature_Con{

 public double  CelsiustoFahr(double tem)
 {
    double Fahrenheit = ((tem*9)/5)+32;
    return Fahrenheit;
 }
 public double FahrenheittoCel (double tem)
 {
      double Celsius = ((tem-32)*5)/9 ;
    return Celsius;
 }
    public static void main(String[] args) {
        temperature_Con tc = new temperature_Con();
      Scanner sc  = new Scanner(System.in);

      while(true){
      System.out.println("Enter 1  for celsius to Fahrenheit" + "and 2 for Fahrenheit to celscius");
      System.out.println("Enter Exit if you want to exit😊");
      String input  =  sc.nextLine();
      
      if(input.equals("Exit"))
      {
        System.out.println("Thankyou,Goodbyy");
        break;
      }
        try{
            int n = Integer.parseInt(input);
            System.out.println("Enter temprature to be convert");
            double tem = sc.nextDouble();
            if(n==1)
            {
                   double converttemp = tc.CelsiustoFahr(tem);
                   System.out.println("converted temprsture is :" + converttemp);
            }
            else if (n==2)
            {
              double converttemp = tc.FahrenheittoCel(tem);
              System.out.println("converted temprsture is :" + converttemp);
            }
            else
            {
             System.out.println("Sorry! you enterd wrong key word");
            }
        }
      catch(NumberFormatException e)
      {
          e.getStackTrace();
      }
    }
    sc.close();
    }
}