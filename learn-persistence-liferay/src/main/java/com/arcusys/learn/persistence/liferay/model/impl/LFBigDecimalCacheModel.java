package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFBigDecimal;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.math.BigDecimal;

/**
* The cache model class for representing LFBigDecimal in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFBigDecimal
* @generated
*/
public class LFBigDecimalCacheModel implements CacheModel<LFBigDecimal>,
    Serializable {
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

    public LFBigDecimal toEntityModel() {
        LFBigDecimalImpl lfBigDecimalImpl = new LFBigDecimalImpl();

        lfBigDecimalImpl.setId(id);
        lfBigDecimalImpl.setDecimal(decimal);
        lfBigDecimalImpl.setText(text);

        lfBigDecimalImpl.resetOriginalValues();

        return lfBigDecimalImpl;
    }
}
