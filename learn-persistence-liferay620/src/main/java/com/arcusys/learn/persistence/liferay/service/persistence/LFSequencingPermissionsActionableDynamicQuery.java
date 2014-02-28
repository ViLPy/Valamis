package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions;
import com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSequencingPermissionsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSequencingPermissionsActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFSequencingPermissionsLocalServiceUtil.getService());
        setClass(LFSequencingPermissions.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
