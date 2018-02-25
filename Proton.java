public class Proton{
  public Proton(double ix, double iy, double ixvelocity, double iyvelocity){ //constructor sets mass and particle position and velocity
    mass = 1.00727647;
    super(ix, iy, 1, ixbelocity, iyvelocity)
  }
  public static double qleap() { // generates random distance.
    double temp;
    do {
	     temp = (-95/(Math.random()*100 + 14))+10;
      }while(temp < 0);
    return temp;
  }
}
