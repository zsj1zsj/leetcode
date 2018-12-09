package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;  

public class TestSerialize implements Serializable {

	private static final long serialVersionUID = 1L;
	public byte version = 100;
	public byte count = 65;

	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("writeObject in  TestSerialize");
		PutField fields = out.putFields();
//		out.defaultWriteObject();
		fields.put("version",this.version);
		fields.put("count",this.count);
		out.putFields();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("readObject in Testserialize");
//		in.defaultReadObject();
		GetField fields = in.readFields();
		this.version =(byte)fields.get("version",(byte)1);
		this.count = (byte)fields.get("count",(byte)1);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TestSerialize test = new TestSerialize();
		FileOutputStream fos = new FileOutputStream("e:/new.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(test);
		oos.flush();
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("e:/new.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		TestSerialize tin = (TestSerialize) obj;
		System.out.println("count:" + tin.count);
		ois.close();
		fis.close();
	}

	static public void outputObj() throws IOException {
		FileOutputStream fos = new FileOutputStream("e:/temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TestSerialize testSerialize = new TestSerialize();
		oos.writeObject(testSerialize);
		oos.flush();
		oos.close();
	}

	static public TestSerialize inputObj() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("e:/temp.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		TestSerialize test = (TestSerialize) ois.readObject();
		// byte[] bb = new byte[200];
		// while (fis.read(bb) != -1) {
		// for (byte b : bb) {
		// System.out.print(Integer.toHexString(b));
		// System.out.print(" ");
		// }
		// }

		return test;
	}

}
