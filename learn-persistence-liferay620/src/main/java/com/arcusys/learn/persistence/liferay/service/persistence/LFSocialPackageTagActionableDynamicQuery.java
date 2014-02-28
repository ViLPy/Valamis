package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag;
import com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSocialPackageTagActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSocialPackageTagActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFSocialPackageTagLocalServiceUtil.getService());
        setClass(LFSocialPackageTag.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
