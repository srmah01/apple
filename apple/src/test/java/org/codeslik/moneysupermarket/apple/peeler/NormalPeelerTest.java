package org.codeslik.moneysupermarket.apple.peeler;

import static org.junit.Assert.*;

import org.codeslik.moneysupermarket.apple.Apple;
import org.codeslik.moneysupermarket.apple.Colour;
import org.codeslik.moneysupermarket.apple.exception.AppleNotPeeledException;
import org.junit.Before;
import org.junit.Test;

/**
 * The NormalPeelerTest Class.
 */
public class NormalPeelerTest {

	/** The apple. */
	private Apple apple;
	
	/** The peeler under test. */
	private NormalPeeler peeler = new NormalPeeler();
	
	/**
	 * Setup the tests.
	 */
	@Before
	public void setUp() {
		apple = new Apple();
		peeler = new NormalPeeler();
	}

	/**
	 * Can create normal peeler.
	 */
	@Test
	public void canCreateNormalPeeler() {
		assertNotNull(peeler);
	}
	
	/**
	 * Must provide an apple to a normal peeler.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void mustProvideAnAppleToANormalPeeler() throws AppleNotPeeledException {
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

	/**
	 * Can not peel a blue apple with normal peeler.
	 *
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	@Test(expected=AppleNotPeeledException.class)
	public void canNotPeelABlueAppleWithNormalPeeler() throws AppleNotPeeledException {
		apple.setHasWorm(false);
		apple.setTaste(4);
		apple.setColour(Colour.Blue);
		peeler.peel(apple);
		
		assertFalse(apple.getIsPeeled());
	}

}
