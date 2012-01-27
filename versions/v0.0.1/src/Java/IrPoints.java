
public class IrPoints {

	public IrPoint ip1;
	public IrPoint ip2;
	public IrPoint ip3;
	public IrPoint ip4;
	
	public IrPoints(IrPoint[] ipa)
	{
		ip1 = ipa[0];
		ip2 = ipa[1];
		ip3 = ipa[2];
		ip4 = ipa[3];
	}
	
	public double getRotation(Vector3D v) // -179,9999 bis 180
	{
		Vector3D v0;
		if (ip1.x < ip2.x)
		{
			v0 = new Vector3D(ip2.x - ip1.x, ip2.y - ip1.y, 0);
		} else {
			v0 = new Vector3D(ip1.x - ip2.x, ip1.y - ip2.y, 0);
		}
		double phi = v0.getPHI(new Vector3D(1, 0, 0));
		phi -= 45;
		double r = 0;
		if (v.x > v.y && v.y > 0)
		{
			r = phi;
		} else if(v.x < v.y && v.y >= 1)
		return r;
		return r;
	}
}
