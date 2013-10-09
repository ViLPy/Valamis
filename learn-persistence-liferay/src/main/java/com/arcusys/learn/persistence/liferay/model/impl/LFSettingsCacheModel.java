package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSettings;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFSettings in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFSettings
* @generated
*/
public class LFSettingsCacheModel implements CacheModel<LFSettings>,
    Serializable {
    public long id;
    public String key;
    public String value;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", key=");
        sb.append(key);
        sb.append(", value=");
        sb.append(value);
        sb.append("}");

        return sb.toString();
    }

    public LFSettings toEntityModel() {
        LFSettingsImpl lfSettingsImpl = new LFSettingsImpl();

        lfSettingsImpl.setId(id);

        if (key == null) {
            lfSettingsImpl.setKey(StringPool.BLANK);
        } else {
            lfSettingsImpl.setKey(key);
        }

        if (value == null) {
            lfSettingsImpl.setValue(StringPool.BLANK);
        } else {
            lfSettingsImpl.setValue(value);
        }

        lfSettingsImpl.resetOriginalValues();

        return lfSettingsImpl;
    }
}
