package geneticProgram

import java.util.Random;

class TreeGenerator {

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
            tempNode.children.add(makeTree())
        }
        return tempNode
    }

    def getTreeSize(root){ //this is really terrible and we should figure out a better way to do it.
        1 + root.children.each{child ->
            getTreeSize(child)
        }
    }

}
