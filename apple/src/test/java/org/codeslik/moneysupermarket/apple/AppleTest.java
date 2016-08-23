package org.codeslik.moneysupermarket.apple;

import static org.junit.Assert.*;

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

}
