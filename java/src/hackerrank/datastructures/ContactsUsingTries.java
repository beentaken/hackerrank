package hackerrank.datastructures;

import java.util.HashMap;
import java.util.Map;

public class ContactsUsingTries {

    public static class Node {

        private Map<Character, Node> children = new HashMap<>();
        private int numChildren = 0;

        public void add(String str) {
            if (str.length() == 0) {
                return;
            }

            char c = str.charAt(0);

            if (!children.containsKey(c)) {
                children.put(c, new Node());
            }

            numChildren++;
            children.get(c).add(str.substring(1));
        }
    }


    public static void main(String[] args) {

        Node trie = new Node();

        for (String contact : new String[]{"Bob", "Mark", "Michael", "Mandy"}) {

            trie.add(contact);

        }

        System.out.println(trie);

    }

}
