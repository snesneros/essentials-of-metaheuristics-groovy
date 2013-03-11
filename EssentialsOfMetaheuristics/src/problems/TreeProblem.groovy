package problems

import geneticProgram.FunctionArityPair;
import geneticProgram.TreeNode;

import java.util.Random;

class TreeProblem {

    Random rand = new Random()
    def maxDepth = 8
    def terminalProb = 0.5

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

    def makeTree(currentDepth){
        def tempNode
        def selector = rand.nextDouble()
        if(selector <= terminalProb || currentDepth >= maxDepth) {
            def index = rand.nextInt(terminals.size())
            tempNode = new TreeNode(value : terminals[index](), arity : 0);
        } else {
            def index = rand.nextInt(functions.size())
            tempNode = new TreeNode(value : functions[index].function, arity : functions[index].arity, valueString : functions[index].string);
        }
        tempNode.arity.times {
            tempNode.children.add(makeTree(currentDepth++))
        }
        return tempNode
    }

    def create = {->
        def index = rand.nextInt(functions.size())
        def tempNode = new TreeNode(value : functions[index].function, arity : functions[index].arity, valueString : functions[index].string);
        tempNode.arity.times {
            tempNode.children.add(makeTree(1))
        }
        return tempNode
    }

    def copy = {tree ->
        def newNode = tree.clone()
        newNode.children = []
        tree.children.each{child ->
            newNode.children.add(copy(child))
        }
        return newNode
    }

    /*
     * Beyond MaxDepth, mutate will only generate terminals, potentially killing subtrees
     */
    def mutate = {oldTree, depth = rand.nextInt(tree.getTreeDepth()) ->
        def tree = copy(oldTree)
        def node = approachNode(tree, depth)
        def tempNode = makeTree(depth)
        node.value = tempNode.value
        node.arity = tempNode.arity
        node.valueString = tempNode.valueString
        node.children = tempNode.children
    }

    def pointMutate = {oldTree, depth = rand.nextInt(tree.getTreeDepth())->
        def tree = copy(oldTree)
        def node = approachNode(tree, depth)
        if(node.arity == 0){
            node.value = terminals[rand.nextInt(terminals.size())]()
            node.valueString = node.value
        }else{
            def candidates = functions.findAll() {it.arity == node.arity}
            def replacement = candidates[rand.nextInt(candidates.size())]
            node.value = replacement.function
            node.valueString = replacement.string
        }
        return tree
    }

    def approachNode = {node, depth ->
        if(depth == 0 || node.arity == 0) {
            return node
        } else {
            approachNode(node.children[rand.nextInt(node.children.size())], depth--)
        }
    }

    def crossover = {firstTree, secondTree ->
        def copyOne = copy(firstTree)
        def copyTwo= copy(secondTree)
        def subTreeOne = null
        def subTreeTwo = null 
    }



}
