package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanURI;
import com.arcusys.learn.persistence.liferay.service.LFTincanURILocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanURIActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanURIActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFTincanURILocalServiceUtil.getService());
        setClass(LFTincanURI.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("uri");
    }
}
