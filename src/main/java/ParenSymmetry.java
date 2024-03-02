package src.main.java;
import java.io.File; //Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner; // Import the Scanner class to read text files.
public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        // implement this method
        char openParen = '(';
        char closeParen = ')';
        int countOpenParen = 0;
        int countCloseParen = 0;
        Boolean val = false;

        for (int i = 0; i< s.length(); i++)
        {
            if (s.charAt(i) == openParen)
            {
                countOpenParen++;
            }
            else if (s.charAt(i) == closeParen)
            {
                countCloseParen++;
            }
        }

        if (countOpenParen == countCloseParen)
        {
           val = true;
        }
        return val;
    }

    private void checkFile(String filename) {
        // open file named filename
        String output = "";

        try {
            File myFile1 = new File(filename);
            Scanner myReader = new Scanner(myFile1);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                output = output + isBalanced(data).toString() + ", ";
            }
            myReader.close();
            System.out.println(output);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();
        System.out.println("\nOutput from file - TestStrings0.txt");
        ps.checkFile("TestStrings0.txt");
        System.out.println("\nOutput from file - TestStrings1.txt");
        ps.checkFile("TestStrings1.txt");
        /*
        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);
        */
    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
