package vine.record;

import java.io.Serializable;

import vine.Creatable;

/**
 * A creation date is the date of which a {@link Creatable} has originated onto
 * the <a href=http://vinecurrency.com>Vine<b>Currency</b></a> platform.
 * 
 * @author Thomas G. P. Nappo
 */
public final class CreationDate implements Serializable {

	/**
	 * Represents the class version, should increment it if the current version
	 * of your class is not binary compatible with its previous version.
	 */
	private static final long serialVersionUID = 3777385527186769243L;

	/**
	 * A date (day of month) is represented by an integer from <tt>1</tt> to
	 * <tt>31</tt> in the usual manner.
	 */
	private final int day;

	/**
	 * A month is represented by an integer from <tt>1</tt> to <tt>12</tt>;
	 * <tt>1</tt> is <i>January</i>, <tt>2</tt> is <i>February</i>, and so
	 * forth; thus <tt>12</tt> is <i>December</i>.
	 */
	private final int month;

	/**
	 * A <a href=http://en.wikipedia.org/wiki/Gregorian_calendar>Gregorian
	 * calendar</a> year <tt>y</tt> is represented by the integer value of
	 * <tt>y</tt>; thus <tt>2013</tt> is <i>2013</i> and <tt>1965</tt> is
	 * <i>1965</i>.
	 */
	private final int year;

	/**
	 * Constructs a new creation date of which a {@link Creatable} has
	 * originated onto the <a
	 * href=http://vinecurrency.com>Vine<b>Currency</b></a> platform.
	 * 
	 * @param day
	 *            A date (day of month) is represented by an integer from
	 *            <tt>1</tt> to <tt>31</tt> in the usual manner.
	 * @param month
	 *            A month is represented by an integer from <tt>1</tt> to
	 *            <tt>12</tt>; <tt>1</tt> is <i>January</i>, <tt>2</tt> is
	 *            <i>February</i>, and so forth; thus <tt>12</tt> is
	 *            <i>December</i>.
	 * @param year
	 *            A <a href=http://en.wikipedia.org/wiki/Gregorian_calendar>
	 *            Gregorian calendar</a> year <tt>y</tt> is represented by the
	 *            integer value of <tt>y</tt>; thus <tt>2013</tt> is <i>2013</i>
	 *            and <tt>1965</tt> is <i>1965</i>.
	 */
	public CreationDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Returns a date (day of month) which is represented by an integer from
	 * <tt>1</tt> to <tt>31</tt> in the usual manner.
	 * 
	 * @return The {@link #day} of the creation date.
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Returns a month which is represented by an integer from <tt>1</tt> to
	 * <tt>12</tt>; <tt>1</tt> is <i>January</i>, <tt>2</tt> is <i>February</i>,
	 * and so forth; thus <tt>12</tt> is <i>December</i>.
	 * 
	 * @return The {@link #month} of the creation date.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Returns a <a href=http://en.wikipedia.org/wiki/Gregorian_calendar>
	 * Gregorian calendar</a> year where <tt>y</tt> is represented by the
	 * integer value of <tt>y</tt>; thus <tt>2013</tt> is <i>2013</i> and
	 * <tt>1965</tt> is <i>1965</i>.
	 * 
	 * @return The {@link #year} of the creation date.
	 */
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