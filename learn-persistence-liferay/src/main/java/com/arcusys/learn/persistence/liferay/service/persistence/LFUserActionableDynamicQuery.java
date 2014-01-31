package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFUser;
import com.arcusys.learn.persistence.liferay.service.LFUserLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFUserActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFUserActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFUserLocalServiceUtil.getService());
        setClass(LFUser.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("lfid");
    }
}
