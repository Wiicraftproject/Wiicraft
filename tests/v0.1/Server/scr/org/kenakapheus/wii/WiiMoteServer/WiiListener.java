package org.kenakapheus.wii.WiiMoteServer;

import java.io.DataOutputStream;

import wiiusej.Wiimote;
import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.NunchukEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.StatusEvent;

public class WiiListener implements WiimoteListener {
	
	private static DataOutputStream o;
	protected NetEventHelper neh;
	private Wiimote wiimote;
	
	public WiiListener(DataOutputStream os, Wiimote wiimote)
	{
		setOutputStream(os);
		setWiimote(wiimote);
		neh = new NetEventHelper(o);
	}

	public void onButtonsEvent(WiimoteButtonsEvent event)
	{
		try {
			neh.SendButtonsEvent(event);
		} catch (Exception e) {
			e.printStackTrace();
	        wiimote.removeWiiMoteEventListeners(this);
	        System.exit(0);
		}
	}

	public void onClassicControllerInsertedEvent(ClassicControllerInsertedEvent event)
	{
		//nothing
	}

	public void onClassicControllerRemovedEvent(ClassicControllerRemovedEvent event)
	{
		//nothing
	}

	public void onDisconnectionEvent(DisconnectionEvent event)
	{
		wiimote.removeWiiMoteEventListeners(this);
		System.exit(0);
	}

	public void onExpansionEvent(ExpansionEvent event)
	{
		try {
			if (event instanceof NunchukEvent)
			{
				NunchukEvent ne = (NunchukEvent) event;
				neh.SendNunchukEvent(ne);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent event)
	{
		//nothing
	}

	@Override
	public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent event)
	{
		//nothing
	}

	@Override
	public void onIrEvent(IREvent event)
	{
		//nothing
	}

	@Override
	public void onMotionSensingEvent(MotionSensingEvent event)
	{
		//nothing
	}

	@Override
	public void onNunchukInsertedEvent(NunchukInsertedEvent event)
	{
		try {
			neh.SendNunchukConnectionEvent(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onNunchukRemovedEvent(NunchukRemovedEvent event)
	{
		try {
			neh.SendNunchukConnectionEvent(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onStatusEvent(StatusEvent event)
	{
		try {
			neh.SendStatusEvent(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataOutputStream getOutputStream() {
		return o;
	}

	public static void setOutputStream(DataOutputStream os) {
		WiiListener.o = os;
	}

	public Wiimote getWiimote() {
		return wiimote;
	}

	public void setWiimote(Wiimote wiimote) {
		this.wiimote = wiimote;
	}


}
