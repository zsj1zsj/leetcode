package PO;

import com.google.common.base.MoreObjects.ToStringHelper;

public class Employee {
	int id;
	String name;

	public Employee() {
		this.id = 0;
		this.name = "";
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Employee o = (Employee) obj;
		if (this.id == o.id && this.name.equals(o.name))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		if (this.id == 0)
			return 0;
		int result = 15;
		result = result * 31 + this.id;
		result = result * 31 + this.name.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return this.id + " " + this.name;
	}
}
