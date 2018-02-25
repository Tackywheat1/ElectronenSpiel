import java.util.ArrayList;
//          90*
//        ____|_____
//      /     |     \
//     /      |      \
// 180*------|------- 0*
//     \     |      /
//      \____|____/
//         270*
//

public class Universe{
  private int xbound;
  private int ybound;
  private ArrayList<Particle> Particles = new ArrayList<Particle>;
  public Universe(int xboundry, int yboundry) {
    xbound = xboundry;
    ybound = yboundry;
  }
  public boolean addParticle(Particle p) {
    if((p.getX() < xbound && p.getX > 0) && (p.getY() < ybound && p.getY > 0)
      Particles.add(p);
    else
      return false;
    return true;
  }
  public void updatefinal() {
    for(Particle a: Particles) { //Electrons attract and protons repel just for the sake of simplicity
      a.update();               //Actually F*ck that lets just make it "orbit"
      if(a instanceof Electron) {
        Electron e = new Electron(a.getX(), a.getY(), -1, a.getVelocities()[0], a.getVelocities()[1]);
        for(Particle b: Particles) {
          if(b != a) {
            b.applyforce((Math.atan2(b.getY() - a.getY(), b.getX() - a.getX())*(180/Math.PI)), (1/(Math.atan2(b.getY() - a.getY(), b.getX() - a.getX())*(180/Math.PI))));
          }
        }
      }
      else if(a instanceof Proton) {

      }
    }
  }
}
