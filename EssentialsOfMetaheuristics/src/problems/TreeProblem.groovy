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
        def newNode = tree.clone()
        newNode.children = []
        tree.children.each{child ->
            newNode.children.add(copy(child))
        }
        return newNode
    }

    def mutate = {tree ->
        //TODO: randomize a subtree
    }

    def pointMutate = {tree, depth = rand.nextInt(tree.getTreeDepth())->
        def node = tree
        if(tree.arity != 0) {
            node = approachNode(tree.children[rand.nextInt(tree.children.size())], depth--)
        }
        if(node.arity == 0){
            node.value = terminals[rand.nextInt(terminals.size())]
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

    def crossover = {firstTree, SecondTree ->

    }



}
