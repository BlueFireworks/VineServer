package vine;

import vine.record.CreationDate;

public abstract class AbstractCreatable implements Creatable {

	private final CreationDate creationDate;

	protected AbstractCreatable(CreationDate creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public final CreationDate getCreationDate() {
		return creationDate;
	}

}