public abstract class Particle {
  private double x;
  private double y;
  private byte charge;  //optimize!!!
  private double xvelocity;
  private double yvelocity;
  private double mass = 0; // ALL MASSES ARE IN Astronomical Units :) jk they're all in Atomic Mass Units
  public Particle(double ix, double iy, byte icharge, double ixvelocity, double iyvelocity) {
    x = ix;
    y = iy;
    charge = icharge;
    xvelocity = ixvelocity;
    yvelocity = iyvelocity;
  }
  public void setX(double ix) {  //Setting x
    x = ix;
  }
  public void setY(double iy) {  //Setting y
    y = iy;
  }
  public double getX() {  //Setting x
    return x;
  }
  public double getY() {  //Setting y
    return y;
  }
  public void setVelocity(double ixvelocity, double iyvelocity) { // Set velocities
    xvelocity = ixvelocity;
    yvelocity = iyvelocity;
  }
  public void addXV(double vel) { // Adds velocity in a direction
    xvelocity += vel;
  }
  public void addYV(double vel) {
    yvelocity += vel;
  }
  public void update() { // Updating
    x = x + xvelocity;
    y = y + yvelocity;
  }
  public double[] getVelocities() { //getter
    return (new double[] {xvelocity, yvelocity});
  }
  public double distance(Particle b) {
    return Math.sqrt(Math.pow(b.getX()-x, 2) + Math.pow(b.getY() - y, 2));
  }
  public void applyforce(double degree, double force) {
    force = force/mass;
    while(degree < 0) { //trust me on this
      degree = 360+degree;
    }
    switch (degree) {
      case 0:
        addXV(force);
      break;
      case 90:
        addYV(force);
      break;
      case 180:
        addXV(-1*(force));
      break;
      case 270:
        addYV(-1*(force));
      break;
      default:
        if(degree < 90 && degree > 0) {
          double t1 = (10/9)*degree;
          double t2 = 100-t1;
          addXV(force*t2);
          addYV(force*t1);
        }
        else if(degree > 90 && degree < 180) {
          double t1 = (10/9)*(degree-90);
          double t2 = 100-t1;
          addXV(force*t2*-1);
          addYV(force*t1);
        }
        else if(degree > 180 && degree < 270) {
          double t1 = (10/9)*(degree-180);
          double t2 = 100-t1;
          addXV(force*t2*-1);
          addYV(force*t1*-1);
        }
        else if(degree > 270 && degree < 360) {
          double t1 = (10/9)*(degree-270);
          double t2 = 100-t1;
          addXV(force*t1);
          addYV(force*t2);
        }
      break;
    }
  }
}
