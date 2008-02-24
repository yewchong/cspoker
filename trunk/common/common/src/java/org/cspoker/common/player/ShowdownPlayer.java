/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.common.player;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.cspoker.common.elements.cards.Card;

public class ShowdownPlayer implements Serializable {

	private static final long serialVersionUID = -1618593137613219527L;

	private Player player;
	
	@XmlElementWrapper
	@XmlElement(name="card")
	private Set<Card> cards;

	private String description;

	public ShowdownPlayer(Player player, Set<Card> cards, String description) {
		this.player = player;
		this.cards = Collections.unmodifiableSet(cards);
		this.description = description;
	}
	
	protected ShowdownPlayer() {
		// no op
	}

	/**
	 * Returns a textual representation of this showdown player.
	 */
	@Override
	public String toString() {
		return player.getName() + " has a " + description;
	}

	public Player getPlayer() {
		return player;
	}

	public Set<Card> getHandCards() {
		return cards;
	}

	public String getHandDescription() {
		return description;
	}

}