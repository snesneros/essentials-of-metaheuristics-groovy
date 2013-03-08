package problems

import geneticProgram.FunctionArityPair;
import geneticProgram.TreeNode;

import java.util.Random;

class TreeProblem {

    Random rand = new Random()
    def maxDepth = 20
    def terminalProb = 0.5

    def functions = [
        def add = new FunctionArityPair(function : {array -> array[0] + array[1]}, arity : 2),
        def subtract = new FunctionArityPair(function : {array -> array[0] - array[1]}, arity : 2),
        def multi = new FunctionArityPair(function : {array -> array[0]*array[1]}, arity : 2),
        def divide = new FunctionArityPair(function : {array -> array[0]/array[1]}, arity : 2),
        def cosine = new FunctionArityPair(function : {array -> Math.cos(array[0])}, arity : 1),
        def sine = new FunctionArityPair(function : {array -> Math.sin(array[0])}, arity : 1),
        def log = new FunctionArityPair(function : {array -> Math.log(array[0])}, arity :1)
    ]

    def terminals = [ "x", "y", "z", 5, 10, 32, rand.nextInt()]

    def makeTree(currentDepth){
        def tempNode
        def selector = rand.nextDouble()
        if(selector <= terminalProb || currentDepth == maxDepth) {
            def index = rand.nextInt(terminals.size())
            tempNode = new TreeNode(value : terminals[index], arity : 0);
        } else {
            def index = rand.nextInt(functions.size())
            tempNode = new TreeNode(value : functions[index].function, arity : functions[index].arity);
        }
        tempNode.arity.times {
            tempNode.children.add(makeTree(currentDepth++))
        }
        return tempNode
    }
    
    def create = {->
        def index = rand.nextInt(functions.size())
        def tempNode = new TreeNode(value : functions[index].function, arity : functions[index].arity);
        tempNode.arity.times {
            tempNode.children.add(makeTree(1))
        }
        return tempNode
    }
    
    def copy = {tree ->
        //TODO: turn this into a thing
    }
    
    def mutate = {tree ->
        //TODO: randomize a subtree
    }
    
    def pointMutate = {node ->
        //TODO: randomize a node
    }
    
    def crossover = {firstTree, SecondTree ->
        
    }

    

}
