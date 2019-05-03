package data;

import java.util.*;

public class Table {
    private Map<String, String> correspondences = new HashMap<>();
    private Map<String, String> complementary = new HashMap<>();


    public Map<String, String> getCorrespondences() { return correspondences; }
    public Map<String, String> getComplementary() { return complementary; }

    public String getTable() {
        String data = "";
        for (Map.Entry<String, String> link : correspondences.entrySet()) {
            data += link.getKey()+" : "+link.getValue()+"\n";
        }
        return  data;
    }

    public List<String> getSequences(String proteine) {
            List<String> data = new ArrayList<>();
            for (Map.Entry<String, String> link : correspondences.entrySet()) {
                if (link.getValue().equals(proteine)) {
                    data.add(link.getKey());
                }
            }return  data;
    }


    public String getProteine(String sequence) {
        for (Map.Entry<String, String> link : correspondences.entrySet()) {
            if (link.getKey().equals(sequence)) {
                return  link.getValue();
            }
        }return null;
    }

    public String getComplement(String nucleotide) {
        for (Map.Entry<String, String> link : complementary.entrySet()) {
            if (link.getKey().equals(nucleotide)) {
                return link.getValue();
            }
        }return  null;
    }

    public Table() {
        /*
            BUILD UP TABLE
         */
        correspondences.put("CGA","R");
        correspondences.put("GCA","G");
        correspondences.put("GTC","V");
        correspondences.put("GGC","G");
        correspondences.put("TGC","C");
        correspondences.put("CTG","L");
        correspondences.put("CTC","L");
        correspondences.put("CGC","R");
        correspondences.put("CGG","R");
        correspondences.put("AAC","N");
        correspondences.put("GCC","A");
        correspondences.put("ATT","I");
        correspondences.put("AGG","R");
        correspondences.put("GAC","D");
        correspondences.put("ACC","T");
        correspondences.put("AGC","S");
        correspondences.put("TAC","Y");
        correspondences.put("ACA","T");
        correspondences.put("AAG","K");
        correspondences.put("GCA","A");
        correspondences.put("TTG","L");
        correspondences.put("CCC","P");
        correspondences.put("CTT","L");
        correspondences.put("TGG","W");
        correspondences.put("ATG","M");
        correspondences.put("GCG","A");
        correspondences.put("TCA","S");
        correspondences.put("GAA","E");
        correspondences.put("GGG","G");
        correspondences.put("GGT","G");
        correspondences.put("AAA","K");
        correspondences.put("GAG","E");
        correspondences.put("ATT","N");
        correspondences.put("CTA","L");
        correspondences.put("CAT","H");
        correspondences.put("TCG","S");
        correspondences.put("GTG","V");
        correspondences.put("TAT","Y");
        correspondences.put("CCT","P");
        correspondences.put("ACT","T");
        correspondences.put("TCC","S");
        correspondences.put("CAG","Q");
        correspondences.put("CCA","P");
        correspondences.put("AGA","R");
        correspondences.put("ACG","T");
        correspondences.put("CAA","Q");
        correspondences.put("TGT","C");
        correspondences.put("GCT","A");
        correspondences.put("TTC","F");
        correspondences.put("AGT","S");
        correspondences.put("ATA","I");
        correspondences.put("ITA","L");
        correspondences.put("CCG","P");
        correspondences.put("ATC","I");
        correspondences.put("TTT","F");
        correspondences.put("CGT","R");
        correspondences.put("TGA","V");
        correspondences.put("TCT","S");
        correspondences.put("CAC","H");
        correspondences.put("GTT","V");
        correspondences.put("GAT","D");
        correspondences.put("TAA","STOP");
        correspondences.put("TAG","STOP");
        /*
            BUILD UP COMPLEMENTARY
         */
        complementary.put("A","T");
        complementary.put("C","G");
        complementary.put("G","C");
        complementary.put("T","A");
    }
}
