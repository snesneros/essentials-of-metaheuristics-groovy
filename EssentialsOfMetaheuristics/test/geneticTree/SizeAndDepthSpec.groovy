package geneticTree

import problems.TreeProblem;
import geneticProgram.TreeNode
import spock.lang.Specification
import TestTreeSuite

class SizeAndDepthSpec extends Specification{
    def "getDepth works correctly"(){
        given:
        def tts = new TestTreeSuite()
        
        when:
        def depth = tts.symTree.getTreeDepth()
        
        then:
        depth == 4
        
    }
    
    def "getSize works correctly"(){
        given:
        def tts = new TestTreeSuite()
        
        when:
        def bigness = tts.symTree.getTreeSize()
        
        then:
        bigness == 11
    }
}
