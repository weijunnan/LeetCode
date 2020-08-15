import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        startTime = System.nanoTime();

        Trie trie = new Trie();
        for(String word: words)
            trie.add(word);

        for(String word: words)
            trie.contains(word);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;

        System.out.println("Total different words: " + trie.getSize());
        System.out.println("Trie: " + time + " s");
    }
}
