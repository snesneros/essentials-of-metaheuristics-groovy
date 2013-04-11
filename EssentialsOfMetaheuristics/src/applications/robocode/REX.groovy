package applications.robocode;

import robocode.*;
import robocode.control.events.BattleStartedEvent
import java.awt.*;

public class REX extends AdvancedRobot {

    def width;
    def height;
    def energy;
    def gunHeading;
    def gunHeat;
    def heading;
    def numOpponents;
    def radarHeading;
    def xCoord;
    def yCoord;

    public void run() {
        setBodyColor(new Color(0, 216, 240));
        setGunColor(new Color(255, 255, 255));
        setRadarColor(new Color(255, 255, 255));
        setBulletColor(new Color(0, 216, 240));
        setScanColor(new Color(0, 216, 240));

        while (true) {

        }
    }
    
    public void onBattleStarted(BattleStartedEvent event) {
        numOpponents = event.getRobotsCount() - 1;
        BattleRules rules = event.getBattleRules();
        width = rules.getBattlefieldWidth();
        height = rules.getBattlefieldHeight();
    }
    
    //This method is called when your robot collides with a wall.
    public void onHitWall(HitWallEvent e) {
        
    }

    //This method is called when your robot sees another robot, i.e. when the robot's radar scan "hits" another robot.
    public void onScannedRobot(ScannedRobotEvent e) {

    }

    //This method is called when your robot collides with another robot.
    public void onHitRobot(HitRobotEvent e) {

    }

    //This method is called when one of your bullets hits another robot.
    public void onBulletHit(BulletHitEvent event) {

    }

    //This method is called when one of your bullets misses, i.e. hits a wall.
    public void onBulletMissed(BulletMissedEvent event) {

    }

    //This method is called when your robot is hit by a bullet.
    public void onHitByBullet(HitByBulletEvent event) {

    }

    //This method is called every turn in a battle round in order to provide
    //the robot status as a complete snapshot of the robot's current state at that specific time.
    public void onStatus(StatusEvent event) {
        RobotStatus stat = StatusEvent.getStatus();
        //Returns the robot's current energy.
        energy = stat.getEnergy();
        //Returns the direction that the robot's gun is facing, in degrees.
        gunHeading = stat.getGunHeading();
        //Returns the current heat of the gun.
        gunHeat = stat.getGunHeat();
        //Returns the direction that the robot's body is facing, in degrees.
        heading = stat.getHeading();
        //Returns how many opponents that are left in the current round.
        numOpponents = stat.getOthers();
        //Returns the direction that the robot's radar is facing, in degrees.
        radarHeading = stat.getRadarHeading();
        //Returns the X position of the robot. (0,0) is at the bottom left of the battlefield.
        xCoord = stat.getX();
        //Returns the Y position of the robot. (0,0) is at the bottom left of the battlefield.
        yCoord = stat.getY();
    }

}