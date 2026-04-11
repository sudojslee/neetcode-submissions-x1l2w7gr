// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();

        int i = 0;
        while (i < pairs.size()) {
            Pair pair = pairs.get(i);

            // loop through sorted (left)
            for (int j = 0; j < i; j++) {
                Pair sorted = pairs.get(j);
                if (pair.key < sorted.key) {
                    // insert to jth position
                    pairs.remove(pair);
                    pairs.add(j, pair);
                    break;
                } 
            }

            result.add(new ArrayList<>(pairs));
            i++;
        }
        return result;

    }
}
