package org.kenakapheus.wii.WiiMoteServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;


public class Wii {

	/**
	 * @param args
	 */
	
	static JFrame jf = new JFrame("WiiMote Server");
	static JTextArea ta = new JTextArea();
	
	public static void main(String[] args) {
		jf.setVisible(true);
        jf.setSize(400, 200);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(ta);
        try {
        	println("Starting WiiMote Server  v1.0");
			ServerSocket ss = new ServerSocket(26042);
			println("Started Server on Port 26042. Waiting for Connection!");
			Socket s = ss.accept();
			println("Connected! Searching WiiMotes...");
			Wiimote[] wiimotes = WiiUseApiManager.getWiimotes(1, true);
			println("Found ".concat(Integer.toString(wiimotes.length).concat(" Wiimotes! Using No. 1")));
	        Wiimote wiimote = wiimotes[0];
	        //wiimote.activateIRTRacking();
	        //wiimote.activateMotionSensing();
	        DataOutputStream bos = new DataOutputStream(s.getOutputStream());
	        WiiListener wl = new WiiListener(bos, wiimote);
	        wiimote.addWiiMoteEventListeners(wl);
	        println("Ready to Play!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void println(String s)
	{
		ta.setText(ta.getText().concat(s).concat("\n"));
		if (ta.getLineCount() > 18)
		{
			String s2 = ta.getText();
			int i = s2.indexOf("\n");
			s2 = s2.substring(i + 1);
			ta.setText(s2);
		}
	}
}
