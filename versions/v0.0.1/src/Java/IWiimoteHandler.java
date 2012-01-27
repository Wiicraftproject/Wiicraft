
public interface IWiimoteHandler {
	
	public void buttonEvent(int event);
	// will be called when a Button is pressed or released
	
	public void extensionEvent(int event);
	// will be called when a Extension is (Dis-)Connected
	
	public void irEvent(int event);
	// will be called when a Ir-point is found or lost
	
}
