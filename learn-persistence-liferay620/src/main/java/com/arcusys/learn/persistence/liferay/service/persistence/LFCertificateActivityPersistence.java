package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateActivity;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f certificate activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateActivityPersistenceImpl
 * @see LFCertificateActivityUtil
 * @generated
 */
public interface LFCertificateActivityPersistence extends BasePersistence<LFCertificateActivity> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFCertificateActivityUtil} to access the l f certificate activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f certificate activities where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findByCertificateID(
        java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate activities where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate activities
    * @param end the upper bound of the range of l f certificate activities (not inclusive)
    * @return the range of matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findByCertificateID(
        java.lang.Long certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate activities where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate activities
    * @param end the upper bound of the range of l f certificate activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findByCertificateID(
        java.lang.Long certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate activity in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity findByCertificateID_First(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate activity in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity fetchByCertificateID_First(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate activity in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity findByCertificateID_Last(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate activity in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity fetchByCertificateID_Last(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate activities before and after the current l f certificate activity in the ordered set where certificateID = &#63;.
    *
    * @param lfCertificateActivityPK the primary key of the current l f certificate activity
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity[] findByCertificateID_PrevAndNext(
        LFCertificateActivityPK lfCertificateActivityPK,
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate activities where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCertificateID(java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate activities where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public int countByCertificateID(java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate activities where activityName = &#63;.
    *
    * @param activityName the activity name
    * @return the matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findByActivityName(
        java.lang.String activityName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate activities where activityName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityName the activity name
    * @param start the lower bound of the range of l f certificate activities
    * @param end the upper bound of the range of l f certificate activities (not inclusive)
    * @return the range of matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findByActivityName(
        java.lang.String activityName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate activities where activityName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityName the activity name
    * @param start the lower bound of the range of l f certificate activities
    * @param end the upper bound of the range of l f certificate activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findByActivityName(
        java.lang.String activityName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate activity in the ordered set where activityName = &#63;.
    *
    * @param activityName the activity name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity findByActivityName_First(
        java.lang.String activityName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate activity in the ordered set where activityName = &#63;.
    *
    * @param activityName the activity name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity fetchByActivityName_First(
        java.lang.String activityName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate activity in the ordered set where activityName = &#63;.
    *
    * @param activityName the activity name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity findByActivityName_Last(
        java.lang.String activityName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate activity in the ordered set where activityName = &#63;.
    *
    * @param activityName the activity name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity fetchByActivityName_Last(
        java.lang.String activityName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate activities before and after the current l f certificate activity in the ordered set where activityName = &#63;.
    *
    * @param lfCertificateActivityPK the primary key of the current l f certificate activity
    * @param activityName the activity name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity[] findByActivityName_PrevAndNext(
        LFCertificateActivityPK lfCertificateActivityPK,
        java.lang.String activityName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate activities where activityName = &#63; from the database.
    *
    * @param activityName the activity name
    * @throws SystemException if a system exception occurred
    */
    public void removeByActivityName(java.lang.String activityName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate activities where activityName = &#63;.
    *
    * @param activityName the activity name
    * @return the number of matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityName(java.lang.String activityName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate activity where certificateID = &#63; and activityName = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException} if it could not be found.
    *
    * @param certificateID the certificate i d
    * @param activityName the activity name
    * @return the matching l f certificate activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity findByCertificateIDAndActivityName(
        java.lang.Long certificateID, java.lang.String activityName)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate activity where certificateID = &#63; and activityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param certificateID the certificate i d
    * @param activityName the activity name
    * @return the matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity fetchByCertificateIDAndActivityName(
        java.lang.Long certificateID, java.lang.String activityName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate activity where certificateID = &#63; and activityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param certificateID the certificate i d
    * @param activityName the activity name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity fetchByCertificateIDAndActivityName(
        java.lang.Long certificateID, java.lang.String activityName,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f certificate activity where certificateID = &#63; and activityName = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @param activityName the activity name
    * @return the l f certificate activity that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity removeByCertificateIDAndActivityName(
        java.lang.Long certificateID, java.lang.String activityName)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate activities where certificateID = &#63; and activityName = &#63;.
    *
    * @param certificateID the certificate i d
    * @param activityName the activity name
    * @return the number of matching l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public int countByCertificateIDAndActivityName(
        java.lang.Long certificateID, java.lang.String activityName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f certificate activity in the entity cache if it is enabled.
    *
    * @param lfCertificateActivity the l f certificate activity
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateActivity lfCertificateActivity);

    /**
    * Caches the l f certificate activities in the entity cache if it is enabled.
    *
    * @param lfCertificateActivities the l f certificate activities
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> lfCertificateActivities);

    /**
    * Creates a new l f certificate activity with the primary key. Does not add the l f certificate activity to the database.
    *
    * @param lfCertificateActivityPK the primary key for the new l f certificate activity
    * @return the new l f certificate activity
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity create(
        LFCertificateActivityPK lfCertificateActivityPK);

    /**
    * Removes the l f certificate activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateActivityPK the primary key of the l f certificate activity
    * @return the l f certificate activity that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity remove(
        LFCertificateActivityPK lfCertificateActivityPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateActivity lfCertificateActivity)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException} if it could not be found.
    *
    * @param lfCertificateActivityPK the primary key of the l f certificate activity
    * @return the l f certificate activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity findByPrimaryKey(
        LFCertificateActivityPK lfCertificateActivityPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate activity with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfCertificateActivityPK the primary key of the l f certificate activity
    * @return the l f certificate activity, or <code>null</code> if a l f certificate activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity fetchByPrimaryKey(
        LFCertificateActivityPK lfCertificateActivityPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate activities.
    *
    * @return the l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate activities
    * @param end the upper bound of the range of l f certificate activities (not inclusive)
    * @return the range of l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate activities
    * @param end the upper bound of the range of l f certificate activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate activities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate activities.
    *
    * @return the number of l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
