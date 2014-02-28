package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsEndpointLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f tincan lrs endpoint local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsEndpointLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil
 */
public class LFTincanLrsEndpointLocalServiceImpl
    extends LFTincanLrsEndpointLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil} to access the l f tincan lrs endpoint local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsEndpointPersistence.removeAll();
    }

    public LFTincanLrsEndpoint getEndpoint() throws SystemException {
        List<LFTincanLrsEndpoint> endpoints = lfTincanLrsEndpointPersistence.findAll();

        switch (endpoints.size()) {
            case 1: return endpoints.get(0);
            case 0: return null;
            default: return endpoints.get(endpoints.size()-1);
        }
    }

    public void setEndpoint(String endpoint, String authType, String key, String secret) throws SystemException {
        lfTincanLrsEndpointPersistence.removeAll();

        LFTincanLrsEndpoint newEntity = lfTincanLrsEndpointPersistence.create(counterLocalService.increment(LFTincanLrsEndpoint.class.getName()));

        newEntity.setEndpoint(endpoint);
        newEntity.setAuthType(authType);
        newEntity.setKey(key);
        newEntity.setSecret(secret);

        lfTincanLrsEndpointPersistence.update(newEntity, true);
    }
}
