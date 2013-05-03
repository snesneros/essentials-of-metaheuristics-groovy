package experiments
import problems.*
import populationMethods.*
import applications.robocode.*

class REXRunner {

    static runExperiment(searcher, problem, numRuns = 100) {
        for (i in 0..<numRuns) {
            problem.evalCount = 0
            def result = searcher.maximize(problem)
            println "${searcher.toString()}\t${problem.toString()}\t${problem.quality(result)}\t${result}"
        }
    }

    static main(args) {
        def problem = new REXProblem()
        def searcher = new MuPlusLambdaForTrees()
        runExperiment(searcher, problem)
        System.out.println(problem.fitnesses)
    }
}
