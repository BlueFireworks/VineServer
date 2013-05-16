package vine;

/**
 * A <tt>fruit</tt> serves to represent a <i>currencial unit</i> of the <a
 * href=http://vinecurrency.com>VineCurrency</a> platform. As such;
 * <tt>fruit</tt>s do (and <i>should</i>) not entail a particular value in
 * relation to another currency, but rather such should be determined through
 * user interaction with the platform.
 * 
 * <p>
 * Each <tt>fruit</tt> entails detail about it's point of origin (
 * {@link #getRegistrar()}) and the current holder ({@link #getHolder()}).
 * </p>
 * 
 * @author Thomas G. P. Nappo
 */
public interface Fruit {

	/**
	 * Returns the address of the current holder of this <tt>fruit</tt>.
	 * 
	 * @return The address of the current holder of this <tt>fruit</tt>.
	 */
	Address getHolder();

	/**
	 * Returns the original holder's address of this <tt>fruit</tt>.
	 * 
	 * @return The original holder's address of this <tt>fruit</tt>.
	 */
	Address getRegistrar();

}