/**
 * SOCResetStatistics.java
 *
 * Creates message to reset the statistics for a user
 *
 * Created on February 27, 2005, 12:34 PM
 *
 * @author Jim Browan
 *
 * Java Settlers - An online multiplayer version of the game Settlers of Catan
 * Copyright (C) 2003  Robert S. Thomas
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * The author of this program can be reached at thomas@infolab.northwestern.edu
 **/
package soc.message;

import java.util.StringTokenizer;


/**
 * This message is a reset statistics for an account
 *
 * @author Jim Browan
 **/
public class SOCResetStatistics extends SOCMessage
{
    /**
     * Nickname
     */
    private String nickname;

    /**
     * Password
     */
    private String password;

    /**
     * Create a Reset Statistics message.
     *
     * @param nn  nickname
     * @param pw  password
     **/
    public SOCResetStatistics(String nn, String pw)
    {
        messageType = RESETSTATS;
        nickname = nn;
        password = pw;
    }

    /**
     * @return the nickname
     **/
    public String getNickname()
    {
        return nickname;
    }

    /**
     * @return the password
     **/
    public String getPassword()
    {
        return password;
    }

    /**
     * RESETSTATS sep nickname sep2 password
     *
     * @return the command String
     **/
    public String toCmd()
    {
        return toCmd(nickname, password);
    }

    /**
     * RESETSTATS sep nickname sep2 password
     *
     * @param nn  the nickname
     * @param pw  the password
     **/
    public static String toCmd(String nn, String pw)
    {
        return RESETSTATS + sep + nn + sep2 + pw;
    }

    /**
     * Parse the command String into a ResetStatistics message
     *
     * @param s   the String to parse
     * @return    a ResetStatistics message, or null if the data is garbled
     **/
    public static SOCResetStatistics parseDataStr(String s)
    {
        String nn;
        String pw;

        StringTokenizer st = new StringTokenizer(s, sep2);

        try
        {
            nn = st.nextToken();
            pw = st.nextToken();
        }
        catch (Exception e)
        {
            return null;
        }

        return new SOCResetStatistics(nn, pw);
    }

    /**
     * @return a human readable form of the message
     **/
    public String toString()
    {
        String s = "SOCResetStatistics:nickname=" + nickname + "|password=" + password;

        return s;
    }
}

