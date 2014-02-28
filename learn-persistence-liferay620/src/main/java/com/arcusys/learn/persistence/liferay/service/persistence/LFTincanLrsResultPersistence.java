package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan lrs result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsResultPersistenceImpl
 * @see LFTincanLrsResultUtil
 * @generated
 */
public interface LFTincanLrsResultPersistence extends BasePersistence<LFTincanLrsResult> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanLrsResultUtil} to access the l f tincan lrs result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f tincan lrs result in the entity cache if it is enabled.
    *
    * @param lfTincanLrsResult the l f tincan lrs result
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult lfTincanLrsResult);

    /**
    * Caches the l f tincan lrs results in the entity cache if it is enabled.
    *
    * @param lfTincanLrsResults the l f tincan lrs results
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult> lfTincanLrsResults);

    /**
    * Creates a new l f tincan lrs result with the primary key. Does not add the l f tincan lrs result to the database.
    *
    * @param id the primary key for the new l f tincan lrs result
    * @return the new l f tincan lrs result
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult create(
        long id);

    /**
    * Removes the l f tincan lrs result with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs result
    * @return the l f tincan lrs result that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException if a l f tincan lrs result with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult lfTincanLrsResult)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs result with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs result
    * @return the l f tincan lrs result
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException if a l f tincan lrs result with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs result with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs result
    * @return the l f tincan lrs result, or <code>null</code> if a l f tincan lrs result with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs results.
    *
    * @return the l f tincan lrs results
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan lrs results.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs results
    * @param end the upper bound of the range of l f tincan lrs results (not inclusive)
    * @return the range of l f tincan lrs results
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan lrs results.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs results
    * @param end the upper bound of the range of l f tincan lrs results (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs results
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs results from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs results.
    *
    * @return the number of l f tincan lrs results
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
