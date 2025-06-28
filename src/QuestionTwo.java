import java.util.Arrays;

public class QuestionTwo {
        public static void main(String[] args) {
            String[] words = {"I", "love", "dynamic", "programming"};
            int L = 15;
            int greedyPenalty = greedyPenalty(words, L);
            System.out.println("Penalty using greedy: " + greedyPenalty);

            int dpPenalty = minimizePenalty(words, L);
            System.out.println("Penalty using dynamic programming: " + dpPenalty);
        }

        public static int greedyPenalty(String[] words, int L) {
            int penalty = 0;
            int K = 0;
            for (String word : words) {
                int wordLen = word.length();
                if (K == 0) {
                    K = wordLen;
                } else if (K + 1 + wordLen <= L) {
                    K += 1 + wordLen;
                } else {
                    penalty += (L - K);
                    K = wordLen;
                }
            }
            penalty += (L - K);
            return penalty;
        }


        public static int minimizePenalty(String[] words, int L) {
            int n = words.length;
            int[] wordLengths = new int[n];
            for (int i = 0; i < n; i++) wordLengths[i] = words[i].length();

            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[n] = 0;

            for (int i = n - 1; i >= 0; i--) {
                int lineLength = 0;
                for (int j = i; j < n; j++) {
                    lineLength += wordLengths[j];
                    if (j > i) lineLength++;
                    if (lineLength > L) break;
                    int penalty = L - lineLength + dp[j + 1];
                    dp[i] = Math.min(dp[i], penalty);
                }
            }
            return dp[0];
        }

}
