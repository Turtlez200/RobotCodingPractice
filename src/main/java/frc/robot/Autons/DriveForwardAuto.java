// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardAuto extends SequentialCommandGroup {
  /** Creates a new DriveForwardAuto. */
  public DriveForwardAuto(DriveSubsystem DRIVE_SUBSYSTEM) {
    addCommands(
        new AutoDrive(DRIVE_SUBSYSTEM, 0.25, 0).withTimeout(3)
    // time it to do 90 degrerese
    );
  }

}
