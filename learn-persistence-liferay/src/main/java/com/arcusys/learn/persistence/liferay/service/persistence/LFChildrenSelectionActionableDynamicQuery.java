package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFChildrenSelection;
import com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFChildrenSelectionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFChildrenSelectionActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFChildrenSelectionLocalServiceUtil.getService());
        setClass(LFChildrenSelection.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
