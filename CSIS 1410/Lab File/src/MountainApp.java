import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class MountainApp {
	public static void main(String[] args) {
		List<Mountain> mountainList = new LinkedList<>();
		try {
			Scanner input = new Scanner(MountainApp.class.getResourceAsStream("Mountains.csv"));
			while(input.hasNextLine()) {
				Mountain newMountain = getMountain(input.nextLine());
				if(newMountain != null) {
					mountainList.add(newMountain);
				}
			}
		} finally {
			for(Mountain m : mountainList) {
				System.out.println(m.toString());
			}
		}
		
	}

	private static Mountain getMountain(String nextLine) {
		try {
			String[] items = nextLine.split(",");
			return new Mountain(items[0], Integer.parseInt(items[1]), Boolean.parseBoolean(items[2]));
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.err.print(nextLine + " Could not be read in as mountain.\n");
			return null;
		}
	}
}
