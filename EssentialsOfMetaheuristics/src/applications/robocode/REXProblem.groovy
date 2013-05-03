package applications.robocode

import geneticProgram.FunctionArityPair
import geneticProgram.TreeNode
import problems.TreeProblem;

class REXProblem extends TreeProblem {
    Integer individualCount = 0
    def evalCount = 0
    def maxIterations = 1000
    def fitnesses = [:]

    RobotBuilder robotBuilder = new RobotBuilder("templates/REX.template")
    BattleRunner battleRunner = new BattleRunner("templates/battle.template")

    def width = "width"
    def height = "height"
    def energy = "energy"
    def gunHeading = "gunHeading"
    def gunHeat = "gunHeat"
    def heading = "heading"
    def radarHeading = "radarHeading"
    def xCoord = "xCoord"
    def yCoord = "yCoord"
    def enemyBearing = "enemyBearing"
    def enemyDistance = "enemyDistance"
    def enemyEnergy = "enemyEnergy"
    def enemyHeading = "enemyHeading"
    def enemyVelocity = "enemyVelocity"
    def rando = {param -> rand.nextInt(param)}

    def setAheadIf = {->
        def secondaryTerminals = [
            width,
            height,
            energy,
            gunHeading,
            gunHeat,
            heading,
            radarHeading,
            xCoord,
            yCoord,
            enemyBearing,
            enemyDistance,
            enemyEnergy,
            enemyHeading,
            enemyVelocity,
            rando(600)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        def num2 = rand.nextInt(secondaryTerminals.size())
        def num3 = rand.nextInt(secondaryTerminals.size())
        "if(" + secondaryTerminals[num1] + "<" + secondaryTerminals[num2] + ") {setAhead(" + secondaryTerminals[num3] + ");}"
    }

    def setAhead = {->
        def secondaryTerminals = [
            width,
            height,
//            energy,
//            gunHeading,
//            gunHeat,
//            heading,
//            radarHeading,
            xCoord,
            yCoord,
//            enemyBearing,
//            enemyDistance,
//            enemyEnergy,
//            enemyHeading,
//            enemyVelocity,
            rando(600)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        "setAhead(" + secondaryTerminals[num1] + ");"
    }

    def setBackIf = {->
        def secondaryTerminals = [
            width,
            height,
            energy,
            gunHeading,
            gunHeat,
            heading,
            radarHeading,
            xCoord,
            yCoord,
            enemyBearing,
            enemyDistance,
            enemyEnergy,
            enemyHeading,
            enemyVelocity,
            rando(600)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        def num2 = rand.nextInt(secondaryTerminals.size())
        def num3 = rand.nextInt(secondaryTerminals.size())
        "if(" + secondaryTerminals[num1] + "<" + secondaryTerminals[num2] + ") {setBack(" + secondaryTerminals[num3] + ");}"
    }

    def setBack = {->
        def secondaryTerminals = [
            width,
            height,
//            energy,
//            gunHeading,
//            gunHeat,
//            heading,
//            radarHeading,
            xCoord,
            yCoord,
//            enemyBearing,
//            enemyDistance,
//            enemyEnergy,
//            enemyHeading,
//            enemyVelocity,
            rando(600)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        "setBack(" + secondaryTerminals[num1] + ");"
    }

    def setFireIf = {->
        def secondaryTerminals = [
            width,
            height,
            energy,
            gunHeading,
            gunHeat,
            heading,
            radarHeading,
            xCoord,
            yCoord,
            enemyBearing,
            enemyDistance,
            enemyEnergy,
            enemyHeading,
            enemyVelocity,
            rando(100)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        def num2 = rand.nextInt(secondaryTerminals.size())
        def num3 = rand.nextInt(secondaryTerminals.size())
        "if(" + secondaryTerminals[num1] + "<" + secondaryTerminals[num2] + ") {setFire(" + secondaryTerminals[num3] + ");}"
    }

    def setFire = {->
        def secondaryTerminals = [
//            width,
//            height,
//            energy,
//            gunHeading,
//            gunHeat,
//            heading,
//            radarHeading,
//            xCoord,
//            yCoord,
//            enemyBearing,
//            enemyDistance,
//            enemyEnergy,
//            enemyHeading,
//            enemyVelocity,
            rando(100)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        "setFire(" + secondaryTerminals[num1] + ");"
    }

    def setTurnGunLeftIf = {->
        def secondaryTerminals = [
            width,
            height,
            energy,
            gunHeading,
            gunHeat,
            heading,
            radarHeading,
            xCoord,
            yCoord,
            enemyBearing,
            enemyDistance,
            enemyEnergy,
            enemyHeading,
            enemyVelocity,
            rando(360)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        def num2 = rand.nextInt(secondaryTerminals.size())
        def num3 = rand.nextInt(secondaryTerminals.size())
        "if(" + secondaryTerminals[num1] + "<" + secondaryTerminals[num2] + ") {setTurnGunLeft(" + secondaryTerminals[num3] + ");}"
    }

    def setTurnGunLeft = {->
        def secondaryTerminals = [
//            width,
//            height,
//            energy,
//            gunHeading,
//            gunHeat,
//            heading,
//            radarHeading,
//            xCoord,
//            yCoord,
//            enemyBearing,
//            enemyDistance,
//            enemyEnergy,
//            enemyHeading,
//            enemyVelocity,
            rando(360)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        "setTurnGunLeft(" + secondaryTerminals[num1] + ");"
    }

    def setTurnGunRightIf = {->
        def secondaryTerminals = [
            width,
            height,
            energy,
            gunHeading,
            gunHeat,
            heading,
            radarHeading,
            xCoord,
            yCoord,
            enemyBearing,
            enemyDistance,
            enemyEnergy,
            enemyHeading,
            enemyVelocity,
            rando(360)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        def num2 = rand.nextInt(secondaryTerminals.size())
        def num3 = rand.nextInt(secondaryTerminals.size())
        "if(" + secondaryTerminals[num1] + "<" + secondaryTerminals[num2] + ") {setTurnGunRight(" + secondaryTerminals[num3] + ");}"
    }

    def setTurnGunRight = {->
        def secondaryTerminals = [
//            width,
//            height,
//            energy,
//            gunHeading,
//            gunHeat,
//            heading,
//            radarHeading,
//            xCoord,
//            yCoord,
//            enemyBearing,
//            enemyDistance,
//            enemyEnergy,
//            enemyHeading,
//            enemyVelocity,
            rando(360)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        "setTurnGunRight(" + secondaryTerminals[num1] + ");"
    }

    def setTurnRadarLeftIf = {->
        def secondaryTerminals = [
            width,
            height,
            energy,
            gunHeading,
            gunHeat,
            heading,
            radarHeading,
            xCoord,
            yCoord,
            enemyBearing,
            enemyDistance,
            enemyEnergy,
            enemyHeading,
            enemyVelocity,
            rando(360)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        def num2 = rand.nextInt(secondaryTerminals.size())
        def num3 = rand.nextInt(secondaryTerminals.size())
        "if(" + secondaryTerminals[num1] + "<" + secondaryTerminals[num2] + ") {setTurnRadarLeft(" + secondaryTerminals[num3] + ");}"
    }

    def setTurnRadarLeft = {->
        def secondaryTerminals = [
//            width,
//            height,
//            energy,
//            gunHeading,
//            gunHeat,
//            heading,
//            radarHeading,
//            xCoord,
//            yCoord,
//            enemyBearing,
//            enemyDistance,
//            enemyEnergy,
//            enemyHeading,
//            enemyVelocity,
            rando(360)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        "setTurnRadarLeft(" + secondaryTerminals[num1] + ");"
    }

    def setTurnRadarRightIf = {->
        def secondaryTerminals = [
            width,
            height,
            energy,
            gunHeading,
            gunHeat,
            heading,
            radarHeading,
            xCoord,
            yCoord,
            enemyBearing,
            enemyDistance,
            enemyEnergy,
            enemyHeading,
            enemyVelocity,
            rando(360)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        def num2 = rand.nextInt(secondaryTerminals.size())
        def num3 = rand.nextInt(secondaryTerminals.size())
        "if(" + secondaryTerminals[num1] + "<" + secondaryTerminals[num2] + ") {setTurnRadarRight(" + secondaryTerminals[num3] + ");}"
    }

    def setTurnRadarRight = {->
        def secondaryTerminals = [
//            width,
//            height,
//            energy,
//            gunHeading,
//            gunHeat,
//            heading,
//            radarHeading,
//            xCoord,
//            yCoord,
//            enemyBearing,
//            enemyDistance,
//            enemyEnergy,
//            enemyHeading,
//            enemyVelocity,
            rando(360)
        ]
        def num1 = rand.nextInt(secondaryTerminals.size())
        "setTurnRadarRight(" + secondaryTerminals[num1] + ");"
    }

    def functions = [
        def add = new FunctionArityPair(function : {array -> array[0] + array[1]}, arity : 2, string : "+")
    ]

    def terminals = [
        setAheadIf,
        setAhead,
        setBackIf,
        setBack,
        setFireIf,
        setFire,
        setTurnGunLeftIf,
        setTurnGunLeft,
        setTurnGunRightIf,
        setTurnGunRight,
        setTurnRadarLeftIf,
        setTurnRadarLeft,
        setTurnRadarRightIf,
        setTurnRadarRight,
    ]

    def random = {->
        System.out.println("Creating")
        ++individualCount
        def run = create()
        def onHitWall = create()
        def onScannedRobot = create()
        def onHitRobot = create()
        def onBulletHit = create()
        def onBulletMissed = create()
        def onHitByBullet = create()
        System.out.println("Created")
        [
                    'id' : individualCount,
                    'run' : run.evaluate(),
                    'onHitWall' : onHitWall.evaluate(),
                    'onScannedRobot' : onScannedRobot.evaluate(),
                    'onHitRobot' : onHitRobot.evaluate(),
                    'onBulletHit' : onBulletHit.evaluate(),
                    'onBulletMissed' : onBulletMissed.evaluate(),
                    'onHitByBullet' : onHitByBullet.evaluate(),
                    'runTree' : run,
                    'onHitWallTree' : onHitWall,
                    'onScannedRobotTree' : onScannedRobot,
                    'onHitRobotTree' : onHitRobot,
                    'onBulletHitTree' : onBulletHit,
                    'onBulletMissedTree' : onBulletMissed,
                    'onHitByBulletTree' : onHitByBullet
                ]
    }

    def quality = {individual ->
        System.out.println("Getting Quality")
        ++evalCount
        robotBuilder.buildJarFile(individual)
        System.out.println("gotHere")
        battleRunner.buildBattleFile(individual['id'])
        System.out.println("gotHere2")
        def score = battleRunner.runBattle(individual['id'])
        fitnesses[individual['id']] = score
        System.out.println(score)
        return score
    }

    def String toString(){
        "RoboCodeProblem"
    }
}
