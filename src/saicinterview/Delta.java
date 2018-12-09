package saicinterview;

class Alpha implements Fooo {
}

class Beta extends Alpha {
}

public class Delta extends Beta {

	public static void main(String[] args) {
		Beta x = new Beta();
		//
		Alpha a = x;
		Fooo f = (Delta) x;
		f = (Alpha) x;
		Beta b =(Beta)(Alpha)x;
	}
}
