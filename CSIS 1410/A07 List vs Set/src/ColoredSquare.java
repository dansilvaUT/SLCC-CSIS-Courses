import java.awt.Color;

public class ColoredSquare {
	
	private int side;
	private Color color;
	
	public ColoredSquare(int s, Color c) {
		this.side = s;
		this.color = c;
	}
	
	public int area() {
		return side * side;
		
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + side;
		return result;
		
	}
	
	@Override
	public String toString() {
		return String.format("side: %d #%s%n", side, Integer.toHexString(color.getRGB()));
	}
}
