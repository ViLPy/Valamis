package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan lrs context service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsContextPersistenceImpl
 * @see LFTincanLrsContextUtil
 * @generated
 */
public interface LFTincanLrsContextPersistence extends BasePersistence<LFTincanLrsContext> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanLrsContextUtil} to access the l f tincan lrs context persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f tincan lrs context in the entity cache if it is enabled.
    *
    * @param lfTincanLrsContext the l f tincan lrs context
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext lfTincanLrsContext);

    /**
    * Caches the l f tincan lrs contexts in the entity cache if it is enabled.
    *
    * @param lfTincanLrsContexts the l f tincan lrs contexts
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext> lfTincanLrsContexts);

    /**
    * Creates a new l f tincan lrs context with the primary key. Does not add the l f tincan lrs context to the database.
    *
    * @param id the primary key for the new l f tincan lrs context
    * @return the new l f tincan lrs context
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext create(
        long id);

    /**
    * Removes the l f tincan lrs context with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs context
    * @return the l f tincan lrs context that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException if a l f tincan lrs context with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext lfTincanLrsContext,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs context with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs context
    * @return the l f tincan lrs context
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException if a l f tincan lrs context with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs context with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs context
    * @return the l f tincan lrs context, or <code>null</code> if a l f tincan lrs context with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs contexts.
    *
    * @return the l f tincan lrs contexts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan lrs contexts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs contexts
    * @param end the upper bound of the range of l f tincan lrs contexts (not inclusive)
    * @return the range of l f tincan lrs contexts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan lrs contexts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs contexts
    * @param end the upper bound of the range of l f tincan lrs contexts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs contexts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs contexts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs contexts.
    *
    * @return the number of l f tincan lrs contexts
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
