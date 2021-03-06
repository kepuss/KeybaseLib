/*
 * Copyright (C) 2015 Dominik Schürmann <dominik@dominikschuermann.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.textuality.keybase.lib;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public class DefaultKeybaseUrlConnectionClient implements KeybaseUrlConnectionClient {

    @Override
    public HttpURLConnection openConnection(URL url, Proxy proxy, boolean isKeybase) throws IOException {
        HttpURLConnection conn;
        if (proxy == null) {
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(25000);
        } else {
            conn = (HttpURLConnection) url.openConnection(proxy);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(40000);
        }
        return conn;
    }

    @Override
    public String getKeybaseBaseUrl() {
        return "https://keybase.io/";
    }
}
