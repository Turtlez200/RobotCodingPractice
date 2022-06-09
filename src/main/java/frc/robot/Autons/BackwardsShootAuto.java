// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autons;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoConveyer;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.AutoIntake;
import frc.robot.commands.AutoShoot;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class BackwardsShootAuto extends SequentialCommandGroup {
  /** Creates a new BackwardsShootAuto. */
  public BackwardsShootAuto(DriveSubsystem DRIVE_SUBSYSTEM, IntakeSubsystem INTAKE_SUBSYSTEM, 
  ConveyerSubsystem CONVEYER_SUBSYSTEM, ShooterSubsystem SHOOTER_SUBSYSTEM) {
    addCommands(
        new ParallelCommandGroup(
          new AutoDrive(DRIVE_SUBSYSTEM, 0.5, 0),
          new AutoIntake(INTAKE_SUBSYSTEM, CONVEYER_SUBSYSTEM, -1, -0.75, 0.5)
        ).withTimeout(2),
        new AutoShoot(SHOOTER_SUBSYSTEM).withTimeout(1),
        new ParallelCommandGroup(
          new AutoShoot(SHOOTER_SUBSYSTEM),
          new AutoConveyer(CONVEYER_SUBSYSTEM, INTAKE_SUBSYSTEM)
        ).withTimeout(2)
    );
    // Use addRequirements() here to declare subsystem dependencies.
  }
}
