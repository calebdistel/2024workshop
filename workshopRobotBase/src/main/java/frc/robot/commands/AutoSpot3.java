package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoSpot3 extends CommandBase {
    private static final Drivetrain drivetrain = Drivetrain.getInstance(); 


    public AutoSpot3() {
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.resetEncoders();
        drivetrain.resetPID();
    }
    @Override
    public void execute() {
        drivetrain.drive(drivetrain.calculatePID(5)); //start the robot
    }
    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0); //stops the robot
        drivetrain.resetPID();
    }
    @Override
    public boolean isFinished() {
        return Math.abs(drivetrain.getRightDistance()) >= 10;
    }
}
