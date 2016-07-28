class StringPatternMatch {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */

    // for KMP
    private int[][] dfa;


    public static void main(String[] args){
        String source = "bbbbbbbe";
        String target = "be";
        int pos = 6;
        System.out.println(strStr(source, target));
        source = "abcde";
        target = "xyz";
        System.out.println(strStr(source, target));
        source = "source";
        target = "rced";
        System.out.println(strStr(source, target));
        source = "source";
        target = "target";
        StringPatternMatch match = new StringPatternMatch();
        match.contructDFA(target);
        System.out.println(match.strStrKMP(source, target));
        // for (int[] oneState: match.dfa){
        //     for (int oneChar: oneState){
        //         System.out.print(oneChar + " ");
        //     }
        //     System.out.println("");
        // }
    }

    // this is the brute-force implementation
    // and it takes me quite a long time
    // because we have to consider some corner cases
    // null and ""
    // we only need to compare from source.charAt(0) to souce.charAt(source.length() - target.length())
    // later, this implementation is modified based on CS1501 slides, to make it more concise and have two loops
    // O(m * n) worst case
    public static int strStr(String source, String target) {
        if (source == null || target == null){
            return -1;
        }
        if (target.equals("")){
            return 0;
        }
        int m = source.length();
        int n = target.length();
        for (int i = 0; i < m - n + 1; i++){
            int j;
            for (j = 0; j < n; j++){
                if (source.charAt(i + j) != target.charAt(j)){
                    break;
                }
            }
            if (j == n){
                return i;
            }
        }
        return -1;
    }

    // this is the KMP implementation
    // we have to understand how KMP works
    // it only has to do one pass, no back up
    // because we have modeled the pattern, so we know where to start after a mismatch

    public int strStrKMP(String source, String target){
        if (source == null || target == null){
            return -1;
        }
        if (target == ""){
            return 0;
        }
        int m = source.length();
        int n = target.length();
        int i, j;
        for (i = 0, j = 0; i < m && j < n; i++){
            j = dfa[source.charAt(i)][j];
        }
        if (j == n){
            return i - n;
        }
        return -1;
    }

    // the most difficult part of KMP:
    public void contructsDFA(String target){
        int n = target.length();
        this.dfa = new int[256][n];
        dfa[target.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < n; j++){
            for (int c = 0; c < 256; c++){
                dfa[c][j] = dfa[c][x];
            }
            dfa[target.charAt(j)][j] = j + 1;
            x = dfa[target.charAt(j)][x];
        }
    }
}
//http://www.lintcode.com/en/problem/strstr/#
