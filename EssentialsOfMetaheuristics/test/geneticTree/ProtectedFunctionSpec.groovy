package geneticTree

import java.awt.GraphicsConfiguration.DefaultBufferCapabilities;

import problems.SymbolicRegression;
import geneticProgram.TreeNode
import spock.lang.Specification
import TestTreeSuite


class ProtectedFunctionSpec extends Specification {

	def "Protected Division returns one on x/0"(){
		given:
		def tts = new TestTreeSuite()

		when:
		def division = tts.protectDivide.function

		then:
		division([3,0]) == 1

	}

	def "Protected Log returns one if input is 0 or less"(){
		given:
		def tts = new TestTreeSuite()

		when:
		def logarithm = tts.protectLog.function

		then:
		logarithm([0]) == 1
		logarithm([-1]) == 1

	}

}
