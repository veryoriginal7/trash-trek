// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxAlternateEncoder.Type;
public class Elevator extends SubsystemBase {

  private final PIDController PIDcontroller = new PIDController(1,0.1,0.1);
  private final CANSparkMax m_elevatorMotor = new CANSparkMax(1,MotorType.kBrushed);
  private final RelativeEncoder m_encoder = m_elevatorMotor.getAlternateEncoder(Type.kQuadrature, 8192);
  public Elevator() {
    elevator.setSoftLimit(kForward,1000);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

 

  public void move(double input){
    elevator.set(input);
  }

  public void reset(){
    m_encoder.setPosition(0);
  }

  public double getHeight(){
    m_encoder.getposition();
  }

  public double nextOutput(){
     double output = PIDController.calculate(m_encoder.	getPosition(),500);
     elevator.set(output);
  }

  public boolean switches(){
    elevatorEncoder.getDistance()>1000;
  }
}
