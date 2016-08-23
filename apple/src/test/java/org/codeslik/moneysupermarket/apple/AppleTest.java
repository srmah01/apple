package org.codeslik.moneysupermarket.apple;

import static org.junit.Assert.*;

import org.codeslik.moneysupermarket.apple.exception.AppleNotPeeledException;
import org.junit.Before;
import org.junit.Test;

/**
 * The AppleTest Class.
 */
public class AppleTest {

	/** The apple class under test. */
	private Apple apple;
	
	/**
	 * Setup the tests.
	 */
	@Before
	public void setUp() {
		apple = new Apple();
	}
	
	/**
	 * Can create.
	 */
	@Test
	public void canCreate() {
		assertNotNull(apple);
	}
	
	/**
	 * Can set colour.
	 */
	@Test
	public void canSetColour() {
		Colour expected = Colour.Red;
		apple.setColour(expected);
		assertEquals(expected, apple.getColour());
	}

	
	/**
	 * Can set weight.
	 */
	@Test
	public void canSetWeight() {
		Integer expected = 100;
		apple.setWeight(expected);
		assertEquals(expected, apple.getWeight());
	}

	/**
	 * Setting weight with argument below minimum throws.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void settingWeightWithArgumentBelowMinimumThrows() {
		apple.setWeight(9);
	}

	/**
	 * Setting weight with argument above maximum throws.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void settingWeightWithArgumentAboveMaximumThrows() {
		apple.setWeight(101);
	}
	
	/**
	 * Can set taste.
	 */
	@Test
	public void canSetTaste() {
		Integer expected = 1;
		apple.setTaste(expected);
		assertEquals(expected, apple.getTaste());
	}
	
	/**
	 * Setting taste with argument below minimum throws.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void settingTasteWithArgumentBelowMinimumThrows() {
		apple.setTaste(0);
	}

	/**
	 * Setting taste with argument above maximum throws.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void settingTasteWithArgumentAboveMaximumThrows() {
		apple.setTaste(5);
	}
	
	/**
	 * Can set has worm.
	 */
	@Test
	public void canSetHasWorm() {
		apple.setHasWorm(true);
		assertTrue(apple.getHasWorm());
	}
	
	/**
	 * Can peel me.
	 * @throws AppleNotPeeledException 
	 */
	@Test
	public void canPeelMe() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.peelMe();
	}
	
	/**
	 * Can not peel me when has worm is set.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelMeWhenHasWorm() throws AppleNotPeeledException {
		apple.setHasWorm(true);
		apple.setTaste(4);
		apple.peelMe();
	}
	
	/**
	 * Can not peel me when taste is too low.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelMeWhenTasteIsTooLow() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(3);
		apple.peelMe();
	}

	/**
	 * Can not peel me when has worm or taste are not set.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelMeWhenHasWormOrTasteAreNotSet() throws AppleNotPeeledException {
		apple.peelMe();
	}

	/**
	 * Can eat me.
	 * @throws AppleNotPeeledException 
	 */
	@Test
	public void canEatMe() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.peelMe();
		apple.eatMe();
	}

	/**
	 * Cannot eat me when unpeeled.
	 * @throws AppleNotPeeledException 
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void cannotEatMeWhenUnpeeled() throws AppleNotPeeledException {
		apple.eatMe();
	}

}
