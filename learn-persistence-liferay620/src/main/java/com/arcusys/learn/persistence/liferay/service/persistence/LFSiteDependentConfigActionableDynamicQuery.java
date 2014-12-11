package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig;
import com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSiteDependentConfigActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSiteDependentConfigActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFSiteDependentConfigLocalServiceUtil.getService());
        setClass(LFSiteDependentConfig.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
