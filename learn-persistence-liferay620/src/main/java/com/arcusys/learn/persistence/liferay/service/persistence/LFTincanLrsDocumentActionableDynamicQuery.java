package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFTincanLrsDocumentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFTincanLrsDocumentActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(LFTincanLrsDocumentLocalServiceUtil.getService());
        setClass(LFTincanLrsDocument.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
