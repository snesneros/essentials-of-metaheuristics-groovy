package geneticTree

import problems.TreeProblem;
import geneticProgram.TreeNode
import spock.lang.Specification
import TestTreeSuite

class CrossoverSpec extends Specification{
    def "crossover works correctly"(){
        given:
        def tts = new TestTreeSuite()
        def prob = new TreeProblem()

        when:
        def (newTreeOne, newTreeTwo) = prob.crossover(tts.symTree, tts.symTree)

        then:
        newTreeOne.toString() != newTreeTwo.toString() != tts.symTree.toString()
    }
}