package org.kenakapheus.wii.testclient;

import java.io.DataInputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class WiiClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 26042);
			//s.connect(s.getRemoteSocketAddress());
			DataInputStream i = new DataInputStream(s.getInputStream());
			WiiData wd = new WiiData();
			new NetHelperThread(i, wd);
			JFrame jf = new JFrame("Wii Client");
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setVisible(true);
			jf.setSize(500, 500);
			jf.setLocation(1000, 300);
			JTextField xField = new JTextField();
			JTextField yField = new JTextField();
			xField.setBounds(100, 100, 100, 50);
			yField.setBounds(100, 200, 100, 50);
			jf.add(xField);
			jf.add(yField);
			JTextField pitchField = new JTextField();
			JTextField rollField = new JTextField();
			pitchField.setBounds(300, 100, 100, 50);
			rollField.setBounds(300, 200, 100, 50);
			jf.add(pitchField);
			jf.add(rollField);
			System.out.println("Go!");
			System.out.println("LEDs: " + Integer.toBinaryString(wd.leds));
			while (s.isConnected())
			{
				xField.setText("X: " + wd.getJoistick().getX());
				yField.setText("Y: " + wd.getJoistick().getY());
				pitchField.setText("Pitch: " + wd.nunchukOrientationPitch);
				rollField.setText("Roll: " + wd.nunchukOrientationRoll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
