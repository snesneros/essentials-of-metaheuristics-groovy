package geneticTree

import java.awt.GraphicsConfiguration.DefaultBufferCapabilities;

import problems.TreeProblem;
import geneticProgram.TreeNode
import spock.lang.Specification
import TestTreeSuite

class MutateAndCopySpec extends Specification{
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
    
    def "pointMutate returns a different point... sometimes"(){
        given:
        def tts = new TestTreeSuite()
        def prob = new TreeProblem()
        
        when:
        def mutantTree = prob.pointMutate(tts.symTree)
        
        then:
        tts.symTree.toString() != mutantTree.toString()
        
    }
    
    def "Mutate returns a different subtree... most of the time"(){
        given:
        def tts = new TestTreeSuite()
        def prob = new TreeProblem()
        
        when:
        def mutantTree = prob.mutate(tts.symTree)
        
        then:
        tts.symTree.toString() != mutantTree.toString()
        
    }
}
