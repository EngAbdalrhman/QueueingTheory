package queuing;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Service time , arrival time , K
//		Deterministic d = new Deterministic(8,4,5);
		//System.out.println(d.calcTi());
//		System.out.println(d.getMu());
//		System.out.println(d.getServiceTime());
//		System.out.println(d.getLamda());
//		System.out.println(d.getArrivalTime());
		// System.out.println(d.getNumberOfCustomers(40));
//		d.getMinTi();
//		System.out.println(d.getTi());
//		System.out.println(d.getWaitingTime(11));
//		System.out.println(d.getWaitingTime(7));
//		System.out.println(d.getNumberOfCustomers(40));
//		System.out.println(d.getNumberOfCustomers(16));
		//d.Service(28);
		
		QueueFactory qf = new QueueFactory(6, 4, 5, 0);
		System.out.println(qf.getMinTi());
//		System.out.println(qf.getWaitingTime(4));
//		System.out.println(qf.getWaitingTime(3));
//		System.out.println(qf.getNumberOfCustomers(9));
//		System.out.println(qf.getNumberOfCustomers(4));
//		for (int i = 0; i < qf.getMinTi(); i++) {
//			int n = qf.getNumberOfCustomers(i);
//			//System.out.println("at t = "+i+" , n = "+n);
//		}

	}
	
	
}
