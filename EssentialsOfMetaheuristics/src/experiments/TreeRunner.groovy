package experiments

import problems.SymbolicRegression
import operators.Crossovers
import populationMethods.GeneticAlgorithm
import populationMethods.MuCommaLambdaForTrees
import populationMethods.MuPlusLambdaForTrees
import utility.RandomGenerator

class TreeRunner {

    static runExperiment(searchers, problems, numRuns = 10) {
		def file = new File("trees.txt")
        for (p in problems) {
            for (s in searchers) {
                for (i in 0..<numRuns) {
                    p.evalCount = 0
                    def result = s.maximize(p)
                    println "${s.toString()}\t${p.toString()}\t${p.quality(result)}\t${result}"
					file << "${s.toString()}\t${p.toString()}\t${p.quality(result)}\n"
                }
            }
        }
    }

    static main(args) {
//        def problem = new SymbolicRegression(terminals : [{-> "x"}, {-> "y"}, {-> "z"}, {-> RandomGenerator.nextInt()}], problemFunction : {vars-> ((13+vars.getAt('z'))*7)+(vars.getAt('x')-(vars.getAt('y')/2))},
//        testPoints : [[ 'x' : 1, 'y' : 1, 'z' : 1], ['x' : 2, 'y' : 2, 'z' : 2], ['x' : 3, 'y' : 3, 'z' : 3], ['x' : 4, 'y' : 4, 'z' : 4], ['x' : 5, 'y' : 5, 'z' : 5]])
        
        def problem = new SymbolicRegression()
        def searchers = [
            new GeneticAlgorithm(crossover : problem.crossover),
			new MuPlusLambdaForTrees(),
			new MuCommaLambdaForTrees()
        ]
        def problems = [
            problem
        ]

        runExperiment(searchers, problems)
    }

}
