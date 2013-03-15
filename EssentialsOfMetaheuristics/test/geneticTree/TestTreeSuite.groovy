package geneticTree

import geneticProgram.*

class TestTreeSuite {

    def add = new FunctionArityPair(function : {array -> array[0] + array[1]}, arity : 2, string : "+")
    def subtract = new FunctionArityPair(function : {array -> array[0] - array[1]}, arity : 2, string : "-")
    def multi = new FunctionArityPair(function : {array -> array[0]*array[1]}, arity : 2, string: "*")
    def divide = new FunctionArityPair(function : {array -> array[0]/array[1]}, arity : 2, string : "/")
    def cosine = new FunctionArityPair(function : {array -> Math.cos(array[0])}, arity : 1, string : "cos")
    def sine = new FunctionArityPair(function : {array -> Math.sin(array[0])}, arity : 1, string : "sin")
    def log = new FunctionArityPair(function : {array -> Math.log(array[0])}, arity :1, string: "log")

    def terminals = [ "x", "y", "z", 7, 2, 13]

    
    def node1 = new TreeNode(value : 13, arity : 0)
    def node2 = new TreeNode(value : "z", arity : 0)
    def node3 = new TreeNode(value : "y", arity : 0)
    def node4 = new TreeNode(value : 2, arity : 0)
    def node5 = new TreeNode(value : add.function, arity : 2, children : [node1, node2], valueString : add.string)
    def node6 = new TreeNode(value : divide.function, arity : 2, children : [node3, node4], valueString : divide.string)
    def node7 = new TreeNode(value : 7, arity : 0)
    def node8 = new TreeNode(value : "x", arity : 0)
    def node9 = new TreeNode(value : multi.function, arity : 2, children : [node5, node7], valueString : multi.string)
    def node10 = new TreeNode(value : subtract.function, arity : 2, children : [node6, node8], valueString: subtract.string)
    def symTree = new TreeNode(value : add.function, arity : 2, children : [node9, node10], valueString : add.string)
    //symTree: ((13+z)*7)+(x-(y/2))
}
