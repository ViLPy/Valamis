package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsEndpoint in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsEndpoint
* @generated
*/
public class LFTincanLrsEndpointCacheModel implements CacheModel<LFTincanLrsEndpoint>,
    Serializable {
    public long id;
    public String endpoint;
    public String authType;
    public String key;
    public String secret;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", endpoint=");
        sb.append(endpoint);
        sb.append(", authType=");
        sb.append(authType);
        sb.append(", key=");
        sb.append(key);
        sb.append(", secret=");
        sb.append(secret);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsEndpoint toEntityModel() {
        LFTincanLrsEndpointImpl lfTincanLrsEndpointImpl = new LFTincanLrsEndpointImpl();

        lfTincanLrsEndpointImpl.setId(id);
        lfTincanLrsEndpointImpl.setEndpoint(endpoint);
        lfTincanLrsEndpointImpl.setAuthType(authType);
        lfTincanLrsEndpointImpl.setKey(key);
        lfTincanLrsEndpointImpl.setSecret(secret);

        lfTincanLrsEndpointImpl.resetOriginalValues();

        return lfTincanLrsEndpointImpl;
    }
}
