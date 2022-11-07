package queuing;

public class FirstCase extends Deterministic{

	public FirstCase(double mu, double lamda, int capacity) {
		super(mu, lamda, capacity);
		// TODO Auto-generated constructor stub
	}
	
	public int getNumberOfCustomers(int t) {
		reset();
		checkSteady(t);
		// transient
		if(t<lamda)
			numberOfCustomers = 0;
		 else if(steadyState)
			 numberOfCustomers = capacity - 1; // could be -2
		 else
			 numberOfCustomers =(int) (lamda * t) - (int) ((mu * t - mu/lamda)+0.001);
		return numberOfCustomers;
	}
	
	public int getWaitingTime(int n) {
		reset();
		int t = getTimeOfCustomer(n);
		checkSteady(t);
		// transient
		
		 if(steadyState)
			 waitingTime = (int) ((serviceTime-arrivalTime) * (lamda * ti - 2)); // TODO could be -2
		 else 
			 waitingTime = (int) (serviceTime-arrivalTime) * (n-1);
		 if(block)
			 return -1;
		return waitingTime;
	}
	public int getTimeOfCustomer(int n) 
	{ // fix not number in the system --> use customer not num of customer
		//int t = (int)((n - (this.getMu()/this.getLamda()))/(this.getLamda()-this.getMu()));
		int t = 0;
		
			while(n != customers)
			{
				t +=arrivalTime; 
				customers++;
			}
			if(getNumberOfCustomers(t)==(getCapacity()-1) && t >= getTi() && !checkEmpty(t)) //TODO handle if someone out of the system
			{
				// n(t) = k-1
				block=true;
			}
			else 
				block=false;
		
		return t;
	}
	
	public void checkSteady(int t) 
	{
		// t >= ti
		if(t>=ti)
			steadyState = true;
		// n >= lamda * ti ?
	}
	
	public boolean checkEmpty(int t) {

		if((t-(int)arrivalTime)%serviceTime == 0 && (t != (int)arrivalTime))
			isEmpty = true;
		else isEmpty=false;
		return isEmpty;
	}
	
	 public int getMinTi() {
		   while ((this.getCapacity()) != ((int)(ti * lamda) - (int)((((ti * mu) - (mu / lamda)))+0.001))) {
			      ti+=arrivalTime;
			    }
		   return ti;
	   }

}
