
public class Vector3D {
	public double x, y, z;
	
	public Vector3D(double nx, double ny, double nz)
	{
		x = nx;
		y = ny;
		z = nz;
	}
	
	public double getLegth()
	{
		double l = Math.sqrt((x * x) + (y * y) + (z * z));
		return l;
	}
	
	public double getPHI(Vector3D v)
	{
		double skalar = x * v.x + y * v.y + z * v.z;
		double phi = Math.acos(skalar / (this.getLegth() * v.getLegth()));
		return phi;
	}

}
