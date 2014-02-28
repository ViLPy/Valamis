package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRole;
import com.arcusys.learn.persistence.liferay.service.LFRoleLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFRoleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFRoleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFRoleLocalServiceUtil.getService());
        setClass(LFRole.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
