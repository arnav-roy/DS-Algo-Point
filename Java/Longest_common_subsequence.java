/*To find the longest common subsequence between two substrings*/
package longest_common_subsequence;

import java.util.Scanner;

public class Longest_common_subsequence {

    static void LCS(String str1, String str2, int x, int y) {

        int X[][] = new int[x + 1][y + 1];
        int index, temp;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {

                if (i == 0 || j == 0) {
                    X[i][j] = 0;
                } else if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
                    X[i][j] = X[i - 1][j - 1] + 1;
                } else {
                    X[i][j] = max(X[i - 1][j], X[i][j - 1]);

                }
            }
        }

        index = X[x][y];
        temp = index;
        char lcs[] = new char[index + 1];
        lcs[index] = '\0';
        int i = x;
        int j = y;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs[index - 1] = str1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (X[i - 1][j] > X[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.print("The Longest common subsequence is ");
        {
            for (int k = 0; k < temp; k++) {
                System.out.print(lcs[k]);
            }
        }
    }

    static int max(int x1, int y1) {
        if (x1 > y1) {
            return x1;
        } else {
            return y1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Longest_common_subsequence lcs = new Longest_common_subsequence();
        System.out.println("Enter string 1: ");
        String str1 = sc.next();
        System.out.println("Enter string 2: ");
        String str2 = sc.next();
        int x = str1.length();
        int y = str2.length();

        LCS(str1, str2, x, y);

    }

}
/*
Enter string 1: 
abaaba
Enter string 2: 
aababa
The Longest common subsequence is  aaaba
Time complexity : O(n^2)
   Space complexity : O(n^2)
*/
