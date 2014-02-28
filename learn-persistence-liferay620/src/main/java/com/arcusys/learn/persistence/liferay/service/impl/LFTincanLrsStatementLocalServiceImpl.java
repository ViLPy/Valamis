package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsStatementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan lrs statement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsStatementLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil
 */
public class LFTincanLrsStatementLocalServiceImpl
    extends LFTincanLrsStatementLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil} to access the l f tincan lrs statement local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsStatementPersistence.removeAll();
    }

    public LFTincanLrsStatement createLFTincanLrsStatement() throws SystemException {
        return createLFTincanLrsStatement(counterLocalService.increment(LFTincanLrsStatement.class.getName()));
    }

    public java.util.List<LFTincanLrsStatement> findByActorID(Integer actorID) throws SystemException{
        return lfTincanLrsStatementPersistence.findByActorID(actorID);
    }

    public java.util.List<LFTincanLrsStatement> findByVerbID(String verbID) throws SystemException{
        return lfTincanLrsStatementPersistence.findByVerbID(verbID);
    }

    public java.util.List<LFTincanLrsStatement> findByObjTypeAndObjID(String objType, Integer objID) throws SystemException{
        return lfTincanLrsStatementPersistence.findByObjTypeAndObjID(objType, objID);
    }

    public LFTincanLrsStatement findByTincanID(String tincanID) throws SystemException, NoSuchLFTincanLrsStatementException {
        return lfTincanLrsStatementPersistence.findByTincanID(tincanID);
    }
}
