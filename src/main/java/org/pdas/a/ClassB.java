package org.pdas.a;

public class ClassB extends ClassA{
    X ClassB(){
        var ans = new X(2, "BB");
        System.out.println(" "+ans.x()+" name:"+ans.name());
        return ans;
    }
    public void getNumber(Integer integer, String name){}
    public void getNumber(String name, int... integer){}
    public void getNumber(Long integer, String name){}
    public void getNumber(long integer, String name){}

}
