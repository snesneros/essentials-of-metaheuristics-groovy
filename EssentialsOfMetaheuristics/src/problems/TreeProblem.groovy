package problems

import geneticProgram.FunctionArityPair;
import geneticProgram.TreeNode;

import java.util.Random;

class TreeProblem {

    Random rand = new Random()
    def maxDepth = 2
    def terminalProb = 0.2
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

    def copy = {tree ->
        def newNode = tree.clone()
        newNode.children = []
        tree.children.each{child ->
            newNode.children.add(copy(child))
        }
        return newNode
    }

    def tweak = {tree, individual ->
        def selector = rand.nextDouble()
        def result = [:]
        if(selector <= tweakProb) {
            result['id'] = individual+1
            result['runTree'] = pointMutate(tree['runTree'])
            result['run'] = result['runTree'].evaluate()
            result['onHitWallTree'] = pointMutate(tree['onHitWallTree'])
            result['onHitWall'] = result['onHitWallTree'].evaluate()
            result['onScannedRobotTree'] = pointMutate(tree['onScannedRobotTree'])
            result['onScannedRobot'] = result['onScannedRobotTree'].evaluate()
            result['onHitRobotTree'] = pointMutate(tree['onHitRobotTree'])
            result['onHitRobot'] = result['onHitRobotTree'].evaluate()
            result['onBulletHitTree'] = pointMutate(tree['onBulletHitTree'])
            result['onBulletHit'] = result['onBulletHitTree'].evaluate()
            result['onBulletMissedTree'] = pointMutate(tree['onBulletMissedTree'])
            result['onBulletMissed'] = result['onBulletMissedTree'].evaluate()
            result['onHitByBulletTree'] = pointMutate(tree['onHitByBulletTree'])
            result['onHitByBullet'] = result['onHitByBulletTree'].evaluate()
            result
        } else {
            result['id'] = individual+1
            result['runTree'] = mutate(tree['runTree'])
            result['run'] = result['runTree'].evaluate()
            result['onHitWallTree'] = mutate(tree['onHitWallTree'])
            result['onHitWall'] = result['onHitWallTree'].evaluate()
            result['onScannedRobotTree'] = mutate(tree['onScannedRobotTree'])
            result['onScannedRobot'] = result['onScannedRobotTree'].evaluate()
            result['onHitRobotTree'] = mutate(tree['onHitRobotTree'])
            result['onHitRobot'] = result['onHitRobotTree'].evaluate()
            result['onBulletHitTree'] = mutate(tree['onBulletHitTree'])
            result['onBulletHit'] = result['onBulletHitTree'].evaluate()
            result['onBulletMissedTree'] = mutate(tree['onBulletMissedTree'])
            result['onBulletMissed'] = result['onBulletMissedTree'].evaluate()
            result['onHitByBulletTree'] = mutate(tree['onHitByBulletTree'])
            result['onHitByBullet'] = result['onHitByBulletTree'].evaluate()
            result
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

    def crossover = {tree1, tree2, individual ->
        def result1 = [:]
        def result2 = [:]
        result1['id'] = individual+1
        result2['id'] = individual+2
        
        def run = crossoverHelper(tree1['runTree'], tree2['runTree'])
        def onHitWall = crossoverHelper(tree1['onHitWallTree'], tree2['onHitWallTree'])
        def onScannedRobot = crossoverHelper(tree1['onScannedRobotTree'], tree2['onScannedRobotTree'])
        def onHitRobot = crossoverHelper(tree1['onHitRobotTree'], tree2['onHitRobotTree'])
        def onBulletHit = crossoverHelper(tree1['onBulletHitTree'], tree2['onBulletHitTree'])
        def onBulletMissed = crossoverHelper(tree1['onBulletMissedTree'], tree2['onBulletMissedTree'])
        def onHitByBullet =  crossoverHelper(tree1['onHitByBulletTree'], tree2['onHitByBulletTree'])
        
        result1['runTree'] = run[0]
        result1['run'] = run[0].evaluate()
        result1['onHitWallTree'] = onHitWall[0]
        result1['onHitWall'] = onHitWall[0].evaluate()
        result1['onScannedRobotTree'] = onScannedRobot[0]
        result1['onScannedRobot'] = onScannedRobot[0].evaluate()
        result1['onHitRobotTree'] = onHitRobot[0]
        result1['onHitRobot'] = onHitRobot[0].evaluate()
        result1['onBulletHitTree'] = onBulletHit[0]
        result1['onBulletHit'] = onBulletHit[0].evaluate()
        result1['onBulletMissedTree'] = onBulletMissed[0]
        result1['onBulletMissed'] = onBulletMissed[0].evaluate()
        result1['onHitByBulletTree'] = onHitByBullet[0]
        result1['onHitByBullet'] = onHitByBullet[0].evaluate()
        
        result2['runTree'] = run[1]
        result2['run'] = run[1].evaluate()
        result2['onHitWallTree'] = onHitWall[1]
        result2['onHitWall'] = onHitWall[1].evaluate()
        result2['onScannedRobotTree'] = onScannedRobot[1]
        result2['onScannedRobot'] = onScannedRobot[1].evaluate()
        result2['onHitRobotTree'] = onHitRobot[1]
        result2['onHitRobot'] = onHitRobot[1].evaluate()
        result2['onBulletHitTree'] = onBulletHit[1]
        result2['onBulletHit'] = onBulletHit[1].evaluate()
        result2['onBulletMissedTree'] = onBulletMissed[1]
        result2['onBulletMissed'] = onBulletMissed[1].evaluate()
        result2['onHitByBulletTree'] = onHitByBullet[1]
        result2['onHitByBullet'] = onHitByBullet[1].evaluate()

        return [result1, result2]
    }

    def crossoverHelper = {firstTree, secondTree, depthOne = rand.nextInt(firstTree.getTreeDepth()), depthTwo = rand.nextInt(secondTree.getTreeDepth()) ->
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
