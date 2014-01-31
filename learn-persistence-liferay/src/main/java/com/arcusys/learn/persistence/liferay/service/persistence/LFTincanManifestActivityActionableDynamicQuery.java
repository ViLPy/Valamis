package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity;
import com.arcusys.learn.persistence.liferay.service.LFTincanManifestActivityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanManifestActivityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanManifestActivityActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanManifestActivityLocalServiceUtil.getService());
        setClass(LFTincanManifestActivity.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
