package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：CK
 * @date ：Created in 2021/1/18 10:37
 * @description：
 */
public class No721 {
    //暴力解法，错了，不知道为什么无法去重
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        UFS ufs = new UFS(accounts.size());
        for (int i = 0 ; i < accounts.size() ; i ++){
            for (int j = i + 1 ; j < accounts.size() ; j ++){
                if (ufs.find(j) == j && same(accounts.get(i),accounts.get(j))){
                    ufs.union(i, j);
                    accounts.get(i).addAll(accounts.get(j));
                    accounts.set(i,accounts.get(i).stream().distinct().collect(Collectors.toList()));
                }
            }
        }
        for (int i = 0 ; i < accounts.size() ; i ++){
            if (ufs.find(i) == i){
                Collections.sort(accounts.get(i));
                result.add(accounts.get(i));
            }
        }
        return result;
    }

    public boolean same(List<String> x , List<String> y){
        for (int i = 1 ; i < x.size() ; i ++){
            String a = x.get(i);
            if (y.contains(a)){
                return true;
            }
        }
        return false;
    }
    public class UFS {
        public int[] parent;
        public UFS(int len){
            parent = new int[len];
            for (int i = 0 ; i < len ; i ++){
                parent[i] = i;
            }
        }

        public int find(int x){
            return parent[x] == x ? x : find(parent[x]);
        }

        public void union(int x, int y){
            parent[find(y)] = find(x);
        }
    }

    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UFS uf = new UFS(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}

