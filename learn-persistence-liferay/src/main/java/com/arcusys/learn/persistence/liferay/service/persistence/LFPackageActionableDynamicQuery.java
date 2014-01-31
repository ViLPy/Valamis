package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackage;
import com.arcusys.learn.persistence.liferay.service.LFPackageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFPackageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFPackageActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFPackageLocalServiceUtil.getService());
        setClass(LFPackage.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
