/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Myriad Mobile
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.tylereastman.library.betterpath;

import android.graphics.Path;
import android.os.Parcel;

/**
 * @see android.graphics.Path#setLastPoint(float, float)
 */
public class SetLastPointOp extends AbstractPathOp {

    private final float dx;
    private final float dy;

    public SetLastPointOp(float dx, float dy) {
        super(null);
        this.dx = dx;
        this.dy = dy;
    }

    public SetLastPointOp(Parcel parcel) {
        super(parcel);

        dx = parcel.readFloat();
        dy = parcel.readFloat();
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.SET_LAST_POINT_OP;
    }

    @Override
    void applyToPath(Path path) {
        path.setLastPoint(dx, dy);
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeFloat(dx);
        parcel.writeFloat(dy);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof SetLastPointOp)) {
            return false;
        }

        SetLastPointOp other = (SetLastPointOp) o;

        return dx == other.dx &&
                dy == other.dy;
    }

    @Override
    public int hashCode() {
        int result = 63;
        result = 31 * result + Float.floatToIntBits(dx);
        result = 31 * result + Float.floatToIntBits(dy);
        return result;
    }
}
