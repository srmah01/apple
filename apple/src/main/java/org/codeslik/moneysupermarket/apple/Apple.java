package org.codeslik.moneysupermarket.apple;

/**
 * The Apple Class.
 */
public class Apple {

	/** The colour. */
	private Colour colour;
	
	/** The weight in grams. */
	private Integer weight;
	
	/** The taste. */
	private Integer taste;
	
	/** The has worm. */
	private Boolean hasWorm;

	/**
	 * Gets the colour.
	 *
	 * @return the colour
	 */
	public Colour getColour() {
		return colour;
	}

	/**
	 * Sets the colour.
	 *
	 * @param colour the new colour
	 */
	public void setColour(Colour colour) {
		this.colour = colour;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * Sets the weight in grams between the values 10 and 100.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Integer weight) {
		if (weight < 10 || weight > 100) {
			throw new IllegalArgumentException("Weight value is not within acceptable limits.");
		}
		this.weight = weight;
	}

	/**
	 * Gets the taste.
	 *
	 * @return the taste
	 */
	public Integer getTaste() {
		return taste;
	}

	/**
	 * Sets the taste value between 1 and 4.
	 *
	 * @param taste the new taste value
	 * @throws IllegalArgumentException an illegal argument exception
	 */
	public void setTaste(Integer taste) throws IllegalArgumentException {
		if (taste < 1 || taste > 4) {
			throw new IllegalArgumentException("Taste value is not within acceptable limits.");
		}
		this.taste = taste;
	}

	/**
	 * Gets the checks for worm.
	 *
	 * @return the checks for worm
	 */
	public Boolean getHasWorm() {
		return hasWorm;
	}

	/**
	 * Sets the checks for worm.
	 *
	 * @param hasWorm the new checks for worm
	 */
	public void setHasWorm(Boolean hasWorm) {
		this.hasWorm = hasWorm;
	}
	
}
