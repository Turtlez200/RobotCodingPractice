// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoTurnGyro;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class GyroTurnAuton extends SequentialCommandGroup {
  /** Creates a new GyroTurnAuton. */
  public GyroTurnAuton(DriveSubsystem DRIVE_SUBSYSTEM, GyroSubsystem GYRO_SUBSYSTEM) {
    addCommands(
        new AutoTurnGyro(GYRO_SUBSYSTEM, DRIVE_SUBSYSTEM, 90));
  }

}
