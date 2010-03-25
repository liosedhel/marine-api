/* 
 * SentenceEvent.java
 * Copyright (C) 2010 Kimmo Tuukkanen
 * 
 * This file is part of Java Marine API.
 * <http://sourceforge.net/projects/marineapi/>
 * 
 * Java Marine API is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Java Marine API is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java Marine API. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.marineapi.nmea.event;

import java.util.Date;
import java.util.EventObject;

import net.sf.marineapi.nmea.sentence.Sentence;

/**
 * Sentence events occur when a valid NMEA 0183 sentence has been read from the
 * data source.
 * 
 * @author Kimmo Tuukkanen
 * @version $Revision$
 */
public class SentenceEvent extends EventObject {

    private static final long serialVersionUID = -2756954014186470514L;
    private final long timestamp;
    private final Sentence sentence;

    /**
     * Creates a new SentenceEvent object.
     * 
     * @param src <code>Object</code> that fired the event
     * @param s Sentence that triggered the event
     * @throws IllegalArgumentException If specified sentence is <code>null</code>
     */
    public SentenceEvent(Object src, Sentence s) {
        super(src);
        timestamp = System.currentTimeMillis();
        if (s == null) {
            throw new IllegalArgumentException("Sentence cannot be null");
        }
        this.sentence = s;
    }

    /**
     * Get time stamp when this event was created.
     * 
     * @return Date
     */
    public Date getTimeStamp() {
        return new Date(timestamp);
    }

    /**
     * Gets the Sentence object that triggered the event.
     * 
     * @return Sentence object
     */
    public Sentence getSentence() {
        return sentence;
    }
}