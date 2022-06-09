// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autons;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.AutoIntake;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class DriveBackwardAuto extends SequentialCommandGroup {
  /** Creates a new DriveBackwardAuto. */
  public DriveBackwardAuto(DriveSubsystem DRIVE_SUBSYSTEM, IntakeSubsystem INTAKE_SUBSYSTEM,
      ConveyerSubsystem CONVEYER_SUBSYSTEM) {
    addCommands(
      new ParallelCommandGroup(
        new AutoDrive(DRIVE_SUBSYSTEM, 0.25, 0), 
        new AutoIntake(INTAKE_SUBSYSTEM, CONVEYER_SUBSYSTEM, -1, -0.75, 0.5)
      ).withTimeout(1)
    );
  }
}
