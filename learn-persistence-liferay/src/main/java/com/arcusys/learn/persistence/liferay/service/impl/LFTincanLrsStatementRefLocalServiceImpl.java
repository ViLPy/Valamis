package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsStatementRefLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan lrs statement ref local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsStatementRefLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil
 */
public class LFTincanLrsStatementRefLocalServiceImpl
    extends LFTincanLrsStatementRefLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil} to access the l f tincan lrs statement ref local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsStatementRefPersistence.removeAll();
    }

    public LFTincanLrsStatementRef createLFTincanLrsStatementRef() throws SystemException {
        return createLFTincanLrsStatementRef(counterLocalService.increment(LFTincanLrsStatementRef.class.getName()));
    }
}
