package org.kenakapheus.wii.testclient;

import java.io.DataInputStream;
import java.io.IOException;

public class NetHelperThread extends Thread {
	
	protected DataInputStream i;
	protected WiiData wd;
	
	NetHelperThread(DataInputStream in, WiiData wid)
	{
		i = in;
		wd = wid;
		this.start();
	}
	
	public void run()
	{
		System.out.println("Thread!");
		while (true)
		{
			try {
				switch (i.readInt())
				{
				case 0 : 
					wd.nunchukButtonsHeld = i.readShort();
					i.readShort();
					i.readShort();
					if (i.readBoolean())
					{
						wd.nunchukJoistickAngle = i.readFloat();
						wd.nunchukJoistickMagnithude = i.readFloat();
					}
					if (i.readBoolean())
					{
						wd.nunchukOrientationPitch = i.readFloat();
						wd.nunchukOrientationRoll = i.readFloat();
					}
				break;
				case 1 :
					i.readBoolean();
				break;
				case 2 :
					wd.battaryLevel = i.readFloat();
					wd.leds = i.readShort();
					wd.nunchukConnected = i.readBoolean();
					wd.rumble = i.readBoolean();
				break;
				case 3 :
					wd.buttonsHeld = i.readShort();
					i.readShort();
					i.readShort();
				break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
