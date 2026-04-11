class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        List<Integer> lengths = new ArrayList<>();
        for (String str : strs) {
            sb.append(str.length()).append(",");
        }
        sb.append("#");
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        // System.out.println(str);
        List<Integer> lengths = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (str.charAt(i) != '#') {
            StringBuilder sb = new StringBuilder();
            while (str.charAt(j) != ',') {
                j++;
            }
            String length = str.substring(i, j);
            // System.out.println(length);
            lengths.add(Integer.valueOf(length));
            j++;
            i = j;
        }
        // i = index of '#'
        i++; 
        // i = first index of string
        
        
        StringBuilder sb = new StringBuilder();
        for (int length : lengths) {
            String s = str.substring(i, i + length);    
            result.add(s);
            i = i + length;
        }
        // StringBuilder sb = new StringBuilder();
        // s.substring(i, i + lengths.get(index));
        // while (i < str.length()) {
        //     int length = lengths.get(index);
            
        // }

        return result;
    }
}
