package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsEndpointActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsEndpointActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanLrsEndpointLocalServiceUtil.getService());
        setClass(LFTincanLrsEndpoint.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
