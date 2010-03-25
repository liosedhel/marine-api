/* 
 * DataStatus.java
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
package net.sf.marineapi.nmea.util;

/**
 * DataStatus defines the validity of data being broadcasted by an NMEA device.
 * 
 * @author Kimmo Tuukkanen
 * @version $Revision$
 */
public enum DataStatus {

    /** Valid data available, may also indicate boolean value <code>true</code>. */
    VALID('V'),

    /**
     * No valid data available, may also indicate boolean value
     * <code>false</code>.
     */
    INVALID('A');

    private final char character;

    DataStatus(char ch) {
        character = ch;
    }

    /**
     * Returns the character used in NMEA sentences to indicate the status.
     * @return Char indicator for DataStatus
     */
    public char toChar() {
        return character;
    }

    /**
     * Returns the DataStatus enum for status char used in sentences.
     * 
     * @param ch Status char
     * @return DataStatus or <code>null</code> if invalid char was specified.
     */
    public static DataStatus valueOf(char ch) {
        for (DataStatus ds : values()) {
            if (ds.toChar() == ch) {
                return ds;
            }
        }
        return null;
    }
}