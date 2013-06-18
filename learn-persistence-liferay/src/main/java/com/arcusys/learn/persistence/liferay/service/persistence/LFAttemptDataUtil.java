package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAttemptData;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f attempt data service. This utility wraps {@link LFAttemptDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAttemptDataPersistence
 * @see LFAttemptDataPersistenceImpl
 * @generated
 */
public class LFAttemptDataUtil {
    private static LFAttemptDataPersistence _persistence;

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
    public static void clearCache(LFAttemptData lfAttemptData) {
        getPersistence().clearCache(lfAttemptData);
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
    public static List<LFAttemptData> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFAttemptData> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFAttemptData> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFAttemptData update(LFAttemptData lfAttemptData,
        boolean merge) throws SystemException {
        return getPersistence().update(lfAttemptData, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFAttemptData update(LFAttemptData lfAttemptData,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfAttemptData, merge, serviceContext);
    }

    /**
    * Caches the l f attempt data in the entity cache if it is enabled.
    *
    * @param lfAttemptData the l f attempt data
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData) {
        getPersistence().cacheResult(lfAttemptData);
    }

    /**
    * Caches the l f attempt datas in the entity cache if it is enabled.
    *
    * @param lfAttemptDatas the l f attempt datas
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> lfAttemptDatas) {
        getPersistence().cacheResult(lfAttemptDatas);
    }

    /**
    * Creates a new l f attempt data with the primary key. Does not add the l f attempt data to the database.
    *
    * @param id the primary key for the new l f attempt data
    * @return the new l f attempt data
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f attempt data with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfAttemptData, merge);
    }

    /**
    * Returns the l f attempt data with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException} if it could not be found.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f attempt data with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data, or <code>null</code> if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @return the matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithActivityID(attemptID, activityID);
    }

    /**
    * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithActivityID(attemptID, activityID, start,
            end);
    }

    /**
    * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithActivityID(attemptID, activityID, start,
            end, orderByComparator);
    }

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findByAttemptIDWithActivityID_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithActivityID_First(attemptID, activityID,
            orderByComparator);
    }

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByAttemptIDWithActivityID_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAttemptIDWithActivityID_First(attemptID, activityID,
            orderByComparator);
    }

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findByAttemptIDWithActivityID_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithActivityID_Last(attemptID, activityID,
            orderByComparator);
    }

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByAttemptIDWithActivityID_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAttemptIDWithActivityID_Last(attemptID, activityID,
            orderByComparator);
    }

    /**
    * Returns the l f attempt datas before and after the current l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
    *
    * @param id the primary key of the current l f attempt data
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData[] findByAttemptIDWithActivityID_PrevAndNext(
        long id, java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithActivityID_PrevAndNext(id, attemptID,
            activityID, orderByComparator);
    }

    /**
    * Returns all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @return the matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAttemptIDWithDataKey(attemptID, dataKey);
    }

    /**
    * Returns a range of all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithDataKey(attemptID, dataKey, start, end);
    }

    /**
    * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithDataKey(attemptID, dataKey, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findByAttemptIDWithDataKey_First(
        java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithDataKey_First(attemptID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByAttemptIDWithDataKey_First(
        java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAttemptIDWithDataKey_First(attemptID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findByAttemptIDWithDataKey_Last(
        java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithDataKey_Last(attemptID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByAttemptIDWithDataKey_Last(
        java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAttemptIDWithDataKey_Last(attemptID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the l f attempt datas before and after the current l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
    *
    * @param id the primary key of the current l f attempt data
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData[] findByAttemptIDWithDataKey_PrevAndNext(
        long id, java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAttemptIDWithDataKey_PrevAndNext(id, attemptID,
            dataKey, orderByComparator);
    }

    /**
    * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @return the matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findBySingleKey(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySingleKey(attemptID, activityID, dataKey);
    }

    /**
    * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findBySingleKey(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySingleKey(attemptID, activityID, dataKey, start, end);
    }

    /**
    * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findBySingleKey(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySingleKey(attemptID, activityID, dataKey, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findBySingleKey_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySingleKey_First(attemptID, activityID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchBySingleKey_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySingleKey_First(attemptID, activityID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findBySingleKey_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySingleKey_Last(attemptID, activityID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchBySingleKey_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySingleKey_Last(attemptID, activityID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the l f attempt datas before and after the current l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param id the primary key of the current l f attempt data
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData[] findBySingleKey_PrevAndNext(
        long id, java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySingleKey_PrevAndNext(id, attemptID, activityID,
            dataKey, orderByComparator);
    }

    /**
    * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @return the matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByCollectionValues(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollectionValues(attemptID, activityID, dataKey);
    }

    /**
    * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByCollectionValues(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollectionValues(attemptID, activityID, dataKey,
            start, end);
    }

    /**
    * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByCollectionValues(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollectionValues(attemptID, activityID, dataKey,
            start, end, orderByComparator);
    }

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findByCollectionValues_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollectionValues_First(attemptID, activityID,
            dataKey, orderByComparator);
    }

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByCollectionValues_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCollectionValues_First(attemptID, activityID,
            dataKey, orderByComparator);
    }

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData findByCollectionValues_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollectionValues_Last(attemptID, activityID, dataKey,
            orderByComparator);
    }

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByCollectionValues_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCollectionValues_Last(attemptID, activityID,
            dataKey, orderByComparator);
    }

    /**
    * Returns the l f attempt datas before and after the current l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param id the primary key of the current l f attempt data
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData[] findByCollectionValues_PrevAndNext(
        long id, java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCollectionValues_PrevAndNext(id, attemptID,
            activityID, dataKey, orderByComparator);
    }

    /**
    * Returns all the l f attempt datas.
    *
    * @return the l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f attempt datas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f attempt datas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAttemptIDWithActivityID(attemptID, activityID);
    }

    /**
    * Removes all the l f attempt datas where attemptID = &#63; and dataKey = &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAttemptIDWithDataKey(attemptID, dataKey);
    }

    /**
    * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySingleKey(java.lang.Integer attemptID,
        java.lang.String activityID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySingleKey(attemptID, activityID, dataKey);
    }

    /**
    * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCollectionValues(java.lang.Integer attemptID,
        java.lang.String activityID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCollectionValues(attemptID, activityID, dataKey);
    }

    /**
    * Removes all the l f attempt datas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @return the number of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static int countByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByAttemptIDWithActivityID(attemptID, activityID);
    }

    /**
    * Returns the number of l f attempt datas where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @return the number of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static int countByAttemptIDWithDataKey(java.lang.Integer attemptID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAttemptIDWithDataKey(attemptID, dataKey);
    }

    /**
    * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @return the number of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static int countBySingleKey(java.lang.Integer attemptID,
        java.lang.String activityID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySingleKey(attemptID, activityID, dataKey);
    }

    /**
    * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @return the number of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static int countByCollectionValues(java.lang.Integer attemptID,
        java.lang.String activityID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByCollectionValues(attemptID, activityID, dataKey);
    }

    /**
    * Returns the number of l f attempt datas.
    *
    * @return the number of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFAttemptDataPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFAttemptDataPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFAttemptDataPersistence.class.getName());

            ReferenceRegistry.registerReference(LFAttemptDataUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFAttemptDataPersistence persistence) {
    }
}
