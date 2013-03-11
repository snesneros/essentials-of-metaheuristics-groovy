package geneticTree

import problems.TreeProblem;
import geneticProgram.TreeNode
import spock.lang.Specification
import TestTreeSuite

class pointMutationSpec extends Specification{
    def "copy works correctly"(){
        given:
        def tts = new TestTreeSuite()
        def prob = new TreeProblem()  
        
        when:
        def copyTree = prob.copy(tts.symTree)
        
        then:
        tts.symTree.toString() == copyTree.toString()
        tts.symTree != copyTree
        
    }
    
    def "pointMutate works"(){
        given:
        def tts = new TestTreeSuite()
        def prob = new TreeProblem()
        
        when:
        def copyTree = prob.copy(tts.symTree)
        prob.pointMutate(copyTree)
        
        then:
        tts.symTree.toString() != copyTree.toString()
        
    }
}
