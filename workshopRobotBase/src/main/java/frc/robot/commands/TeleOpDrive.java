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
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        double rotation = Math.pow(controller.getRightX(), 3);
        double throttle = Math.pow(controller.getLeftY(),  3);
        if (Math.abs(rotation) <= 0.05) rotation = 0;
        if (Math.abs(throttle) <= 0.05) throttle = 0;
        drivetrain.arcadeDrive(rotation,throttle);
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
