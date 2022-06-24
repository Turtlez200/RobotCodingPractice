// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class AutoTurnGyro extends CommandBase {
  /** Creates a new AutoGyro. */
  GyroSubsystem GYRO_SUBSYSTEM;
  DriveSubsystem DRIVE_SUBSYSTEM;

  int Degree;
  boolean finished;
  int coefficient;
  double speed;

  public AutoTurnGyro(GyroSubsystem g, DriveSubsystem d, int deg) {
    GYRO_SUBSYSTEM = g;
    DRIVE_SUBSYSTEM = d;
    Degree = deg;
    finished = false;
    addRequirements(GYRO_SUBSYSTEM);
    addRequirements(DRIVE_SUBSYSTEM);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    GYRO_SUBSYSTEM.resetHeading();
    if (Degree >= 0)
      coefficient = 1;
    else
      coefficient = -1;
    Degree = Math.abs(Degree);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (GYRO_SUBSYSTEM.getHeading() >= Degree)
      finished = true;
    else {
      speed = Math.max((Degree - GYRO_SUBSYSTEM.getHeading()) * (0.6 / Degree), 0.2);
      DRIVE_SUBSYSTEM.set(0, -speed * coefficient);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
