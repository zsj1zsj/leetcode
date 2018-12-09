package refelctiton;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

class TestObject {
	int[] array1;
	List array2;

	public int[] getArray1() {
		return array1;
	}

	public void setArray1(int[] array1) {
		this.array1 = array1;
	}

	public List getArray2() {
		return array2;
	}

	public void setArray2(List array2) {
		this.array2 = array2;
	}

}

public class Maini {
public static void main(String[] args) {
	
	TestObject obj = new TestObject();
	int[] a1 ={1,2,3,4};
	obj.setArray1(a1);
	List<String> list = Arrays.asList(new String[]{"aa","bb"});
	obj.setArray2(list);
	
	Class<?> componentype =obj.getClass().getComponentType();
	
	int length = Array.getLength(obj);
	Object newArray = Array.newInstance(componentype, length);
	
	System.out.println(newArray);
	
	
	
	
	System.out.println(componentype);
}
}
