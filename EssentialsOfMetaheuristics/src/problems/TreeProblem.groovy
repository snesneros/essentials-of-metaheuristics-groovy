package problems

import geneticProgram.FunctionArityPair;
import geneticProgram.TreeNode;

import java.util.Random;

class TreeProblem {

    Random rand = new Random()
    def maxDepth = 8
    def terminalProb = 0.5
    def tweakProb = 0.5

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
	
	def random = create

    def copy = {tree ->
        def newNode = tree.clone()
        newNode.children = []
        tree.children.each{child ->
            newNode.children.add(copy(child))
        }
        return newNode
    }

    def tweak = {tree ->
        def selector = rand.nextDouble()
        if(selector <= tweakProb) {
            pointMutate(tree)
        } else {
            mutate(tree)
        }
    }
    
	
    /*
     * Beyond MaxDepth, mutate will only generate terminals, potentially killing subtrees
     */
    def mutate = {oldTree, depth = rand.nextInt(oldTree.getTreeDepth()) ->
        def tree = copy(oldTree)
        def node = approachNode(tree, depth)
        def tempNode = makeTree(depth)
        node.value = tempNode.value
        node.arity = tempNode.arity
        node.valueString = tempNode.valueString
        node.children = tempNode.children
		tree
    }

    def pointMutate = {oldTree, depth = rand.nextInt(oldTree.getTreeDepth())->
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

    def crossover = {firstTree, secondTree, depthOne = rand.nextInt(firstTree.getTreeDepth()), depthTwo = rand.nextInt(secondTree.getTreeDepth()) ->
        def copyOne = copy(firstTree)
        def copyTwo = copy(secondTree)
        def subTreeOne = approachNode(copyOne, depthOne)
        def subTreeTwo = approachNode(copyTwo, depthTwo) 
        def tempNode = subTreeOne.clone()
        subTreeOne.children = subTreeTwo.children
        subTreeOne.arity = subTreeTwo.arity
        subTreeOne.value = subTreeTwo.value
        subTreeOne.valueString = subTreeTwo.valueString
        subTreeTwo.children = tempNode.children
        subTreeTwo.arity = tempNode.arity
        subTreeTwo.value = tempNode.value
        subTreeTwo.valueString = tempNode.valueString
        return [copyOne, copyTwo]        
    }
	
	def terminate = { a, q = quality(a) ->
		evalCount >= maxIterations
	}



}
