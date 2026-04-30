package org.pdas.a;
record X(int x, String name){}
abstract class ClassA {
    X ClassA(){
        var ans = new X(1, "AA");
        System.out.println(" "+ans.x()+" name:"+ans.name());
        return ans;
    }
}
