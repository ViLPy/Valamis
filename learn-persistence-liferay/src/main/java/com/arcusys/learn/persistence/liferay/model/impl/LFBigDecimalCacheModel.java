package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFBigDecimal;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFBigDecimal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFBigDecimal
 * @generated
 */
public class LFBigDecimalCacheModel implements CacheModel<LFBigDecimal>,
    Externalizable {
    public long id;
    public BigDecimal decimal;
    public String text;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", decimal=");
        sb.append(decimal);
        sb.append(", text=");
        sb.append(text);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFBigDecimal toEntityModel() {
        LFBigDecimalImpl lfBigDecimalImpl = new LFBigDecimalImpl();

        lfBigDecimalImpl.setId(id);
        lfBigDecimalImpl.setDecimal(decimal);

        if (text == null) {
            lfBigDecimalImpl.setText(StringPool.BLANK);
        } else {
            lfBigDecimalImpl.setText(text);
        }

        lfBigDecimalImpl.resetOriginalValues();

        return lfBigDecimalImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput)
        throws ClassNotFoundException, IOException {
        id = objectInput.readLong();
        decimal = (BigDecimal) objectInput.readObject();
        text = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeObject(decimal);

        if (text == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(text);
        }
    }
}
