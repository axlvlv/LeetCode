/*
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

Show Company Tags
Show Tags
/*

/*
Method
如果 a 不认识任何人，不代表a是名人。
如果 a 不被任何人认识，不代表a是名人
只有当a不认识任何人，并且，a被任何人认识，a才是名人

如果a 认识 b， a不可能是名人
如果a不认识b，b不可能是名人
/*

public class Solution extends Relation {
    public int findCelebrity(int n) {
        //base case
        if(n <= 0){
            return -1;
        }
        if(n == 1){
            return 0;
        }
        
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i)){
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i != candidate && knows(candidate, i) ||!knows(i, candidate)){
                return -1;
            }
        }
        return candidate;
    }
}
