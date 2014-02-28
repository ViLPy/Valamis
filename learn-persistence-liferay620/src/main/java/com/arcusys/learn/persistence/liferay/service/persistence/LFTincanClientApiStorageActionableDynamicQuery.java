package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage;
import com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanClientApiStorageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanClientApiStorageActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanClientApiStorageLocalServiceUtil.getService());
        setClass(LFTincanClientApiStorage.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
