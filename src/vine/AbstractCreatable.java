package vine;

import vine.record.CreationDate;

/**
 * An abstract implementation of a {@link Creatable} which eases the creation of
 * a concrete <tt>Creatable</tt> type.
 * 
 * @author Thomas G. P. Nappo
 */
public abstract class AbstractCreatable implements Creatable {

	/**
	 * The creation date which is the date of which a {@link Creatable} has
	 * originated onto the <a
	 * href=http://vinecurrency.com>Vine<b>Currency</b></a> platform.
	 */
	private final CreationDate creationDate;

	/**
	 * Constructs a new abstract creatable.
	 * 
	 * @param creationDate
	 *            The creation date which is the date of which a
	 *            {@link Creatable} has originated onto the <a
	 *            href=http://vinecurrency.com>Vine<b>Currency</b></a> platform.
	 */
	protected AbstractCreatable(CreationDate creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public final CreationDate getCreationDate() {
		return creationDate;
	}

}