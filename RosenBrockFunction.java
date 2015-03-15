import java.util.Random;



public class RosenBrockFunction {

	
	// Rosenbrock Function
	
	 static double RosenbrockFunc(double[] x)
	  {
	
		 
		 return Math.pow((1 - x[0]), 2.0) +  (100 * Math.pow((x[1] - Math.pow(x[0], 2.0)), 2.0));
	
	  }
	
	
	public static void main(String args[])
	{
		
		 int numberofParticles = 10;
	     double minX = -10.0;
	     double maxX = 10.0;
		
	     Random r=new Random();
	     // initialize all particles
	     
	    
	 
	     double minV = -1.0 * maxX;
	     double maxV = maxX;
	     
	     RosenParticle[] particle = new RosenParticle[numberofParticles];
	     double[] bestGlobalPosition = new double[2];
	     double bestGlobalFitness = Double.MAX_VALUE; 
	     
	     double[] randomPosition = new double[2];
	     double lo,hi;
	     // generating the random points
	     for (int i = 0; i < particle.length; ++i)
	     { 
	       
	       for (int j = 0; j < randomPosition.length; ++j) {
	          lo = minX;
	          hi = maxX;
	         randomPosition[j] = (hi - lo) * r.nextDouble() + lo; 
	    // System.out.println(randomPosition[j]);
	       }
	     
	     
	     
	     double fitness = RosenbrockFunc(randomPosition);
	     //System.out.println(fitness);
	     
	     double[] randomVelocity = new double[2];
	     for (int j = 0; j < randomVelocity.length; ++j) {
	        lo = -1.0 * Math.abs(maxX - minX);
	        hi = Math.abs(maxX - minX);
	       randomVelocity[j] = (hi - lo) * r.nextDouble() + lo;
	     }
	     

	     particle[i] = new RosenParticle(randomPosition, fitness, randomVelocity,bestGlobalPosition,bestGlobalFitness );
	
	   //  System.out.println("swarm i " + swarm[i].fitness );
	     
	     
	     if (particle[i].fitness < bestGlobalFitness) {
	    	    bestGlobalFitness = particle[i].fitness;
	    	    bestGlobalPosition=particle[i].position.clone();
	    	  
	    // System.out.println("ENTER " + bestGlobalPosition[0]);
	     	}
	     
	     }
	     System.out.println("Initial Stage:");
	     System.out.println("Initial Global Fitness");
	     System.out.println(bestGlobalFitness);
	     System.out.println("");
	     System.out.println("Initial Global Position:");
	     System.out.println("x:" + Math.floor( bestGlobalPosition[0] * 100) / 100);
	     System.out.println("y:" + Math.floor( bestGlobalPosition[1] * 100) / 100);
	     // Main process loop
	     
	     double w = 0.729; // inertia weight
	     double c1 = 1.49445; // personal weight weight
	     double c2 = 1.49445; // social weight
	     double r1, r2; // randomizations
	     
	     double[] newVelocity = new double[2];
	     double[] newPosition = new double[2];
	     double newFitness;
	  
	  for(int count=0;count<1200;count++)   
	  {   
	     for (int i = 0; i < particle.length; i++) 
	     {
	       RosenParticle currParticle= particle[i];
	              
	       for (int j = 0; j < currParticle.velocity.length; j++) 
	       {
	         r1 = r.nextDouble();
	         r2 = r.nextDouble();
	      
	         newVelocity[j] = (w * currParticle.velocity[j]) +
	           (c1 * r1* (currParticle.bestPosition[j] - currParticle.position[j])) +
	           (c2 * r2 * (bestGlobalPosition[j] - currParticle.position[j]));
	         
	         
	         if (newVelocity[j] < minV)
	        	    newVelocity[j] = minV;
	        	  else if (newVelocity[j] > maxV)
	        	    newVelocity[j] = maxV;
	       
	       }
	       currParticle.velocity=newVelocity.clone();
	        
	         
	       for (int j = 0; j < currParticle.position.length; j++)
	       {
	         newPosition[j] = currParticle.position[j] + newVelocity[j];
	         
	         if (newPosition[j] < minX)
	           newPosition[j] = minX;
	         else if (newPosition[j] > maxX)
	           newPosition[j] = maxX;
	       }
	       
	       currParticle.position=newPosition.clone();
	       
	       
	       
	       newFitness = RosenbrockFunc(newPosition);
	       currParticle.fitness = newFitness;
	    
	       if (newFitness < currParticle.bestFitness) {
	         
	    	   currParticle.bestPosition=newPosition.clone();
	         
	    	   currParticle.bestFitness = newFitness;
	       }
	       if (newFitness < bestGlobalFitness) {
	        
	         bestGlobalPosition=newPosition.clone();
	         bestGlobalFitness = newFitness;
	       }
	    
	    
	         
	         
	         
	         
	       
	       
	     }  
	         
	     
	}
	  
	//  System.out.println("best position-->" + bestGlobalPosition[0] + " " + bestGlobalPosition[1]);
	  System.out.println("------------------------------------");  
	  
	 System.out.println("Rosenbrock Function:");
	 System.out.println("f(x,y) = (1-x)^2 + 100 * (y-x*x)^2   ");
	  
	System.out.println("------------------------------------");
	
	  System.out.println("Global Minimum found at");
	  for (int i = 0; i < bestGlobalPosition.length; i++){
	      
		  if(i==0)
		  {
	      System.out.print("x" + " = " );
		  }
		  else
		  {
			  System.out.print("y" + " = " );  
		  }
	      bestGlobalPosition[i]=Math.floor(bestGlobalPosition[i] * 100) / 100 ;
	      System.out.println(bestGlobalPosition[i]);
	    }
	     
	 
	 System.out.println("Best Global Fitsness :" + RosenbrockFunc(bestGlobalPosition));
		
		
		
		
		
		
	}
	
	
}
