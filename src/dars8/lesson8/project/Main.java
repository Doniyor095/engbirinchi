package dars8.lesson8.project;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String matn = "Bu eng! ! # %  kop ishlatsa1  123 boladigan so'zlar bular qanday murakkab";

        String[] sozlar = matn.split("[^\\p{L}0-9']+");
        String[] sozlar1 = matn.split("\\s+");
        String[] sozlar3 = matn.split("\\W+");

        System.out.println(Arrays.toString(sozlar));
        System.out.println(Arrays.toString(sozlar1));
        System.out.println(Arrays.toString(sozlar3));
    }
}