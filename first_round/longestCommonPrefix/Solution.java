package longestCommonPrefix;

import java.util.*;
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (null == strs || strs.length == 0) {
        	return "";
        }
        Trie trie = new Trie(strs);
        TrieNode lastNode = trie.getRoot();
        if (lastNode.hasEmpty) {
        	return "";
        }
        StringBuffer sb = new StringBuffer();
        while (lastNode != null) {
        	if (lastNode.isTerminated()) {
        		break;
        	}
        	List<TrieNode> children = lastNode.getChildren();
        	if (children.size() ==  1) {
        		char firstChar = children.get(0).getChar();
        		sb.append(firstChar);
        		lastNode = lastNode.getChild(firstChar);
        	} else {
        		break;
        	}
        }
        return sb.toString();
    }
    
    class TrieNode {
        private List<TrieNode> children;
        private char ch;
        boolean terminated;
        boolean hasEmpty;
        TrieNode() {
            children = new ArrayList<TrieNode>();
            terminated = false;
            hasEmpty = false;
        }
        
        TrieNode(char c) {
            this();
            this.ch = c;
        }
        
        public List<TrieNode> getChildren() {
        	return children;
        }
        
        public TrieNode getChild(char c) {
            for (TrieNode node : children) {
                if (node.ch == c) {
                    return node;
                }
            }
            return null;
        }
        
        public char getChar() {
            return ch;
        }
        
        public void setTerminated(boolean t) {
            terminated = t;
        }
        
        public boolean isTerminated() {
        	return terminated;
        }
        
        public void addWord(String word) {
        	if (null == word) {// || word.isEmpty()) {
                return;
            }
        	if (word.isEmpty()) {
        		hasEmpty = true;
        		return;
        	}
        	
            TrieNode child = null;
            char firstChar = word.charAt(0);
            TrieNode first = getChild(firstChar);
            if (first == null) {
                child = new TrieNode(firstChar);
                children.add(child);
            } else {
                child = first;
            }
            if (word.length() > 1) {
                child.addWord(word.substring(1));
            } else {
                child.setTerminated(true);
            }
        }
    }
    
    class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public Trie(String s) {
            this();
            root.addWord(s);
        }
        
        public Trie(List<String> list) {
            this();
            if (list != null)
            for (String s: list) {
                root.addWord(s);
            }
        }
        
        public Trie(String[] array) {
            this();
            if (null != array) {
                for (String s: array) {
                    root.addWord(s);
                }
            }
        }
        
        public TrieNode getRoot() {
            return root;
        }
        
        public boolean contains(String s, boolean exact) {
            if (s == null || s.isEmpty()) {
                return false;
            }
            TrieNode lastNode = root;
            for (int i = 0; i < s.length(); i++) {
                lastNode = lastNode.getChild(s.charAt(i));
                if (lastNode == null) {
                    return false;
                }
            }
            return !exact || lastNode.terminated;
        }
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		String[] strs = {"ab", "aa"};
		String result = test.longestCommonPrefix(strs);
		System.out.println(result);
	}
}
