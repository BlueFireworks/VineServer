package vine.record;

import java.io.Serializable;

public final class CreationDate implements Serializable {

	private static final long serialVersionUID = 3777385527186769243L;

	private final int day;
	private final int month;
	private final int year;

	public CreationDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	@Override
	public int hashCode() {
		return ((day & 0x1F) << 19) | ((month & 0xF) << 15) | (year & 0x7FFF);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CreationDate)) {
			return false;
		}

		CreationDate ocd = (CreationDate) o;
		return getDay() == ocd.getDay() && getMonth() == ocd.getMonth()
				&& getYear() == ocd.getYear();
	}

	@Override
	public String toString() {
		return String.format("%d/%d/%d", getMonth(), getDay(), getYear());
	}

}