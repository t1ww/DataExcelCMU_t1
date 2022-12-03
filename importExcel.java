// @author Narongchai Rongthong 652115013

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class importExcel {
    public static void main(String args[]) throws FileNotFoundException {
        final int size = 99;
        double mylist[][] = new double[size][size];
        double totallist[] = new double[size];
        StringTokenizer token;
        File f = new File("t1.csv");
        // read the input file
        Scanner myScan = new Scanner(f);//scan open
        // read line by line
        {//start
            System.out.println("Excel table : ");
            lines();
            var i = 0;
            while(myScan.hasNext()) {
                // keep reading until the end of file
                // store each value in each column to the data structure
                String dataLine = myScan.nextLine();
                // you are going to tokenize the data such that it will seperate into 2 String values
                // parse the string to double
                token = new StringTokenizer(dataLine, ",");
                double bufferA = Double.parseDouble(token.nextToken()); //row A
                double bufferB = Double.parseDouble(token.nextToken()); //row B
                mylist[0][i] = bufferA;
                mylist[1][i] = bufferB;
                System.out.println(" | " + bufferA + "  |  " + bufferB + " |  "+ i);
                lines();
                i++;
            }
        }//end
        lines();
        //calculate total each elements
        for(int i = 0; i<size; i++){
            totallist[i] = mylist[0][i] + mylist[1][i];
        }
        //show top 5 and bottom 5
        System.out.println("top five answers :");
        for(int i = 0; i<5; i++){
            System.out.println(totallist[i]);
        }
        lines();
        System.out.println("bottom five answers :");
        for(int i = size-5; i<size; i++){
            System.out.println(totallist[i]);
        }
        lines();
        //total
        System.out.println("Sum = " + findSum(totallist));
        lines();
        System.out.println("end of program");
        myScan.close();//scan close
    }// end main
    public static double findSum(double list[]){ //find total sum of numbers in the array
        double r = 0.;
        for(int i = 0; i<list.length; i++){
            r += list[i];
        }
        return r;
    }
    public static void lines(){
        System.out.println("---------------------------------------");
    }
}// end class data
