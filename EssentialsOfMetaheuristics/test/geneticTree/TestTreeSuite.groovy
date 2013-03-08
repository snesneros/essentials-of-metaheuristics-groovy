package geneticTree

import geneticProgram.*

class TestTreeSuite {

    def add = new FunctionArityPair(function : {array -> array[0] + array[1]}, arity : 2)
    def subtract = new FunctionArityPair(function : {array -> array[0] - array[1]}, arity : 2)
    def multi = new FunctionArityPair(function : {array -> array[0]*array[1]}, arity : 2)
    def divide = new FunctionArityPair(function : {array -> array[0]/array[1]}, arity : 2)
    def cosine = new FunctionArityPair(function : {array -> Math.cos(array[0])}, arity : 1)
    def sine = new FunctionArityPair(function : {array -> Math.sin(array[0])}, arity : 1)
    def log = new FunctionArityPair(function : {array -> Math.log(array[0])}, arity :1)

    def terminals = [ "x", "y", "z", 7, 2, 13]

    
    def node1 = new TreeNode(value : 13, arity : 0)
    def node2 = new TreeNode(value : "z", arity : 0)
    def node3 = new TreeNode(value : "y", arity : 0)
    def node4 = new TreeNode(value : 2, arity : 0)
    def node5 = new TreeNode(value : add, arity : 2, children : [node1, node2])
    def node6 = new TreeNode(value : divide, arity : 2, children : [node3, node4])
    def node7 = new TreeNode(value : 7, arity : 0)
    def node8 = new TreeNode(value : "x", arity : 0)
    def node9 = new TreeNode(value : multi, arity : 2, children : [node5, node7])
    def node10 = new TreeNode(value : subtract, arity : 2, children : [node6, node8])
    def symTree = new TreeNode(value : add, arity : 2, children : [node9, node10])
    //symTree: ((13+z)*7)+(x-(y/2))
}
