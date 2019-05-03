package data;

import java.util.*;

import launch.Main;


public class Converter {
    private Map<String, String> correspondences = new HashMap<>();

    public Converter(Map<String, String> correspondences) {
        this.correspondences = correspondences;
    }

    public List<String> sequencesToProteins(String sequence, Table table) {
        List<String> data = new ArrayList<>();
        if (sequence.length()%3 == 1){ sequence = sequence.substring(0, sequence.length()-1); }
        if (sequence.length()%3 == 2){ sequence = sequence.substring(0, sequence.length()-2); }
        for (int i = 0; i < sequence.length(); i += 3 ) {
            String parse = sequence.substring(i, i+3);
            data.add(table.getProteine(parse));
        }return data;
    }

    public List<List<String>> proteinsToSequence(String proteins, Table table) {
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < proteins.length(); i++ ) {
            data.add(table.getSequences(String.valueOf(proteins.charAt(i))));
        }return data;
    }

    public String getComplementary(String sequences, Table table) {
        String data = "";
        for (int i = 0; i < sequences.length(); i++) {
            data += table.getComplement(String.valueOf(sequences.charAt(i)));
        }return data;
    }
}
