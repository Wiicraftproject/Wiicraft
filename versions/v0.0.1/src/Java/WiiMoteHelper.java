import java.awt.Point;


public interface WiiMoteHelper 
{
	public Point getIRLocOnScreen();
	public float getRotation(float g);
	//public float getRotation(IrPoint[] ir);
}
