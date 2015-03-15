
public class RosenParticle {

	
	  public double[] position; //is an array of type double and represents a possible solution to the optimization problem
	  public double fitness; //Field fitness is a measure of how good the solution represented by position is
	  public double[] velocity; //Field velocity is an array of type double and represents the information necessary to update a particle’s current position/solution
	  public double[] bestPosition;// best position
	  public double bestFitness; // best fitness
	  
	  
	  
	
	  
	public RosenParticle(double[] position, double fitness,double[] velocity, double[] bestPosition,double bestFitness) {
		
		this.position=position;
		  this.fitness=fitness;
		  this.velocity=velocity;
		  this.bestPosition=bestPosition;
		  this.bestFitness=bestFitness;
	
	
	
	
	}


	  
	  
	  public double[] getPosition() {
		return position;
	}
	public void setPosition(double[] position) {
		this.position = position;
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	public double[] getVelocity() {
		return velocity;
	}
	public void setVelocity(double[] velocity) {
		this.velocity = velocity;
	}
	public double[] getBestPosition() {
		return bestPosition;
	}
	public void setBestPosition(double[] bestPosition) {
		this.bestPosition = bestPosition;
	}
	public double getBestFitness() {
		return bestFitness;
	}
	public void setBestFitness(double bestFitness) {
		this.bestFitness = bestFitness;
	}
	
	  
	
	
	
	
	
}
