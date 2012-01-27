
public class lib {
	
	private ILib obj;

	public lib(ILib lib) {
		obj = lib;
	}
	
	private void call(){
		obj.buttonEvent(ButtonEvent.buttonAReleased.ordinal());
	}
	public int getIrPoints()
	{
		return 0;
		
	}
	
	public V3F getAxel(){
		
	}
}
