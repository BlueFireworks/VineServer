package vine;

import vine.record.CreationDate;

/**
 * A <tt>creatable</tt> is any type able to be created within the <a
 * href=http://vinecurrency.com>VineCurrency</a> platform.
 * 
 * <p>
 * Each creatable entails a date of origin (see: {@link #getCreationDate()}).
 * </p>
 * 
 * @author Thomas G. P. Nappo
 */
public interface Creatable {

	/**
	 * Returns the date of which this creatable was created.
	 * 
	 * @return The date of which this creatable was created.
	 */
	CreationDate getCreationDate();

}