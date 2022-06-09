// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.AutoTurn;
import frc.robot.subsystems.DriveSubsystem;

public class Turn90Auton extends SequentialCommandGroup {
  /** Creates a new Turn90Auton. */
  public static double getTime(int degrees){
    return degrees*(1.0/90.0);
  }

  public Turn90Auton(DriveSubsystem DRIVE_SUBSYSTEM) {
    addCommands(
      //new AutoDrive(DRIVE_SUBSYSTEM, 0, 0.6035).withTimeout(1)
      new AutoTurn(DRIVE_SUBSYSTEM, 90)
    );
  }
}
