package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackage;
import com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSocialPackageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSocialPackageActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFSocialPackageLocalServiceUtil.getService());
        setClass(LFSocialPackage.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
