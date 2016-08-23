package org.codeslik.moneysupermarket.apple;

import static org.junit.Assert.*;

import org.codeslik.moneysupermarket.apple.exception.AppleNotPeeledException;
import org.codeslik.moneysupermarket.apple.peeler.NormalPeeler;
import org.codeslik.moneysupermarket.apple.peeler.Peeler;
import org.codeslik.moneysupermarket.apple.peeler.ValyrianSteelPeeler;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
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
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test
	public void canPeelMe() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.setColour(Colour.Red);
		apple.peelMe(new NormalPeeler());
		
		assertTrue(apple.getIsPeeled());
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
		apple.setColour(Colour.Red);
		apple.peelMe(new NormalPeeler());
		
		assertFalse(apple.getIsPeeled());
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
		apple.setColour(Colour.Red);
		apple.peelMe(new NormalPeeler());
		
		assertFalse(apple.getIsPeeled());
	}

	/**
	 * Can not peel me when has worm is not set.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelMeWhenHasWormIsNotSet() throws AppleNotPeeledException {
		apple.setTaste(4);
		apple.setColour(Colour.Red);
		apple.peelMe(new NormalPeeler());
		
		assertFalse(apple.getIsPeeled());
	}

	/**
	 * Can not peel me when has taste is not set.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelMeWhenHasTasteIsNotSet() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setColour(Colour.Red);
		apple.peelMe(new NormalPeeler());
		
		assertFalse(apple.getIsPeeled());
	}

	/**
	 * Can not peel me when colour is not set.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelMeWhenColourIsNotSet() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.peelMe(new NormalPeeler());
		
		assertFalse(apple.getIsPeeled());
	}

	/**
	 * Can not peel me when conditions are not set.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelMeWhenConditionsNotSet() throws AppleNotPeeledException {
		apple.peelMe(new NormalPeeler());
	}
	
	/**
	 * Can not peel me with no peeler.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelMeWhenNoPeeler() throws AppleNotPeeledException {
		apple.setColour(Colour.Blue);
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.peelMe(null);
	}


	/**
	 * Cannot peel blue apples with normal peeler.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void cannotPeelBlueApplesWithNormalPeeler() throws AppleNotPeeledException {
		Peeler peeler = new NormalPeeler();
		apple.setColour(Colour.Blue);
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.peelMe(peeler);
		
		assertFalse(apple.getIsPeeled());
	}

	/**
	 * Can peel blue apples with Valyrian steel.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test
	public void canPeelBlueApplesWithValyrianSteel() throws AppleNotPeeledException {
		Peeler peeler = new ValyrianSteelPeeler();
		apple.setColour(Colour.Blue);
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.peelMe(peeler);
		
		assertTrue(apple.getIsPeeled());
	}

	/**
	 * Can peel any apple with Valyrian steel.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test
	public void canPeelAnyAppleWithValyrianSteel() throws AppleNotPeeledException {
		Peeler peeler = new ValyrianSteelPeeler();
		apple.setColour(Colour.Red);
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.peelMe(peeler);
		
		assertTrue(apple.getIsPeeled());
	}

	/**
	 * Can eat me.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test
	public void canEatMe() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.setColour(Colour.Red);
		apple.peelMe(new NormalPeeler());
		apple.eatMe();
	}
	
	/**
	 * Cannot eat me when unpeeled.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void cannotEatMeWhenUnpeeled() throws AppleNotPeeledException {
		apple.eatMe();
	}

}
