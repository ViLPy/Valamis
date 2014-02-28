package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSequencing;
import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFSequencingActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFSequencingActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFSequencingLocalServiceUtil.getService());
        setClass(LFSequencing.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
