package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFFileStorage;
import com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFFileStorageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFFileStorageActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFFileStorageLocalServiceUtil.getService());
        setClass(LFFileStorage.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
