package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EvolutionExampleOriginalClass3 {
	public static void main(String args[]) {  
        boolean serialize = false;  
        boolean deserialize = false;  
        if (args.length == 1) {  
            if (args[0].equals("-d")) {  
                deserialize = true;  
            } else if (args[0].equals("-s")) {  
                serialize = true;  
            } else {  
                usage();  
                System.exit(0);  
            }  
        } else {  
            usage();  
            System.exit(0);  
        }  
        AClass serializeclass = new AClass(10, "serializedByOriginalClass");  
        AClass deserializeclass = null;  
        if (serialize) {  
            try {  
                FileOutputStream fo = new FileOutputStream("evolve.tmp");  
                ObjectOutputStream so = new ObjectOutputStream(fo);  
                so.writeObject(serializeclass);  
                so.flush();  
            } catch (Exception e) {  
                System.out.println(e);  
                System.exit(1);  
            }  
        }  
        if (deserialize) {  
            try {  
                FileInputStream fi = new FileInputStream("evolve.tmp");  
                ObjectInputStream si = new ObjectInputStream(fi);  
                deserializeclass = (AClass) si.readObject();  
            } catch (Exception e) {  
                System.out.println(e);  
                System.exit(1);  
            }  
            System.out.println("Now printing deserialzed object's name:");  
            System.out.println();  
            System.out.println(deserializeclass);  
            System.out.println();  
        }  
    }  
  
    static void usage() {  
        System.out.println("Usage:");  
        System.out.println("    -s(in order to serialize)");  
        System.out.println("    -d(in order to deserialize)");  
    }  
}


class AClass implements Serializable {  
	  
    private int num;  
    String      name;  
  
    AClass(int n, String s){  
        num = n;  
        name = s;  
    }  
  
    private void writeObject(ObjectOutputStream s) throws IOException {  
        s.defaultWriteObject();  
    }  
  
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {  
        s.defaultReadObject();  
    }  
  
    public String toString() {  
        return ("Name:" + name + "\n" + "Num:" + num + "\n");  
    }  
}  
