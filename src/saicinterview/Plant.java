package saicinterview;

public class Plant {
	private String name;
	
	public Plant(){}

	public Plant(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}


class Tree extends Plant{
	public void growFruit(){}
	public void dropLeaves(){}
}
