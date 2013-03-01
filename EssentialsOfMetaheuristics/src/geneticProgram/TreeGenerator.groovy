package geneticProgram

import java.util.Random;

class TreeGenerator {

    Random rand = new Random()
    def numNodes = 100
    def maxDepth = Math.log(numNodes)/Math.log(2)
    def arityCounter = 0
    
    def functions = [
        def add = new FunctionArityPair(function : {array -> array[0] + array[1]}, arity : 2),
        def subtract = new FunctionArityPair(function : {array -> array[0] - array[1]}, arity : 2),
        def multi = new FunctionArityPair(function : {array -> array[0]*array[1]}, arity : 2),
        def divide = new FunctionArityPair(function : {array -> array[0]/array[1]}, arity : 2),
        def cosine = new FunctionArityPair(function : {array -> Math.cos(array[0])}, arity : 1),
        def sine = new FunctionArityPair(function : {array -> Math.sin(array[0])}, arity : 1),
        def log = new FunctionArityPair(function : {array -> Math.log(array[0])}, arity :1)
    ]
    
    def terminals
    
    def makeTree(currentDepth){
        //TODO: make checks for depth of current tree, make sure arityCounter is less than numNodes
        def index = rand.nextInt(functions.size())
        def tempNode = new TreeNode(function : functions[index].function, arity : functions[index].arity);
        arityCounter += root.arity
        tempNode.arity.times {
            tempNode.children.add(makeTree())
        }
        return tempNode
    }

}
