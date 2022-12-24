import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Runner {

<<<<<<< HEAD
    
    /** 
     * @param args
     * @throws Exception
     */
=======
>>>>>>> 96ef375 (Proyecto)
    public static void main(String[] args) throws Exception {
        new Runner().menu();   
        
    }

    void menu(){
        String menu = "-------- Principal Menu --------\n\n" + 
        "A. Roman numerals\n" +
        "B. Prime factors\n" +
        "C. Delete spaces\n" +
        "D. Narcissistic number\n" +
        "E. Magic number\n" +
        "F. Date\n\n" +
        "X. Exit";       
        
        char option = '0';
        do {

            try{
                option = JOptionPane.showInputDialog(menu).charAt(0);
            }catch(NullPointerException e ){

            }

            switch (Character.toUpperCase(option)) {
                case 'A':
                romanNumerals();
                    break;  

                case 'B':
                primeFactors();
                    break;

                case 'C':
                deleteSpaces();
                    break;

                case 'D':
                narcissisticNumber();
                    break;

                case 'E':
                magicNumber();
                    break;

                case 'F':
                date();
                    break;
            }

        } while (Character.toUpperCase(option) != 'X');
    }

    //FIRST METHOD
    public static void romanNumerals(){
        String romanNumber = "";
        char romanSymbols [] = {'I', 'X', 'C', 'M', 'V', 'L', 'D'};
        char repeatSymbols [] = Arrays.copyOfRange(romanSymbols, 4, 7);        

        try {
            romanNumber = JOptionPane.showInputDialog("Enter a roman number").toUpperCase();
        } catch (Exception e) {
            
        }
        //Symbols validations  
        int contVali = 0;
        for (int j = 0; j < romanNumber.length(); j++) {
            for (int i = 0; i < romanSymbols.length; i++) {            
                if (romanNumber.charAt(j) == romanSymbols[i]) {
                    contVali++;
                }                                
            }
        }
        if (romanNumber.length() != contVali) {
            JOptionPane.showMessageDialog(null, "Invalid number. Different characters");         
        } 
        //Non repeating numbers Validation(V, L, D)        
        boolean condition = true;
        while (condition) {

            for (int i = 0; i < romanNumber.length()-1; i++) {

                for (int j = 0; j < repeatSymbols.length-1; j++) {

                    char firstChar = romanNumber.charAt(i);
                    char secondChar = romanNumber.charAt(i + 1); 

                    if (romanNumber.charAt(i) == repeatSymbols[j] & firstChar == secondChar) {
                        JOptionPane.showMessageDialog(null, "Invalid number. Repeat numbers (V, L, D)");
                        condition = false;
                    }
                    condition = false;
                }
                
            }
            
        }

        //Validation of repeat symbols (More than three consecutive numbers)
        int contRepThree = 0;
        condition = true;
        
        while (condition) { 
            for (int i = 0; i < romanNumber.length()-1; i++) {

                char firstChar = romanNumber.charAt(i);
                char secondChar = romanNumber.charAt(i+1);    
                
                if (firstChar == secondChar) {
                    contRepThree++;

                    if (contRepThree == 3) {
                    JOptionPane.showMessageDialog(null, "Invalid number. Repeat numbers");
                    condition = false;    
                    contRepThree = 0;                
                    }
                    
                }  
                
                condition = false;
            }
            contRepThree = 0;        
        }
        //Number converter
        int decimal [] = new int [romanNumber.length()];
        condition = true;
        
        while (condition) {
            
            for (int i = 0; i < romanNumber.length(); i++) {
            
                if (romanNumber.charAt(i) == 'I') {
                    decimal [i] = 1;
                } else if (romanNumber.charAt(i) == 'V') {
                    decimal [i] = 5;
                } else if (romanNumber.charAt(i) == 'X') {
                    decimal [i] = 10;
                } else if (romanNumber.charAt(i) == 'L') {
                    decimal [i] = 50;
                } else if (romanNumber.charAt(i) == 'C') {
                    decimal [i] = 100;
                } else if (romanNumber.charAt(i) == 'D') {
                    decimal [i] = 500;
                } else if (romanNumber.charAt(i) == 'M') {                    
                    decimal [i] = 1000;
                    
                }                
            }
            condition = false;
        }    
        int result = 0;
        condition = true;
        while (condition) {
            for (int i = 0; i < decimal.length-1; i++) {

                int firstInt = decimal[i];
                int secondInt = decimal[i+1];
                
    
                if (firstInt < secondInt) {
                    result = result - firstInt;
                }else if (firstInt >= secondInt){
                    result = result + firstInt;
                }    
                
            }
            condition = false;
        }
        result = result + decimal[decimal.length-1];
        JOptionPane.showMessageDialog(null, "The number is: " + result);
    }
    //SECOND METHOD
    public static void primeFactors(){
        //Input number
        int number = 0;
        boolean correct = true;
        while (correct == true) {

            try {
                number = Integer.parseInt(JOptionPane.showInputDialog("Enter one number"));
                correct = false;
            } catch (Exception e) {
                
                continue;
                
            }
            
        }
        
        //Prime number
        int primeNumber = 2;
        String numString = "";

        while (number != 1) {

            if (number % primeNumber == 0) {
                number = number / primeNumber;
                numString = numString + String.valueOf(primeNumber);  
            }else{
                primeNumber++;
            }                  
        }             

        //String
        int cont = 1;
        String finalString = "";
        char firstCharacter = ' ';
        char secondCharacter = ' ';
        
        for (int i = 0; i < numString.length()-1; i++) {

            firstCharacter = numString.charAt(i);
            secondCharacter = numString.charAt(i + 1);

            if (firstCharacter == secondCharacter) {
                cont++;                
            }else{
                
                if (finalString == "") {
                    finalString = firstCharacter + "^" + cont; 
                    cont = 1;
                }else{
                    finalString = finalString + " * " + firstCharacter + "^" + cont;
                    cont = 1;
                }
                
            }            
        }
        if (finalString == "") {
            finalString = firstCharacter + "^" + cont;            
        }else{
            finalString = finalString + " * " + firstCharacter + "^" + cont;            
        }        
        JOptionPane.showMessageDialog(null, finalString);    
    }

    
    /** 
     * @return String
     */
    //THIRD METHOD
    public static String deleteSpaces(){
        String textString = JOptionPane.showInputDialog("Enter one String");
        String newTextString = textString.replace(" ","");   
        JOptionPane.showMessageDialog(null, newTextString);     
        return textString;        
    }
    //FOURTH METHOD
<<<<<<< HEAD
    public static void narcissisticNumber(){
=======
    private static void narcissisticNumber(){
>>>>>>> 96ef375 (Proyecto)
        
        int number = 0;
        boolean condition = true;
        String numberString = "";
        while (condition) {

            try {
                number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));  
                condition = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Enter a correct value");                        
            }    
        }
        
        numberString = numberString.valueOf(number);     
        double power = numberString.length();
        double sum = 0;
        boolean egoNumber = true;

        for(int i = 0; i < power; i++){
            double currentValue = Character.getNumericValue(numberString.charAt(i));
            double powerResult = Math.pow(currentValue, power);
            sum = sum + powerResult;
        }
        
        if (sum == number) {
            egoNumber = true;
            JOptionPane.showMessageDialog(null, egoNumber);
        }else {
            egoNumber = false;
            JOptionPane.showMessageDialog(null, egoNumber);
        }
    } 
    

    //FIFTH METHOD
    public static void magicNumber(){
        //Get number
        boolean correct = true;
        long number = 0;
        String numberString = " ";
        
        while (correct) {

            try {
                number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));    
                correct = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Enter a correct value");                        
            }    
        }
        //Low to High
        numberString = numberString.valueOf(number);

        int[] numberArray = new int [numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            numberArray[i] = Character.getNumericValue(numberString.charAt(i));
        }

        String numberDes = "";
        String numberAsc = "";
        
        int[] numberSorted = sortArray(numberArray);
        for (int i = numberSorted.length-1; i >-1 ; i--) {            
            numberDes = numberDes + numberSorted[i];
        }

        for (int i = 0; i < numberSorted.length; i++) {
            numberAsc = numberAsc + numberSorted[i];
        }

        int numberDesFinal = Integer.parseInt(numberDes);
        int numberAscFinal = Integer.parseInt(numberAsc);

        int result = numberDesFinal - numberAscFinal;

        if (result == number) {
            JOptionPane.showMessageDialog(null, "True");
        }else{
            JOptionPane.showMessageDialog(null, "False");
        }       
    }
    
    /** 
     * @param arr
     * @return int[]
     */
    public static int[] sortArray(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                        if(arr[j-1] > arr[j]){  
                                //swap elements  
                                temp = arr[j-1];  
                                arr[j-1] = arr[j];  
                                arr[j] = temp;  
                        }  
                        
                }  
        }  
        return arr;
    }
    //SIXTH METHOD

    public static void date(){
        try {
            String nameMonth = "";
<<<<<<< HEAD
            String dateString = JOptionPane.showInputDialog("Enter a date. dd/mm/yyyy");                
=======
            String dateString = JOptionPane.showInputDialog("Enter a date\n dd/mm/yyyy");                
>>>>>>> 96ef375 (Proyecto)

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateString, formatter);

            // Get day from date
            int day = date.getDayOfMonth();

            // Get month from date
            Month month = date.getMonth();

            // Get year from date
            int year = date.getYear();

            switch (month.getValue()) {
                case 1:
                    nameMonth = "Enero";
                    break;
            
                case 2:
                    nameMonth = "Febrero";
                    break;

                case 3:
                    nameMonth = "Marzo";
                    break;

                case 4:
                    nameMonth = "Abril";
                    break;

                case 5:
                    nameMonth = "Mayo";
                    break;

                case 6:
                    nameMonth = "Junio";
                    break;

                case 7:
                    nameMonth = "Julio";
                    break;

                case 8:
                    nameMonth = "Agosto";
                    break;

                case 9:
                    nameMonth = "Septiembre";
                    break;

                case 10:
                    nameMonth = "Octubre";
                    break;

                case 11:
                    nameMonth = "Noviembre";
                    break;

                case 12:
                    nameMonth = "Diciembre";
                    break;
            }
            
            JOptionPane.showMessageDialog(null, day + " de " + nameMonth + " de " + year);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a correct value");
            
        }
    }    
}
