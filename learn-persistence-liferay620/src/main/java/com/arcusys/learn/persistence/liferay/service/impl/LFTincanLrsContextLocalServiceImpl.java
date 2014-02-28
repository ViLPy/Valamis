package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsContextLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan lrs context local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsContextLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalServiceUtil
 */
public class LFTincanLrsContextLocalServiceImpl
    extends LFTincanLrsContextLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalServiceUtil} to access the l f tincan lrs context local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsContextPersistence.removeAll();
    }

    public LFTincanLrsContext createLFTincanLrsContext() throws SystemException {
        return createLFTincanLrsContext(counterLocalService.increment(LFTincanLrsContext.class.getName()));
    }
}
