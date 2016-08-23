package org.codeslik.moneysupermarket.apple.peeler;

import static org.junit.Assert.*;

import org.codeslik.moneysupermarket.apple.Apple;
import org.codeslik.moneysupermarket.apple.Colour;
import org.codeslik.moneysupermarket.apple.exception.AppleNotPeeledException;
import org.junit.Before;
import org.junit.Test;

/**
 * The ValyrianSteelPeelerTest Class.
 */
public class ValyrianSteelPeelerTest {

	/** The apple. */
	private Apple apple;
	
	/** The peeler under test. */
	private ValyrianSteelPeeler peeler = new ValyrianSteelPeeler();
	
	/**
	 * Setup the tests.
	 */
	@Before
	public void setUp() {
		apple = new Apple();
		peeler = new ValyrianSteelPeeler();
	}

	/**
	 * Can create Valyrian steel peeler.
	 */
	@Test
	public void canCreateValyrianSteelPeeler() {
		assertNotNull(peeler);
	}

	/**
	 * Must provide an apple to a Valyrian steel peeler.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void mustProvideAnAppleToAValyrianSteelPeeler() throws AppleNotPeeledException {
		peeler.peel(null);
	}

	/**
	 * Can not peel an apple when conditions not set.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelAnAppleWhenConditionsNotSet() throws AppleNotPeeledException {
		peeler.peel(apple);

		assertFalse(apple.getIsPeeled());
	}

	/**
	 * Can peel a blue apple.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	public void canPeelABlueApple() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.setColour(Colour.Blue);
		peeler.peel(apple);
		
		assertTrue(apple.getIsPeeled());
	}

	/**
	 * Can peel a red apple.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	public void canPeelARedApple() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.setColour(Colour.Red);
		peeler.peel(apple);
		
		assertTrue(apple.getIsPeeled());
	}

	/**
	 * Can peel a green apple.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	public void canPeelAGreenApple() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.setColour(Colour.Green);
		peeler.peel(apple);
		
		assertTrue(apple.getIsPeeled());
	}
}
