package io.github.fabasoad.collections.tree234;// tree234.java
// demonstrates 234 tree
// to run this program: C>java Tree234App

import java.io.*;                 // for I/O
import java.lang.Integer;         // for parseInt()

////////////////////////////////////////////////////////////////
class Tree234App {
    public static void main(String[] args) throws IOException {
        double value;
        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        while (true) {
            putText("Enter first letter of ");
            putText("show, insert, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    putText("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    putText("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found != -1)
                        System.out.println("Found " + value);
                    else
                        System.out.println("Could not find " + value);
                    break;
                default:
                    putText("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()

    //--------------------------------------------------------------
    public static void putText(String s) {
        System.out.print(s);
        System.out.flush();
    }

    //--------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    //--------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------
}  // end class Tree234App
