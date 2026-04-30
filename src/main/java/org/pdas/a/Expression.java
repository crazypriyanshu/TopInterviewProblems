package org.pdas.a;

record Const(int val) implements Expression{};
record Add(Expression e1, Expression e2) implements Expression{};
record Sub(Expression e1, Expression e2) implements Expression{};
record Mul(Expression e1, Expression e2) implements Expression{};


sealed interface Expression {

}


