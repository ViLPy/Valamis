package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFBigDecimal;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f big decimal service. This utility wraps {@link LFBigDecimalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFBigDecimalPersistence
 * @see LFBigDecimalPersistenceImpl
 * @generated
 */
public class LFBigDecimalUtil {
    private static LFBigDecimalPersistence _persistence;

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
    public static void clearCache(LFBigDecimal lfBigDecimal) {
        getPersistence().clearCache(lfBigDecimal);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFBigDecimal> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFBigDecimal> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFBigDecimal> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFBigDecimal update(LFBigDecimal lfBigDecimal, boolean merge)
        throws SystemException {
        return getPersistence().update(lfBigDecimal, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFBigDecimal update(LFBigDecimal lfBigDecimal, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfBigDecimal, merge, serviceContext);
    }

    /**
    * Caches the l f big decimal in the entity cache if it is enabled.
    *
    * @param lfBigDecimal the l f big decimal
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFBigDecimal lfBigDecimal) {
        getPersistence().cacheResult(lfBigDecimal);
    }

    /**
    * Caches the l f big decimals in the entity cache if it is enabled.
    *
    * @param lfBigDecimals the l f big decimals
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFBigDecimal> lfBigDecimals) {
        getPersistence().cacheResult(lfBigDecimals);
    }

    /**
    * Creates a new l f big decimal with the primary key. Does not add the l f big decimal to the database.
    *
    * @param id the primary key for the new l f big decimal
    * @return the new l f big decimal
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f big decimal with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f big decimal
    * @return the l f big decimal that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFBigDecimal lfBigDecimal,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfBigDecimal, merge);
    }

    /**
    * Returns the l f big decimal with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException} if it could not be found.
    *
    * @param id the primary key of the l f big decimal
    * @return the l f big decimal
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f big decimal with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f big decimal
    * @return the l f big decimal, or <code>null</code> if a l f big decimal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f big decimals where decimal = &#63;.
    *
    * @param decimal the decimal
    * @return the matching l f big decimals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFBigDecimal> findByDecimal(
        java.math.BigDecimal decimal)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDecimal(decimal);
    }

    /**
    * Returns a range of all the l f big decimals where decimal = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param decimal the decimal
    * @param start the lower bound of the range of l f big decimals
    * @param end the upper bound of the range of l f big decimals (not inclusive)
    * @return the range of matching l f big decimals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFBigDecimal> findByDecimal(
        java.math.BigDecimal decimal, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDecimal(decimal, start, end);
    }

    /**
    * Returns an ordered range of all the l f big decimals where decimal = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param decimal the decimal
    * @param start the lower bound of the range of l f big decimals
    * @param end the upper bound of the range of l f big decimals (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f big decimals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFBigDecimal> findByDecimal(
        java.math.BigDecimal decimal, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDecimal(decimal, start, end, orderByComparator);
    }

    /**
    * Returns the first l f big decimal in the ordered set where decimal = &#63;.
    *
    * @param decimal the decimal
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f big decimal
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a matching l f big decimal could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal findByDecimal_First(
        java.math.BigDecimal decimal,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDecimal_First(decimal, orderByComparator);
    }

    /**
    * Returns the first l f big decimal in the ordered set where decimal = &#63;.
    *
    * @param decimal the decimal
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f big decimal, or <code>null</code> if a matching l f big decimal could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal fetchByDecimal_First(
        java.math.BigDecimal decimal,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByDecimal_First(decimal, orderByComparator);
    }

    /**
    * Returns the last l f big decimal in the ordered set where decimal = &#63;.
    *
    * @param decimal the decimal
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f big decimal
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a matching l f big decimal could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal findByDecimal_Last(
        java.math.BigDecimal decimal,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDecimal_Last(decimal, orderByComparator);
    }

    /**
    * Returns the last l f big decimal in the ordered set where decimal = &#63;.
    *
    * @param decimal the decimal
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f big decimal, or <code>null</code> if a matching l f big decimal could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal fetchByDecimal_Last(
        java.math.BigDecimal decimal,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByDecimal_Last(decimal, orderByComparator);
    }

    /**
    * Returns the l f big decimals before and after the current l f big decimal in the ordered set where decimal = &#63;.
    *
    * @param id the primary key of the current l f big decimal
    * @param decimal the decimal
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f big decimal
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFBigDecimal[] findByDecimal_PrevAndNext(
        long id, java.math.BigDecimal decimal,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDecimal_PrevAndNext(id, decimal, orderByComparator);
    }

    /**
    * Returns all the l f big decimals.
    *
    * @return the l f big decimals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFBigDecimal> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f big decimals.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f big decimals
    * @param end the upper bound of the range of l f big decimals (not inclusive)
    * @return the range of l f big decimals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFBigDecimal> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f big decimals.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f big decimals
    * @param end the upper bound of the range of l f big decimals (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f big decimals
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFBigDecimal> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f big decimals where decimal = &#63; from the database.
    *
    * @param decimal the decimal
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDecimal(java.math.BigDecimal decimal)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByDecimal(decimal);
    }

    /**
    * Removes all the l f big decimals from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f big decimals where decimal = &#63;.
    *
    * @param decimal the decimal
    * @return the number of matching l f big decimals
    * @throws SystemException if a system exception occurred
    */
    public static int countByDecimal(java.math.BigDecimal decimal)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByDecimal(decimal);
    }

    /**
    * Returns the number of l f big decimals.
    *
    * @return the number of l f big decimals
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFBigDecimalPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFBigDecimalPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFBigDecimalPersistence.class.getName());

            ReferenceRegistry.registerReference(LFBigDecimalUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFBigDecimalPersistence persistence) {
    }
}
