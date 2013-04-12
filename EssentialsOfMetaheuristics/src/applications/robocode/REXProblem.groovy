package applications.robocode

import problems.TreeProblem;

/*
 *   id : an id used in the generation of the name of the class.
 *   enemy_energy : the coefficient for the enemy's energy
 *   my_energy : the coefficient for our energy
 *   angle_diff : the coefficient for the different in angles between us and the point and then and the point
 *   distance : the coefficient for the distance between the point and the enemy
 */

class REXProblem extends TreeProblem {
    def evalCount = 0
    def maxIterations = 0

    def functions = [

    ]

    def terminals = []

    def quality = {
        
    }

    def String toString(){
        "RoboCodeProblem"
    }
}
