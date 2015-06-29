package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFLessonLimit;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f lesson limit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFLessonLimitPersistenceImpl
 * @see LFLessonLimitUtil
 * @generated
 */
public interface LFLessonLimitPersistence extends BasePersistence<LFLessonLimit> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFLessonLimitUtil} to access the l f lesson limit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f lesson limits where itemID = &#63;.
    *
    * @param itemID the item i d
    * @return the matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findByIDs(
        java.lang.Long itemID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f lesson limits where itemID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemID the item i d
    * @param start the lower bound of the range of l f lesson limits
    * @param end the upper bound of the range of l f lesson limits (not inclusive)
    * @return the range of matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findByIDs(
        java.lang.Long itemID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f lesson limits where itemID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemID the item i d
    * @param start the lower bound of the range of l f lesson limits
    * @param end the upper bound of the range of l f lesson limits (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findByIDs(
        java.lang.Long itemID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f lesson limit in the ordered set where itemID = &#63;.
    *
    * @param itemID the item i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f lesson limit
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit findByIDs_First(
        java.lang.Long itemID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f lesson limit in the ordered set where itemID = &#63;.
    *
    * @param itemID the item i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchByIDs_First(
        java.lang.Long itemID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f lesson limit in the ordered set where itemID = &#63;.
    *
    * @param itemID the item i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f lesson limit
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit findByIDs_Last(
        java.lang.Long itemID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f lesson limit in the ordered set where itemID = &#63;.
    *
    * @param itemID the item i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchByIDs_Last(
        java.lang.Long itemID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f lesson limits before and after the current l f lesson limit in the ordered set where itemID = &#63;.
    *
    * @param lfLessonLimitPK the primary key of the current l f lesson limit
    * @param itemID the item i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f lesson limit
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit[] findByIDs_PrevAndNext(
        LFLessonLimitPK lfLessonLimitPK, java.lang.Long itemID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f lesson limits where itemID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemIDs the item i ds
    * @return the matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findByIDs(
        java.lang.Long[] itemIDs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f lesson limits where itemID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemIDs the item i ds
    * @param start the lower bound of the range of l f lesson limits
    * @param end the upper bound of the range of l f lesson limits (not inclusive)
    * @return the range of matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findByIDs(
        java.lang.Long[] itemIDs, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f lesson limits where itemID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemIDs the item i ds
    * @param start the lower bound of the range of l f lesson limits
    * @param end the upper bound of the range of l f lesson limits (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findByIDs(
        java.lang.Long[] itemIDs, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f lesson limits where itemID = &#63; from the database.
    *
    * @param itemID the item i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByIDs(java.lang.Long itemID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f lesson limits where itemID = &#63;.
    *
    * @param itemID the item i d
    * @return the number of matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public int countByIDs(java.lang.Long itemID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f lesson limits where itemID = any &#63;.
    *
    * @param itemIDs the item i ds
    * @return the number of matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public int countByIDs(java.lang.Long[] itemIDs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException} if it could not be found.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @return the matching l f lesson limit
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit findByItemIDAndItemType(
        java.lang.Long itemID, java.lang.String itemType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @return the matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchByItemIDAndItemType(
        java.lang.Long itemID, java.lang.String itemType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchByItemIDAndItemType(
        java.lang.Long itemID, java.lang.String itemType,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f lesson limit where itemID = &#63; and itemType = &#63; from the database.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @return the l f lesson limit that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit removeByItemIDAndItemType(
        java.lang.Long itemID, java.lang.String itemType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f lesson limits where itemID = &#63; and itemType = &#63;.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @return the number of matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public int countByItemIDAndItemType(java.lang.Long itemID,
        java.lang.String itemType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f lesson limit in the entity cache if it is enabled.
    *
    * @param lfLessonLimit the l f lesson limit
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFLessonLimit lfLessonLimit);

    /**
    * Caches the l f lesson limits in the entity cache if it is enabled.
    *
    * @param lfLessonLimits the l f lesson limits
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> lfLessonLimits);

    /**
    * Creates a new l f lesson limit with the primary key. Does not add the l f lesson limit to the database.
    *
    * @param lfLessonLimitPK the primary key for the new l f lesson limit
    * @return the new l f lesson limit
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit create(
        LFLessonLimitPK lfLessonLimitPK);

    /**
    * Removes the l f lesson limit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfLessonLimitPK the primary key of the l f lesson limit
    * @return the l f lesson limit that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit remove(
        LFLessonLimitPK lfLessonLimitPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFLessonLimit lfLessonLimit)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f lesson limit with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException} if it could not be found.
    *
    * @param lfLessonLimitPK the primary key of the l f lesson limit
    * @return the l f lesson limit
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit findByPrimaryKey(
        LFLessonLimitPK lfLessonLimitPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f lesson limit with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfLessonLimitPK the primary key of the l f lesson limit
    * @return the l f lesson limit, or <code>null</code> if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchByPrimaryKey(
        LFLessonLimitPK lfLessonLimitPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f lesson limits.
    *
    * @return the l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f lesson limits.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f lesson limits
    * @param end the upper bound of the range of l f lesson limits (not inclusive)
    * @return the range of l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f lesson limits.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f lesson limits
    * @param end the upper bound of the range of l f lesson limits (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f lesson limits from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f lesson limits.
    *
    * @return the number of l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
