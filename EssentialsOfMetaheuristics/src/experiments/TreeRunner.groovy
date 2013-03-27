package experiments

import problems.SymbolicRegression
import operators.Crossovers
import populationMethods.GeneticAlgorithm
import utility.RandomGenerator

class TreeRunner {

    static runExperiment(searchers, problems, numRuns = 30) {
        for (p in problems) {
            for (s in searchers) {
                for (i in 0..<numRuns) {
                    p.evalCount = 0
                    def result = s.maximize(p)
                    println "${s.toString()}\t${p.toString()}\t${p.quality(result)}\t${result}"
                }
            }
        }
    }

    static main(args) {
		def problem = new SymbolicRegression(terminals : [{-> "x"}, {-> RandomGenerator.nextInt()}])
        def searchers = [
            new GeneticAlgorithm(crossover : problem.crossover)
        ]
        def problems = [
           problem
        ]
		
        runExperiment(searchers, problems)
    }

}
