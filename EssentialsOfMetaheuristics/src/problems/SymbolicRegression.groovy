package problems

import geneticProgram.FunctionArityPair;
import geneticProgram.TreeNode;

class SymbolicRegression extends TreeProblem {

    def functions = [
        def add = new FunctionArityPair(function : {array -> array[0] + array[1]}, arity : 2, string : "+"),
        def subtract = new FunctionArityPair(function : {array -> array[0] - array[1]}, arity : 2, string : "-"),
        def multi = new FunctionArityPair(function : {array -> array[0]*array[1]}, arity : 2, string: "*"),
        def divide = new FunctionArityPair(function : {array -> array[0]/array[1]}, arity : 2, string : "/"),
        def cosine = new FunctionArityPair(function : {array -> Math.cos(array[0])}, arity : 1, string : "cos"),
        def sine = new FunctionArityPair(function : {array -> Math.sin(array[0])}, arity : 1, string : "sin"),
        def log = new FunctionArityPair(function : {array -> Math.log(array[0])}, arity :1, string: "log")
    ]

    def terminals = [ {-> "x"}, {-> "y"}, {-> "z"}, {-> 5}, {-> 10}, {-> 32}, {-> rand.nextInt()}]

}
