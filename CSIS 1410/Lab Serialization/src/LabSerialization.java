import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
public class LabSerialization {
    public static void main(String[] args) {
        ListVsSetDemo demo = new ListVsSetDemo(
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(6, Color.BLUE),
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(8, Color.YELLOW));

        //testDemo(demo);
        serialize(demo, "demo.ser");
        
        ListVsSetDemo newLVSD = null;
        newLVSD = deserialize("demo.ser");
        testDemo(newLVSD);

    };
    
    private static ListVsSetDemo deserialize(String fileName) {
    	ListVsSetDemo list = null;
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
    		list = (ListVsSetDemo) ois.readObject();
    	} catch (IOException | ClassNotFoundException e){
    		
    	}
    	return list;
    }
    
    private static void serialize(ListVsSetDemo demo, String fileName) {
    	try  (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
    		oos.writeObject(demo);
    		System.out.println("Serialized");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private static void testDemo(ListVsSetDemo demo) {
        System.out.println("List:");
        System.out.println(demo.getListElements());
        System.out.println("Set:");
        System.out.println(demo.getSetElements());
    }

}
