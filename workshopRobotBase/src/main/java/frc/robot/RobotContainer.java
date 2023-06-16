package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer { // Contains the robot

    public final XboxController controller = new XboxController(0); // controller port 0
    public final Drivetrain drivetrain = new Drivetrain(controller); // Drivetrain object using controller
    // public final Elevator...

    public RobotContainer() { // constructor
        //drivetrain.setDefaultCommand(new Teleop());
    }


    public Command getAutonomousCommand() {
        return null; // TODO: return real Command Object
    }
    
}
