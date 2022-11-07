package queuing;

public class QueueFactory{
	
	private Deterministic d;
	private int dcase;
	
	public QueueFactory(double mu, double lamda, int capacity,int M) {
		// super(lamda, lamda, capacity); // TODO link all objects (inheritance and polymorphism) and use Getter and Setters
		if(lamda<mu)
		{
			this.dcase = 1;
			d = new FirstCase(mu, lamda,capacity);
		}
		else {
			this.dcase = 2;
			d = new SecoundCase(mu, lamda,capacity,M);
		}
		
		d.mu = 1/mu;
		d.lamda = 1/lamda;
		d.capacity = capacity;
		d.setServiceTime();
		d.setArrivalTime();
		
		
		getMinTi();
	}
	
	
	public int getNumberOfCustomers(int t) {
		// TODO Auto-generated method stub
		
		return d.getNumberOfCustomers(t);
	}

	
	public int getWaitingTime(int n) {
		// TODO Auto-generated method stub

		return d.getWaitingTime(n);
	}

	
	public int getMinTi() {
		// TODO Auto-generated method stub

		return d.getMinTi();
	}
}
