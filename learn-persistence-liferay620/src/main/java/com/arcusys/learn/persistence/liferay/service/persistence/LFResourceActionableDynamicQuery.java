package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFResource;
import com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFResourceActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFResourceActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFResourceLocalServiceUtil.getService());
        setClass(LFResource.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
