package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFLessonLimit;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f lesson limit service. This utility wraps {@link LFLessonLimitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFLessonLimitPersistence
 * @see LFLessonLimitPersistenceImpl
 * @generated
 */
public class LFLessonLimitUtil {
    private static LFLessonLimitPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(LFLessonLimit lfLessonLimit) {
        getPersistence().clearCache(lfLessonLimit);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFLessonLimit> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFLessonLimit> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFLessonLimit> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFLessonLimit update(LFLessonLimit lfLessonLimit)
        throws SystemException {
        return getPersistence().update(lfLessonLimit);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFLessonLimit update(LFLessonLimit lfLessonLimit,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfLessonLimit, serviceContext);
    }

    /**
    * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException} if it could not be found.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @return the matching l f lesson limit
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit findByItemIDAndItemType(
        java.lang.Long itemID, java.lang.String itemType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByItemIDAndItemType(itemID, itemType);
    }

    /**
    * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @return the matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchByItemIDAndItemType(
        java.lang.Long itemID, java.lang.String itemType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByItemIDAndItemType(itemID, itemType);
    }

    /**
    * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchByItemIDAndItemType(
        java.lang.Long itemID, java.lang.String itemType,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByItemIDAndItemType(itemID, itemType, retrieveFromCache);
    }

    /**
    * Removes the l f lesson limit where itemID = &#63; and itemType = &#63; from the database.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @return the l f lesson limit that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit removeByItemIDAndItemType(
        java.lang.Long itemID, java.lang.String itemType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByItemIDAndItemType(itemID, itemType);
    }

    /**
    * Returns the number of l f lesson limits where itemID = &#63; and itemType = &#63;.
    *
    * @param itemID the item i d
    * @param itemType the item type
    * @return the number of matching l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public static int countByItemIDAndItemType(java.lang.Long itemID,
        java.lang.String itemType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByItemIDAndItemType(itemID, itemType);
    }

    /**
    * Caches the l f lesson limit in the entity cache if it is enabled.
    *
    * @param lfLessonLimit the l f lesson limit
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFLessonLimit lfLessonLimit) {
        getPersistence().cacheResult(lfLessonLimit);
    }

    /**
    * Caches the l f lesson limits in the entity cache if it is enabled.
    *
    * @param lfLessonLimits the l f lesson limits
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> lfLessonLimits) {
        getPersistence().cacheResult(lfLessonLimits);
    }

    /**
    * Creates a new l f lesson limit with the primary key. Does not add the l f lesson limit to the database.
    *
    * @param lfLessonLimitPK the primary key for the new l f lesson limit
    * @return the new l f lesson limit
    */
    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit create(
        LFLessonLimitPK lfLessonLimitPK) {
        return getPersistence().create(lfLessonLimitPK);
    }

    /**
    * Removes the l f lesson limit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfLessonLimitPK the primary key of the l f lesson limit
    * @return the l f lesson limit that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit remove(
        LFLessonLimitPK lfLessonLimitPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(lfLessonLimitPK);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFLessonLimit lfLessonLimit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfLessonLimit);
    }

    /**
    * Returns the l f lesson limit with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException} if it could not be found.
    *
    * @param lfLessonLimitPK the primary key of the l f lesson limit
    * @return the l f lesson limit
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit findByPrimaryKey(
        LFLessonLimitPK lfLessonLimitPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(lfLessonLimitPK);
    }

    /**
    * Returns the l f lesson limit with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfLessonLimitPK the primary key of the l f lesson limit
    * @return the l f lesson limit, or <code>null</code> if a l f lesson limit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFLessonLimit fetchByPrimaryKey(
        LFLessonLimitPK lfLessonLimitPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(lfLessonLimitPK);
    }

    /**
    * Returns all the l f lesson limits.
    *
    * @return the l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFLessonLimit> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f lesson limits from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f lesson limits.
    *
    * @return the number of l f lesson limits
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFLessonLimitPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFLessonLimitPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFLessonLimitPersistence.class.getName());

            ReferenceRegistry.registerReference(LFLessonLimitUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFLessonLimitPersistence persistence) {
    }
}
