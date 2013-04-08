package populationMethods

import problems.OnesMax
import utility.GenomeFitnessPair;

class MuCommaLambdaForTrees {
	Integer numParents = 5
	Integer numChildren = 20

	def maximize(problem){
		assert numParents > 0 && numChildren >0, "numParents and numChildren must be positive"
		assert numChildren%numParents == 0, "numChildren must be a multiple of numParents"
		def childArr = []
		numChildren.times{
			def candidateSolution = problem.random()
			childArr.add(new GenomeFitnessPair(genome:candidateSolution,fitness:problem.quality(candidateSolution)))
		}
		def best = new GenomeFitnessPair(genome: childArr[0].genome, fitness:childArr[0].fitness)

		while(!problem.terminate(best.genome, best.fitness)){ //while best is not ideal and we have time
			childArr.sort()
			if (childArr[0].fitness > best.fitness) {
				best = childArr[0]
			}
			def parentList = []
			numParents.times{i->
				parentList.add(childArr[i])
			}
			
			for (i in 0..<numParents/2) {
				def crossovers = problem.crossover(parentList[i*2].genome, parentList[(i*2)+1].genome)
				parentList.add(new GenomeFitnessPair(genome: crossovers[0], fitness: problem.quality(crossovers[0])))
				parentList.add(new GenomeFitnessPair(genome: crossovers[1], fitness: problem.quality(crossovers[1])))
			}
			
			parentList = parentList.sort()[0..<numParents]
			
			childArr= []
			for(parent in parentList){
				(numChildren/numParents).times{
					def nextSolution = problem.tweak(parent.genome)
					childArr.add(new GenomeFitnessPair(genome:nextSolution, fitness:problem.quality(nextSolution)))
				}
			}
		}
		return best.genome
	}

	String toString(){
		"(" + numParents+","+numChildren+")Evo"
	}
}