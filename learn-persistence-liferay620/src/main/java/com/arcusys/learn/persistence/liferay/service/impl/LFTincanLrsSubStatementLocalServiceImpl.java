package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsSubStatementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan lrs sub statement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsSubStatementLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalServiceUtil
 */
public class LFTincanLrsSubStatementLocalServiceImpl
    extends LFTincanLrsSubStatementLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalServiceUtil} to access the l f tincan lrs sub statement local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsSubStatementPersistence.removeAll();
    }

    public LFTincanLrsSubStatement createLFTincanLrsSubStatement() throws SystemException {
        return createLFTincanLrsSubStatement(counterLocalService.increment(LFTincanLrsSubStatement.class.getName()));
    }
}
