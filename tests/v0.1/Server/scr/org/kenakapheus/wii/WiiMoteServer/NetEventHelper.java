package org.kenakapheus.wii.WiiMoteServer;

import java.io.DataOutputStream;
import wiiusej.wiiusejevents.physicalevents.ButtonsEvent;
import wiiusej.wiiusejevents.physicalevents.NunchukEvent;
import wiiusej.wiiusejevents.wiiuseapievents.StatusEvent;

public class NetEventHelper {
	
	private DataOutputStream out;
	
	public NetEventHelper(DataOutputStream o)
	{
		setOutputStream(o);
	}
	
	public void SendNunchukEvent(NunchukEvent e) throws Exception
	{
		out.writeInt(0);
		out.writeShort(e.getButtonsEvent().getButtonsHeld());
		out.writeShort(e.getButtonsEvent().getButtonsJustPressed());
		out.writeShort(e.getButtonsEvent().getButtonsJustReleased());
		if (e.isThereNunchukJoystickEvent())
		{
			out.writeBoolean(true);
			out.writeFloat(e.getNunchukJoystickEvent().getAngle());
			out.writeFloat(e.getNunchukJoystickEvent().getMagnitude());
		} else out.writeBoolean(false);
		if (e.isThereMotionSensingEvent())
		{
			out.writeBoolean(true);
			out.writeFloat(e.getNunchukMotionSensingEvent().getOrientation().getPitch());
			out.writeFloat(e.getNunchukMotionSensingEvent().getOrientation().getRoll());
		} else out.writeBoolean(false);
	}
	
	public void SendNunchukConnectionEvent(boolean conected) throws Exception
	{
		out.writeInt(1);
		out.writeBoolean(conected);
	}
	
	public void SendStatusEvent(StatusEvent e) throws Exception
	{
		out.writeInt(2);
		out.writeFloat(e.getBatteryLevel());
		out.writeShort(e.getLeds());
		out.writeBoolean(e.isNunchukConnected());
		out.writeBoolean(e.isRumbleActive());
	}
	
	public void SendButtonsEvent(ButtonsEvent e) throws Exception
	{
		out.writeInt(3);
		out.writeShort(e.getButtonsHeld());
		out.writeShort(e.getButtonsJustPressed());
		out.writeShort(e.getButtonsJustReleased());
	}

	public DataOutputStream getOutputStream() {
		return out;
	}

	public void setOutputStream(DataOutputStream out) {
		this.out = out;
	}

}
