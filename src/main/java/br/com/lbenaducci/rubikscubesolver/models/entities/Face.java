package br.com.lbenaducci.rubikscubesolver.models.entities;

import br.com.lbenaducci.rubikscubesolver.models.enums.Color;
import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class Face implements Iterable<Color> {
	private Color one;
	private Color two;
	private Color three;
	private Color four;
	private Color five;
	private Color six;
	private Color seven;
	private Color eight;
	private Color nine;

	@Override
	public Iterator<Color> iterator() {
		return List.of(one, two, three, four, five, six, seven, eight, nine).iterator();
	}

	public Color get(int position) {
		if(position < 1 || position > 9) {
			throw new IllegalStateException("Unexpected value: " + position);
		}
		return List.of(one, two, three, four, five, six, seven, eight, nine).get(position - 1);
	}

	public void set(int position, Color color) {
		switch(position) {
			case 1 -> this.one = color;
			case 2 -> this.two = color;
			case 3 -> this.three = color;
			case 4 -> this.four = color;
			case 5 -> this.five = color;
			case 6 -> this.six = color;
			case 7 -> this.seven = color;
			case 8 -> this.eight = color;
			case 9 -> this.nine = color;
			default -> throw new IllegalStateException("Unexpected value: " + position);
		}
	}

	public int countColor(Color color) {
		int count = 0;
		for(Color c: this) {
			if(c == color) {
				count++;
			}
		}
		return count;
	}

	public boolean isComplete() {
		Color color = get(5);
		return countColor(color) == 9;
	}

	public void rotateClockwise() {
		Color c1 = get(1);
		Color c2 = get(2);
		Color c3 = get(3);
		set(1, get(7));
		set(2, get(4));
		set(3, c1);
		set(7, get(9));
		set(4, get(8));
		set(9, c3);
		set(8, get(6));
		set(6, c2);
	}

	public void rotateCounterclockwise() {
		Color c1 = get(1);
		Color c2 = get(2);
		Color c3 = get(3);
		set(1, c3);
		set(2, get(6));
		set(3, get(9));
		set(6, get(8));
		set(9, get(7));
		set(8, get(4));
		set(7, c1);
		set(4, c2);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\n");
		int i = 0;
		for(Color color: this) {
			i++;
			sb.append(color.getCode()).append("   ");
			if(i % 3 == 0) {
				sb.append("\u001B[0m\n");
			}
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}

		Face colors = (Face) o;

		if(one != colors.one) {
			return false;
		}
		if(two != colors.two) {
			return false;
		}
		if(three != colors.three) {
			return false;
		}
		if(four != colors.four) {
			return false;
		}
		if(five != colors.five) {
			return false;
		}
		if(six != colors.six) {
			return false;
		}
		if(seven != colors.seven) {
			return false;
		}
		if(eight != colors.eight) {
			return false;
		}
		return nine == colors.nine;
	}

	@Override
	public int hashCode() {
		int result = one != null ? one.hashCode() : 0;
		result = 31 * result + (two != null ? two.hashCode() : 0);
		result = 31 * result + (three != null ? three.hashCode() : 0);
		result = 31 * result + (four != null ? four.hashCode() : 0);
		result = 31 * result + (five != null ? five.hashCode() : 0);
		result = 31 * result + (six != null ? six.hashCode() : 0);
		result = 31 * result + (seven != null ? seven.hashCode() : 0);
		result = 31 * result + (eight != null ? eight.hashCode() : 0);
		result = 31 * result + (nine != null ? nine.hashCode() : 0);
		return result;
	}
}
