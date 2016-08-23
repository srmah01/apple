package org.codeslik.moneysupermarket.apple;

import org.codeslik.moneysupermarket.apple.exception.AppleNotPeeledException;
import org.codeslik.moneysupermarket.apple.peeler.Peeler;
import org.codeslik.moneysupermarket.apple.peeler.ValyrianSteelPeeler;

/**
 * The Apple Class.
 */
public class Apple {

	/** The Constant MIN_WEIGHT. */
	private static final int MIN_WEIGHT = 10;

	/** The Constant MAX_WEIGHT. */
	private static final int MAX_WEIGHT = 100;
	
	/** The Constant MIN_TASTE. */
	private static final int MIN_TASTE = 1;

	/** The Constant MAX_TASTE. */
	private static final int MAX_TASTE = 4;

	/** The colour. */
	private Colour colour;

	/** The weight in grams. */
	private Integer weight;

	/** The taste. */
	private Integer taste;

	/** The has worm flag. */
	private Boolean hasWorm;

	/** The is peeled flag. */
	private Boolean isPeeled = false;

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
	 * @param colour
	 *            the new colour
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
	 * Sets the weight in grams between the values MIN_WEIGHT and MAX_WEIGHT.
	 *
	 * @param weight
	 *            the new weight
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	public void setWeight(Integer weight) throws IllegalArgumentException {
		if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
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
	 * Sets the taste value between MIN_TASTE and MAX_TASTE.
	 *
	 * @param taste
	 *            the new taste value
	 * @throws IllegalArgumentException
	 *             an illegal argument exception
	 */
	public void setTaste(Integer taste) throws IllegalArgumentException {
		if (taste < MIN_TASTE || taste > MAX_TASTE) {
			throw new IllegalArgumentException("Taste value is not within acceptable limits.");
		}
		this.taste = taste;
	}

	/**
	 * Gets the has worm flag.
	 *
	 * @return the has worm flag
	 */
	public Boolean getHasWorm() {
		return hasWorm;
	}

	/**
	 * Sets the has worm flag.
	 *
	 * @param hasWorm
	 *            the has worm flag
	 */
	public void setHasWorm(Boolean hasWorm) {
		this.hasWorm = hasWorm;
	}

	/**
	 * Gets the is peeled flag.
	 *
	 * @return the is peeled flag
	 */
	public Boolean getIsPeeled() {
		return isPeeled;
	}

	/**
	 * Peel me with a given peeler.
	 *
	 * @param peeler
	 *            the peeler to use
	 * @throws AppleNotPeeledException
	 *             the apple not peeled exception
	 */
	public void peelMe(Peeler peeler) throws AppleNotPeeledException {
		if ((hasWorm == null || hasWorm) || (taste == null || taste <= 3) || colour == null) {
			throw new AppleNotPeeledException("Apple cannot be peeled.");
		}

		if (peeler == null) {
			throw new AppleNotPeeledException("A peeler is required.");
		}
		
		if (colour == Colour.Blue && !peeler.getClass().isAssignableFrom(ValyrianSteelPeeler.class)) {
			throw new AppleNotPeeledException("Apple requires Valyrian Steel to peel.");
		}

		this.isPeeled = true;
	}

	/**
	 * Eat me.
	 *
	 * @throws AppleNotPeeledException
	 *             the apple not peeled exception
	 */
	public void eatMe() throws AppleNotPeeledException {
		if (!isPeeled) {
			throw new AppleNotPeeledException("Apple is not peeled.");
		}
	}
}
