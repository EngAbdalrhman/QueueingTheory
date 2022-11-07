package queuing;
/**
 * 
 * Author : Abdalrhman Mostafa
 * Date : 4/11/22
 * **/
public abstract class Deterministic {
	// D/D/1/K/FCFS
	
	protected int ti;
	protected double mu; // service rate;
	protected double serviceTime;
	protected double lamda; // arrival rate
	protected double arrivalTime;
	protected int capacity; // k
	protected int numberOfCustomers;//n(t)
	protected int waitingTime;//wq(n)
	protected int customers;
	
	
	//flags TODO Reset Flags
	private boolean transientState = false;
	protected boolean isEmpty = false;
	protected boolean steadyState = false;
	protected boolean block = false;
	protected int queue;
	protected int dcase;

	public Deterministic(double mu, double lamda, int capacity) {
		super();
		this.mu = 1/mu;
		this.lamda = 1/lamda;
		this.capacity = capacity;
		setServiceTime();
		setArrivalTime();
		
		if(lamda<mu)
		{
			this.dcase = 1;
		}
		else this.dcase = 2;
	}
	
	public void setServiceTime() {
		this.serviceTime= 1/mu;
	}

	public void setArrivalTime() {
		this.arrivalTime = 1/lamda;
	}

	public void setCustomers(int customers) {
		this.customers = customers;
	}


	public int getTi() {
		return ti;
	}

	public void setTi(int ti) {
		this.ti = ti;
	}

	public double getMu() {
		return mu;
	}

	public void setMu(double mu) {
		this.mu = mu;
	}

	public double getServiceTime() {
		return serviceTime;
	}


	public double getLamda() {
		return lamda;
	}

	public void setLamda(double lamda) {
		this.lamda = lamda;
	}

	public double getArrivalTime() {
		return arrivalTime;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getDcase() {
		return dcase;
	}

	
	public abstract int getNumberOfCustomers(int t);
	
	public int getTimeOfCustomer(int n) 
	{ 
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
	public abstract int getWaitingTime(int n);
	
	public void checkSteady(int t) 
	{
		// t >= ti
		if(t>=ti)
			steadyState = true;
		
	}
	public void reset() 
	{
		customers = 0;
		block = false;
		transientState = false; // transientState = !steadyState;
		steadyState = false;
		
	}
	public boolean checkEmpty(int t) {

		if((t-(int)arrivalTime)%serviceTime == 0 && (t != (int)arrivalTime))
			isEmpty = true;
		else isEmpty=false;
		return isEmpty;
	}
	public void Service(int t) {
		
		for (int i = (int) arrivalTime; i <= t; i+=arrivalTime) { // TODO start point
			queue++;
			if(checkEmpty(i))
			{
				queue--;
			}
		}
		// int n = getNumberOfCustomers(t); // n = queue
	}
	

	
   public abstract int getMinTi();
   
}
