package problems

import geneticProgram.FunctionArityPair;
import geneticProgram.TreeNode;

class SymbolicRegression extends TreeProblem {

	def evalCount = 0
	def maxIterations = 1000

	def problemFunction = {vars-> Math.sin(vars.getAt('x')^2)}

	def functions = [
		def add = new FunctionArityPair(function : {array -> array[0] + array[1]}, arity : 2, string : "+"),
		def subtract = new FunctionArityPair(function : {array -> array[0] - array[1]}, arity : 2, string : "-"),
		def multi = new FunctionArityPair(function : {array -> array[0]*array[1]}, arity : 2, string: "*"),
		def divide = new FunctionArityPair(function : {array ->
			if(array[1] <= 0){
				return 1
			}else{array[0]/array[1]}}, arity : 2, string : "/"),
		def cosine = new FunctionArityPair(function : {array -> Math.cos(array[0])}, arity : 1, string : "cos"),
		def sine = new FunctionArityPair(function : {array -> Math.sin(array[0])}, arity : 1, string : "sin"),
		def log = new FunctionArityPair(function : {array ->
			if(array[0] <= 0){
				return 1
			}else{Math.log(array[0])}}, arity :1, string: "log")
	]

	def terminals = [ {-> "x"}, {-> 5}, {-> 10}, {-> 32}, {-> rand.nextInt()}]

	def testPoints =[['x' : 2], ['x':3], ['x':4],['x':5],['x':6],['x':7],['x':8],['x':9],['x':10]]

	def quality = {a ->
		evalCount++
		def qual = 0
		testPoints.each{vars ->
			qual += (a.evaluate(vars) - problemFunction(vars))**2
		}
		0 - qual //invert, to make problem a maximization
	}

	def String toString(){
		"SymbReg:Sin(x^2)"
	}
}
