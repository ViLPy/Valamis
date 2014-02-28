package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAttemptData;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f attempt data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAttemptDataPersistenceImpl
 * @see LFAttemptDataUtil
 * @generated
 */
public interface LFAttemptDataPersistence extends BasePersistence<LFAttemptData> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFAttemptDataUtil} to access the l f attempt data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @return the matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findByAttemptIDWithActivityID_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByAttemptIDWithActivityID_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findByAttemptIDWithActivityID_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByAttemptIDWithActivityID_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData[] findByAttemptIDWithActivityID_PrevAndNext(
        long id, java.lang.Integer attemptID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByAttemptIDWithActivityID(java.lang.Integer attemptID,
        java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @return the number of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public int countByAttemptIDWithActivityID(java.lang.Integer attemptID,
        java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @return the matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findByAttemptIDWithDataKey_First(
        java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByAttemptIDWithDataKey_First(
        java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findByAttemptIDWithDataKey_Last(
        java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByAttemptIDWithDataKey_Last(
        java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData[] findByAttemptIDWithDataKey_PrevAndNext(
        long id, java.lang.Integer attemptID, java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempt datas where attemptID = &#63; and dataKey = &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public void removeByAttemptIDWithDataKey(java.lang.Integer attemptID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempt datas where attemptID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param dataKey the data key
    * @return the number of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public int countByAttemptIDWithDataKey(java.lang.Integer attemptID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @return the matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findBySingleKey(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findBySingleKey(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findBySingleKey(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findBySingleKey_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchBySingleKey_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findBySingleKey_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchBySingleKey_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData[] findBySingleKey_PrevAndNext(
        long id, java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public void removeBySingleKey(java.lang.Integer attemptID,
        java.lang.String activityID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @return the number of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public int countBySingleKey(java.lang.Integer attemptID,
        java.lang.String activityID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @return the matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByCollectionValues(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByCollectionValues(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByCollectionValues(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findByCollectionValues_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByCollectionValues_First(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findByCollectionValues_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByCollectionValues_Last(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData[] findByCollectionValues_PrevAndNext(
        long id, java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63; from the database.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @throws SystemException if a system exception occurred
    */
    public void removeByCollectionValues(java.lang.Integer attemptID,
        java.lang.String activityID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
    *
    * @param attemptID the attempt i d
    * @param activityID the activity i d
    * @param dataKey the data key
    * @return the number of matching l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public int countByCollectionValues(java.lang.Integer attemptID,
        java.lang.String activityID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f attempt data in the entity cache if it is enabled.
    *
    * @param lfAttemptData the l f attempt data
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData);

    /**
    * Caches the l f attempt datas in the entity cache if it is enabled.
    *
    * @param lfAttemptDatas the l f attempt datas
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> lfAttemptDatas);

    /**
    * Creates a new l f attempt data with the primary key. Does not add the l f attempt data to the database.
    *
    * @param id the primary key for the new l f attempt data
    * @return the new l f attempt data
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData create(
        long id);

    /**
    * Removes the l f attempt data with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFAttemptData updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f attempt data with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException} if it could not be found.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f attempt data with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data, or <code>null</code> if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f attempt datas.
    *
    * @return the l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempt datas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempt datas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempt datas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempt datas.
    *
    * @return the number of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
