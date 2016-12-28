package ua.rozborsky.triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by roman on 28.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            try{
                System.out.println("Please insert number of row");

                String numberRow = bufferReader.readLine();
                int numberOfRow = Integer.valueOf(numberRow);

                System.out.println("\n" + numberOfRow + " row Pascal's triangle:");
                showRow(getRow(numberOfRow));
            } catch (IOException e) {
                System.out.println("cant read value\n");
            } catch (NumberFormatException e) {
                System.out.println("wrong format number\n");
            }
        }
    }


    private static long[] getRow(int numberOfRow) {
        long row[] = new long[numberOfRow + 1];

        for (int i = 1; i <= numberOfRow; i++) {
            row[i] = 0;
        }

        row[0] = 1;
        for (int j = 1; j <= numberOfRow; j++){
            for (int i = j; i >= 1; i--) {
                row[i] = row[i - 1] + row[i];
            }
        }

        return row;
    }


    private static void showRow(long [] row) {
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i] + "\t");
        }
        System.out.printf("\n\n");
    }
}