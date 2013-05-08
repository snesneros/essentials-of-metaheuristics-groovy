package experiments
import problems.*
import populationMethods.*
import applications.robocode.*

class REXRunner {

    static runExperiment(searcher, problem) {
        problem.evalCount = 0
        def result = searcher.maximize(problem)
    }

    static main(args) {
        def problem = new REXProblem()
        def searcher = new MuPlusLambdaForTrees()
        runExperiment(searcher, problem)
        System.out.println(problem.fitnesses)
    }
}
