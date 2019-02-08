package typeCases;

import java.util.Objects;

public class Position implements Comparable{
	private final int x;
	private final int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public boolean isGreaterThan(Position otherPosition){
		return this.compareTo(otherPosition) > 0;
	}

	public boolean isLesserThan(Position otherPosition){
		return this.compareTo(otherPosition) < 0;
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	

	@Override
	public int compareTo(Object other) {
		if(other instanceof Position){
			if(this.x > ((Position)other).getX()
					|| this.y > ((Position)other).getY()) {
				return 1;
			}else if (this.x == ((Position)other).getX() 
					&& this.y == ((Position)other).getY()){
				return 0;
			}
		}
		return -1;
	}
}
