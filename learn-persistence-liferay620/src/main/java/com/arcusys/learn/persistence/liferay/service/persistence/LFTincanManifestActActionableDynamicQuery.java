package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct;
import com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanManifestActActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanManifestActActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanManifestActLocalServiceUtil.getService());
        setClass(LFTincanManifestAct.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
