package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsResultLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan lrs result local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsResultLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalServiceUtil
 */
public class LFTincanLrsResultLocalServiceImpl
    extends LFTincanLrsResultLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalServiceUtil} to access the l f tincan lrs result local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsResultPersistence.removeAll();
    }

    public LFTincanLrsResult createLFTincanLrsResult() throws SystemException {
        return createLFTincanLrsResult(counterLocalService.increment(LFTincanLrsResult.class.getName()));
    }
}
