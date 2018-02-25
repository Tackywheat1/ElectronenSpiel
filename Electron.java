public class Electron extends Particle {
  public Electron(double ix, double iy, byte x, double ixvelocity, double iyvelocity) {
    super(ix, iy, (byte)(-1), ixvelocity, iyvelocity);
    setMass(0.0005485799);
  }
  public static double qleap() { // generates random distance.
    double temp;
    do {
	     temp = (-95/(Math.random()*100 + 14))+10;
      }while(temp < 0);
    return temp;
  }
}
