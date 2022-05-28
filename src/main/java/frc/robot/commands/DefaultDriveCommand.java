// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends CommandBase {
  //making instances of subsystems to allow for the this. function
  private DriveSubsystem DRIVE_SUBSYSTEM;
  private Joystick CONTROLLER;

  private double leftYAxis;
  private double rightXAxis;

  private SlewRateLimiter leftY=new SlewRateLimiter(2);
  private SlewRateLimiter rightX=new SlewRateLimiter(4);

  //makes joystick movements smoother, allows for coded in ramp up time
  
  /** Creates a new DefaultDriveCommand. */
  public DefaultDriveCommand(DriveSubsystem drive, Joystick controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    //passing in the things needed in the class
    this.DRIVE_SUBSYSTEM=drive;
    this.CONTROLLER=controller;

    //requiring drive subsystem to be unused by any other thing to be able to be used in this
    addRequirements(DRIVE_SUBSYSTEM);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    leftYAxis=0;
    rightXAxis=0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //tank drive
    leftYAxis=CONTROLLER.getRawAxis(1); //left y axis
    rightXAxis=CONTROLLER.getRawAxis(2); //right x axis

    DRIVE_SUBSYSTEM.set(leftY.calculate(leftYAxis), rightX.calculate(rightXAxis));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DRIVE_SUBSYSTEM.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
