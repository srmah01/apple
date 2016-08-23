package org.codeslik.moneysupermarket.apple.peeler;

import org.codeslik.moneysupermarket.apple.Apple;
import org.codeslik.moneysupermarket.apple.exception.AppleNotPeeledException;

/**
 * The NormalPeeler Class.
 */
public class NormalPeeler implements Peeler {

	/* (non-Javadoc)
	 * @see org.codeslik.moneysupermarket.apple.peeler.Peeler#peel(org.codeslik.moneysupermarket.apple.Apple)
	 */
	@Override
	public void peel(Apple apple) throws AppleNotPeeledException {
		if (apple == null) {
			throw new AppleNotPeeledException("An apple is required.");
		}
		apple.peelMe(this);
	}

}
