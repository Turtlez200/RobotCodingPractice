// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDrive extends CommandBase {

  private DriveSubsystem DRIVE_SUBSYSTEM;
  private double verticalSpeed, horizontalSpeed;
  
  /** Creates a new AutoDrive. */
  public AutoDrive(DriveSubsystem drive, double v, double h) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
    verticalSpeed=v;
    horizontalSpeed=h;
    DRIVE_SUBSYSTEM=drive;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DRIVE_SUBSYSTEM.set(verticalSpeed, horizontalSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DRIVE_SUBSYSTEM.set(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
