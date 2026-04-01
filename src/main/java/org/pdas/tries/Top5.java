package org.pdas.tries;

import java.util.ArrayList;
import java.util.List;

public class Top5 {
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        List<Integer> top5 = new ArrayList<>();
        boolean isWord = false;
    }


}
