/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl.photos;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.*;

public class Photos extends TLPhotos {

    public static final int ID = -1916114267;

    public TLVector<TLPhoto> photos;
    public TLVector<TLUser> users;

    public Photos() {
        this.photos = new TLVector<>();
        this.users = new TLVector<>();
    }

    public Photos(TLVector<TLPhoto> photos, TLVector<TLUser> users){
        this.photos = photos;
        this.users = users;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        photos = (TLVector<TLPhoto>) buffer.readTLObject(APIContext.getInstance());
        users = (TLVector<TLUser>) buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(photos);
        buff.writeTLObject(users);
    }

    public int getConstructor() {
        return ID;
    }
}