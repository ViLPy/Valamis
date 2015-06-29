package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSeqPermissions;
import com.arcusys.learn.persistence.liferay.service.LFSeqPermissionsLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSeqPermissionsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSeqPermissionsActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFSeqPermissionsLocalServiceUtil.getService());
        setClass(LFSeqPermissions.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
