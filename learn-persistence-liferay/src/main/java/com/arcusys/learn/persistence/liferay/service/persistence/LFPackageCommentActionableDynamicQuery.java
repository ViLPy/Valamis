package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageComment;
import com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFPackageCommentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFPackageCommentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFPackageCommentLocalServiceUtil.getService());
        setClass(LFPackageComment.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
