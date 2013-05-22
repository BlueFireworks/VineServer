package vine.network;

import vine.util.Stopwatch;

public abstract class CycledServer extends AbstractServer {

	private final int cycleLength;

	protected CycledServer(int port, int cycleLength) {
		super(port);
		this.cycleLength = cycleLength;
	}

	public final int getCycleLength() {
		return cycleLength;
	}

	@Override
	public final void run() {
		while (isRunning()) {
			Stopwatch stopwatch = Stopwatch.start();

			try {
				cycle();
			} catch (Throwable t) {
				// Nowhere to propagate
				t.printStackTrace();
			}

			long elapsed = stopwatch.elapsed();
			if (elapsed < getCycleLength()) {
				try {
					Thread.sleep(getCycleLength() - elapsed);
				} catch (InterruptedException e) {
					// Immediately return if this thread was somehow interrupted
					e.printStackTrace();
					return;
				}
			}
		}
	}

	public abstract boolean isRunning();

	protected abstract void cycle() throws Throwable;

}