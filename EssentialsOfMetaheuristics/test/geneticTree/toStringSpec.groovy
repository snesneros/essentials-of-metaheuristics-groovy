package geneticTree

import problems.TreeProblem;
import geneticProgram.TreeNode
import spock.lang.Specification
import TestTreeSuite

class toStringSpec extends Specification{
    def "toString works correctly"(){
        given:
        def tts = new TestTreeSuite()
        
        when:
        def result = tts.symTree.toString()
        
        then:
        result == ""
        
    }
}
