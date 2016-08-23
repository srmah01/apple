package org.codeslik.moneysupermarket.apple.peeler;

import org.codeslik.moneysupermarket.apple.Apple;
import org.codeslik.moneysupermarket.apple.exception.AppleNotPeeledException;

/**
 * The Peeler Interface.
 */
public interface Peeler {
	
	/**
	 * Peel an apple.
	 *
	 * @param apple the apple
	 * @throws AppleNotPeeledException the apple not peeled exception
	 */
	void peel(Apple apple) throws AppleNotPeeledException;
}
