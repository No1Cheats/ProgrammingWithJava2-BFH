package ObjectDesign;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int t = 0; t<n; t++){
            String s = scanner.next();
            list.add(s);
        }
        for (int i = 0; i<list.size(); i++){
            String first = "";
            String last = "";
            for(int j = 0; j<list.get(i).length();j++){
                if(j % 2 == 0){
                    first = first + list.get(i).charAt(j);
                } else {
                    last = last + list.get(i).charAt(j);
                }
            }
            System.out.println(first + " " + last);
        }
    }
}
