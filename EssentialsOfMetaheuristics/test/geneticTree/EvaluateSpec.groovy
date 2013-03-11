package geneticTree

import problems.TreeProblem;
import geneticProgram.TreeNode
import spock.lang.Specification
import TestTreeSuite

class EvaluateSpec extends Specification{
    def "evaluate works correctly"(){
       given:
       def tts = new TestTreeSuite()
       def map = [ 'x' : 1, 'y' : 2, 'z' : 3]
       
       
       when:
       def result = tts.symTree.evaluate(map)
       
       then:
       result == 112       
    }
}