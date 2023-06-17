package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoSpot2;
import frc.robot.commands.AutoSpot3;
import frc.robot.commands.TeleOpDrive;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer { // Contains the robot

    public final static XboxController controller = new XboxController(0); // controller port 0
    public static final Drivetrain drivetrain = Drivetrain.getInstance(); // Drivetrain object using controller
    // public final Elevator...

    public RobotContainer() { // constructor
        drivetrain.setDefaultCommand(new TeleOpDrive()); // Use teleop drive as default command
    }


    public Command getAutonomousCommand() {
        return new AutoSpot3(); 
    }
    
}
