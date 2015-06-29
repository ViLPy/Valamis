package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage;
import com.arcusys.learn.persistence.liferay.service.LFTCClntApiStorageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTCClntApiStorageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTCClntApiStorageActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFTCClntApiStorageLocalServiceUtil.getService());
        setClass(LFTCClntApiStorage.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
