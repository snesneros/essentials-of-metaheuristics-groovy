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
    
    def "problemFunction works correctly"(){
        given:
        def problemFunction = {vars-> ((13+vars.getAt('z'))*7)+(vars.getAt('x')-(vars.getAt('y')/2))}
        def map = [ 'x' : 1, 'y' : 2, 'z' : 3]
        
        when:
        def result = problemFunction(map)
        
        then:
        result == 112
    }
    def "quality works correctly"(){
        given:
        def tts = new TestTreeSuite()
        def map = [[ 'x' : 1, 'y' : 1, 'z' : 1], ['x' : 2, 'y' : 2, 'z' : 2], ['x' : 3, 'y' : 3, 'z' : 3], ['x' : 4, 'y' : 4, 'z' : 4], ['x' : 5, 'y' : 5, 'z' : 5]]
        def problemFunction = {vars-> ((13+vars.getAt('z'))*7)+(vars.getAt('x')-(vars.getAt('y')/2))}

        when:
        def qual = 0
        map.each{vars ->
            qual += (tts.symTree.evaluate(vars) - problemFunction(vars))**2
        }

        then:
        qual == 0
    }
}