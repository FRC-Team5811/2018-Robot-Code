package org.usfirst.frc.team5811.robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;
public class ReaderFile {
	
		  public String distance;
		  public String angle;
		  public String type;
		  public String action;

		  public ReaderFile(String distance, String angle, String type, String action){
		       this.distance = distance;
		       this.angle = angle;
		       this.type = type;
		       this.action = action;
		  }
}
