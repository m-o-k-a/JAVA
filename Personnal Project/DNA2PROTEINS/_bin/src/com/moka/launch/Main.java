package com.moka.launch;

import com.moka.data.Converter;
import com.moka.data.Table;

import java.util.*;

public class Main {
    /*
    Create Map f(Sequences) -> Proteins
    */
    static Table reference = new Table();
    static Map<String, String> correspondences = reference.getCorrespondences();
    static Converter converter = new Converter(correspondences);

    public static void main(String[] args) {
        /*
            Launch Application
         */
        System.out.println("MOKA'S DNA TO PROTEINS CONVERTER V 0.1\n");
        boolean toContinue = true;
        Scanner reader = new Scanner(System.in);
        while (toContinue) {
            int value;
            String data;
            System.out.println("1 - CONVERT NUCLEOTIDES SEQUENCES TO PROTEINS\n2 - CONVERT PROTEINS TO ALL THE POSSIBLES NUCLEOTIDES SEQUENCES\n3 - GET THE COMPLEMENTARY OF NUCLEOTIDES SEQUENCES\n0 - EXIT\n\n>>>");
            value  = Integer.parseInt(reader.nextLine());
            switch (value) {
                case 1:
                    System.out.println("CONVERT NUCLEOTIDES SEQUENCES TO PROTEINS\nWrite a nucleotides sequences a get the proteins it code\n>>>");
                    data = reader.nextLine().toUpperCase();
                    System.out.println("RESULTS:\n"+converter.sequencesToProteins(data, reference)+"\n\n");
                    break;
                case 2:
                    System.out.println("CONVERT PROTEINS TO ALL THE POSSIBLES NUCLEOTIDES SEQUENCE\nWrite a proteins sequences a get the nucleotides sequences possibilities that the protein can code\n>>>");
                    data = reader.nextLine().toUpperCase();
                    System.out.println("RESULTS:\n"+converter.proteinsToSequence(data, reference)+"\n\n");
                    break;
                case 3:
                    System.out.println("GET THE COMPLEMENTARY OF NUCLEOTIDES SEQUENCES\nWrite a nucleotides sequences a get its complementary\n>>>");
                    data = reader.nextLine().toUpperCase();
                    System.out.println("RESULTS:\n"+converter.getComplementary(data, reference)+"\n\n");
                    break;
                case 0:
                    toContinue = !toContinue;
                    break;
                default:
                    System.out.println("ERROR 01 - WRONG VALUE");
                    break;
            }
        }
    }
}
