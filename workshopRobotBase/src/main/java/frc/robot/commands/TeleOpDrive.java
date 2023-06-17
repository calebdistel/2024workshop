package frc.robot.commands;

import java.sql.Driver;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class TeleOpDrive extends CommandBase {

    private static final Drivetrain drivetrain = Drivetrain.getInstance(); 
    private static final XboxController controller = RobotContainer.controller;

    public TeleOpDrive() {
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(controller.getRightX(), controller.getLeftY()); //move robot using controller input
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0); //stop moving
    }

    @Override
    public boolean isFinished() {
        return false; //don't end
    }
}
