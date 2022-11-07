package queuing;

public class SecoundCase extends Deterministic{
	private int M;
	public SecoundCase(double mu, double lamda, int capacity , int M) {
		super(mu, lamda, capacity);
		// TODO Auto-generated constructor stub
		this.M = M;
	}
	@Override
	public int getNumberOfCustomers(int t) {
		// TODO Auto-generated method stub
		reset();
		checkSteady(t); // TODO make one only attributes
		if(steadyState)
		{
			numberOfCustomers = 1; // or 0
			return numberOfCustomers;
		}
			
		if(lamda != mu)
			numberOfCustomers = M+(int) (lamda * t+0.01)- (int) (mu * t+0.01);
		else
			numberOfCustomers = M;
		return numberOfCustomers;
	}
	@Override
	public int getWaitingTime(int n) {
		// TODO Auto-generated method stub
		reset();
		int t = getTimeOfCustomer(n);
		checkSteady(t);
		if(steadyState)
		{
			waitingTime =0;
			return waitingTime;
		}
		else if(n==0)
		{
			waitingTime = (int) ((M-1) / 2 * mu);
		}
		else if(n < ti*lamda)
		{
			waitingTime = (int) ((M - 1 + n) * (serviceTime) - n * arrivalTime);
		}
		else 
			waitingTime = (int) ((M - 1) * (serviceTime)); // at lamda = mu

		return waitingTime;
	}
	@Override
	public int getMinTi() {
		// TODO Auto-generated method stub
		 while ((this.M) != ((int)(ti * mu) - (int) ((lamda * ti)+0.001))) {
		      ti++; // not arrival time only to add
		    }
		 super.setTi(ti);//se parent obj
		 return ti;
	}

}
