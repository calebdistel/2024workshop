package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoSpot2 extends CommandBase {
    private static final Drivetrain drivetrain = Drivetrain.getInstance(); 

    private Timer timer = new Timer();

    public AutoSpot2() {
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        timer.reset(); //zeros the timers
        timer.start(); //starts the timer
    }
    @Override
    public void execute() {
        drivetrain.arcadeDrive(0, -.2); //start the robot
    }
    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0); //stops the robot
    }
    @Override
    public boolean isFinished() {
        return timer.get()>=5; //ends the command after 5 seconds
    }
}
