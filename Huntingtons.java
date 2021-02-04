public class Huntingtons {
    public static int maxRepeats(String dna) {
        int n = dna.length(), max = 0, currentSequence = 0;
        int i = dna.indexOf("CAG");
        for (; i <= n-3; i += 3) {
            String codon = dna.substring(i, i + 3);
            if (codon.equals("CAG")) {
                currentSequence++;
                if (currentSequence > max) max = currentSequence;
            } else currentSequence = 0;
        }
        return max;
    }

    public static String removeWhitespace(String s) {
        return s.replace(" ", "").replace("\n", "").replace("\t", "");
    }

    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats >= 181) return "not human";
        if (maxRepeats <= 35) return "normal";
        if (maxRepeats <= 39) return "high risk";
        return "Huntington's";
    }

    public static void main(String[] args) {
        In geneFile = new In(args[0]);
        String seq = removeWhitespace(geneFile.readAll());
        int max = maxRepeats(seq);
        StdOut.println("max repeats = "+ max);
        StdOut.println(diagnose(max));
    }
}
