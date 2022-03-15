import java.util.Arrays;
import java.util.List;

public class TrieImpl {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("a","abc","b","cd");
        TrieImpl impl = new TrieImpl();
        boolean yes = impl.wordBreak("abcd", words);
        System.out.print(yes);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int i=0;
        while(i<s.length()) {
            for (int j=i; j<s.length();j++) {
                if (wordDict.contains(s.substring(i, j+1))) {
                    i = j+1;
                }
            }
        }
        return i==s.length();
    }
}

class Trie {

    static class Node {
        Node[] childrens = new Node[26];
        boolean endsHere;
    }

    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String s) {
        Node index = root;
        for (Character c:s.toCharArray()) {
            int i = c - 'a';
            if (index.childrens[i] != null) {
                index = index.childrens[i];
            } else {
                index.childrens[i] = new Node();
                index = index.childrens[i];
            }
        }
        index.endsHere = true;
    }

    public boolean search(String s) {
        Node index = root;
        for (Character c:s.toCharArray()) {
            int i = c - 'a';
            if (index.childrens[i] == null) {
                return false;
            }
            index = index.childrens[i];
        }
        return index.endsHere;
    }

    public boolean startsWith(String s) {
        Node index = root;
        for (Character c:s.toCharArray()) {
            int i = c - 'a';
            if (index.childrens[i] == null) {
                return false;
            }
            index = index.childrens[i];
        }
        return true;
    }
}

