/*
Name:Mashael waleed 
ID:
Section Number:BBC
Email:
Date:20/4/2023
Assignment:Assignment2

 */
package Assignment2_Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Assignment_Q3 {
    
   //static varibles to use them in the metods
        static  Scanner input;
        static PrintWriter output;
        static ArrayList<Character>charList;//List to store common chars to prevent any repeating in the result
        //static array to store even numbers since we don't allowed to put more than one parameter in our method head
        static int [] evenArray; 
        static int countEven; //counter for index
    public static void main(String[] args) throws FileNotFoundException {
        
        //create Scanner
        File file =new File("input.txt");
        //check if file exists
        if(!file.exists()){
        System.out.println("The file not found");
        }
        
        else{
        //create scanner to read from the file 
        input=new Scanner(file);
        //create print writer
        File file2=new File ("output.txt");
        output=new PrintWriter(file2);
       
        
        ////////////////////////////////////////////////
        
        //read number of commands
         int numCommand=input.nextInt();
         for(int i=0;i<numCommand;i++){
          
         //read command
         String command=input.next();
         
         //=======================Switch for the Cases==========================//
         switch(command){
         
         case"repeatDigit":
            //read data for this command
            int number= input.nextInt();
            int digit=input.nextInt();
            int times = input.nextInt();
            //call repeatDigit method
            int result =repeatDigit(number,times,digit);
            //call print method
            PrintRepeatDigit(result,times,digit);
            output.flush();
            break;
         //=====================================================================    
         case"findEvenNumbers" :

            //read array elements
             String line =input.next();
            //split the numbers 
             String []numStrArray=line.split(",");
            //create Array to store numbers
             int []myArray=new int[numStrArray.length];
            //size for static evenArray
             evenArray=new int[numStrArray.length];
            //fill the array
             for(int j=0;j<myArray.length;j++){
             myArray[j]=Integer.parseInt(numStrArray[j]);
             }
            //call the method
             int [] result2= findEvenNumbers(myArray);
             PrintEvenNumbers(result2);
            
             countEven=0;//to make it 0 again for next use.
             break;
         //====================================================================+ 
         case"displayCommonChars" : 
      
             String str1=input.next();
             String str2=input.next();
             charList=new ArrayList<Character>();
            //call CommonChars method 
              String result3= displayCommonChars(str1,str2);
            //call print method
              printCommonChars(result3);
              output.flush();
              break;
        
         }//end of switch
         
         }//end of loop 
        
        }
        
        }//end of main
    
  ////////////////////////////REPEAT DIGIT METHOD///////////////////////////////
   public static int  repeatDigit(int number,int times,int digit){
   if(times!=0){
       //a new digit will be added to the number 
       return  repeatDigit(number*10+digit,times-1,digit);}
       return number;
   }
   
  /////////////////////////FIND EVEN NUMBERS METHOD/////////////////////////////
   
      public static int[] findEvenNumbers(int[] list){
     if(list.length==0){
        return evenArray;}
   
     else{ //if the number is even store it in the evenArray
           if(list[0]%2==0){
           evenArray[countEven]=list[0];
           countEven++;
           }
           /*remove first element of the array by create 
           a copy "n" start from index 1...
           */
           int [] n=new int[list.length-1];
           System.arraycopy(list, 1, n, 0, n.length);
            
           return findEvenNumbers(n);}
      }
  ////////////////////////////COMMON CHARS METHOD///////////////////////////////////////////
      
     public static String displayCommonChars(String str1,String str2){
       
        if(str1.length()==0){
        return str1; }
        
    //if char of s1 found in str2............................................................
        else if (str2.toUpperCase().contains(String.valueOf(str1.charAt(0)).toUpperCase())) {
            /*if char list empty add char to char list
            or if char list does not contain the char add it to list
            */
       if(charList.isEmpty()||!charList.contains(Character.toUpperCase(str1.charAt(0)))){
            /*there is no diffrence between 'A' or 'a' and so on .. so always
            store uppercase letters  in char List  */
            charList.add(Character.toUpperCase(str1.charAt(0)));
            //return the common char +call the method
            return str1.charAt(0)+displayCommonChars(str1.substring(1),str2);}
        
            //if the common char is repeated only call the method
            return displayCommonChars(str1.substring(1),str2);
            }
        
    //if no char found only call the method ......................................................   
        else{ 
            return displayCommonChars(str1.substring(1),str2);}
   } 
         
  /////////////////////////////////PRINT METHODS////////////////////////////////////////////

 public static void  PrintRepeatDigit(int result,int times,int digit){
 
 output.println(result+" is the number with repeated "+times+" times of digit "+digit);
 }      
 
//-----------------------------------------------------------------------------------------
 public static void  PrintEvenNumbers(int[] list){
 
 output.print("The even array list is: ");
 for (int i=0;i<countEven;i++){
 output.print((i==0)?list[i]:","+list[i]);}
 output.println();
 } 
 //---------------------------------------------------------------------------------------
  public static void  printCommonChars(String result){
 
 output.println("The common characters are "+ result);
 } 
 
 /////////////////////////////////////////////////////////////////////////////////////////
 
 
}
