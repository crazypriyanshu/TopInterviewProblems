package org.pdas.a;

public class Charter {
    public static void main(String[] args) {




    }

    private static int eval(Expression e){
        return switch (e){
            case Const(int val) -> val;
            case Add(Expression e1, Expression e2) -> eval(e1)+eval(e2);
            case Sub(Expression e1, Expression e2) -> eval(e1)-eval(e2);
            case Mul(Expression e1, Expression e2) -> eval(e1)*eval(e2);
        };
    }
}
