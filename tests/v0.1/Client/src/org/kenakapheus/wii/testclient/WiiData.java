package org.kenakapheus.wii.testclient;

import java.awt.Point;

public class WiiData {
	
	short buttonsHeld, nunchukButtonsHeld, leds;
	float nunchukJoistickAngle, nunchukJoistickMagnithude, nunchukOrientationPitch, nunchukOrientationRoll;
	float battaryLevel;
	boolean rumble, nunchukConnected;
	
	public Point getJoistick()
	{
		double xAng = Math.sin(nunchukJoistickAngle * Math.PI / 180.0) * nunchukJoistickMagnithude;
		double yAng = Math.cos(nunchukJoistickAngle * Math.PI / 180.0) * nunchukJoistickMagnithude;
		Point p = new Point();
		p.setLocation(xAng * 1000, yAng * 1000);
		return p;
	}

}
