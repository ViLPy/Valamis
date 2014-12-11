package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException;
import com.arcusys.learn.persistence.liferay.model.LFTincanURI;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanURILocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan u r i local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanURILocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanURILocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanURILocalServiceUtil
 */
public class LFTincanURILocalServiceImpl extends LFTincanURILocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanURILocalServiceUtil} to access the l f tincan u r i local service.
     */

    public void removeAll() throws SystemException {
        lfTincanURIPersistence.removeAll();
    }

    public LFTincanURI findURI(String objId, String objType) throws SystemException, NoSuchLFTincanURIException {
        return lfTincanURIPersistence.findByURI(objId, objType);
    }

}
