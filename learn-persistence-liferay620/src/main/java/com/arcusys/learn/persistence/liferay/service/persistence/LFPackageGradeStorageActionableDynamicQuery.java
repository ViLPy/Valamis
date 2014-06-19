package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage;
import com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFPackageGradeStorageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFPackageGradeStorageActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFPackageGradeStorageLocalServiceUtil.getService());
        setClass(LFPackageGradeStorage.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.userId");
    }
}
