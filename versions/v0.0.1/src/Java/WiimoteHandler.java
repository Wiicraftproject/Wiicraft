
public class WiimoteHandler {
	private IWiimoteHandler obj;

	public WiimoteHandler(IWiimoteHandler lib) {
		obj = lib;
	}
	
	public Wiimote Search()
	{
		return null;
		
	}
	
	private void call(){
		obj.buttonEvent(ButtonEvent.buttonAReleased.ordinal());
	}
	
	
}
