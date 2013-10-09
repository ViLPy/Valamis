package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSetting;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFSetting in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFSetting
* @generated
*/
public class LFSettingCacheModel implements CacheModel<LFSetting>, Serializable {
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

    public LFSetting toEntityModel() {
        LFSettingImpl lfSettingImpl = new LFSettingImpl();

        lfSettingImpl.setId(id);

        if (key == null) {
            lfSettingImpl.setKey(StringPool.BLANK);
        } else {
            lfSettingImpl.setKey(key);
        }

        if (value == null) {
            lfSettingImpl.setValue(StringPool.BLANK);
        } else {
            lfSettingImpl.setValue(value);
        }

        lfSettingImpl.resetOriginalValues();

        return lfSettingImpl;
    }
}
