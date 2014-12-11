package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f l r s to activity setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFLRSToActivitySettingPersistenceImpl
 * @see LFLRSToActivitySettingUtil
 * @generated
 */
public interface LFLRSToActivitySettingPersistence extends BasePersistence<LFLRSToActivitySetting> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFLRSToActivitySettingUtil} to access the l f l r s to activity setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f l r s to activity settings where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the matching l f l r s to activity settings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting> findByCourseID(
        java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f l r s to activity settings where courseID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseID the course i d
    * @param start the lower bound of the range of l f l r s to activity settings
    * @param end the upper bound of the range of l f l r s to activity settings (not inclusive)
    * @return the range of matching l f l r s to activity settings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting> findByCourseID(
        java.lang.Integer courseID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f l r s to activity settings where courseID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseID the course i d
    * @param start the lower bound of the range of l f l r s to activity settings
    * @param end the upper bound of the range of l f l r s to activity settings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f l r s to activity settings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting> findByCourseID(
        java.lang.Integer courseID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f l r s to activity setting in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f l r s to activity setting
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a matching l f l r s to activity setting could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting findByCourseID_First(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f l r s to activity setting in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f l r s to activity setting, or <code>null</code> if a matching l f l r s to activity setting could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting fetchByCourseID_First(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f l r s to activity setting in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f l r s to activity setting
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a matching l f l r s to activity setting could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting findByCourseID_Last(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f l r s to activity setting in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f l r s to activity setting, or <code>null</code> if a matching l f l r s to activity setting could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting fetchByCourseID_Last(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f l r s to activity settings before and after the current l f l r s to activity setting in the ordered set where courseID = &#63;.
    *
    * @param id the primary key of the current l f l r s to activity setting
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f l r s to activity setting
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a l f l r s to activity setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting[] findByCourseID_PrevAndNext(
        long id, java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f l r s to activity settings where courseID = &#63; from the database.
    *
    * @param courseID the course i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCourseID(java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f l r s to activity settings where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the number of matching l f l r s to activity settings
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseID(java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f l r s to activity setting in the entity cache if it is enabled.
    *
    * @param lflrsToActivitySetting the l f l r s to activity setting
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting lflrsToActivitySetting);

    /**
    * Caches the l f l r s to activity settings in the entity cache if it is enabled.
    *
    * @param lflrsToActivitySettings the l f l r s to activity settings
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting> lflrsToActivitySettings);

    /**
    * Creates a new l f l r s to activity setting with the primary key. Does not add the l f l r s to activity setting to the database.
    *
    * @param id the primary key for the new l f l r s to activity setting
    * @return the new l f l r s to activity setting
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting create(
        long id);

    /**
    * Removes the l f l r s to activity setting with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f l r s to activity setting
    * @return the l f l r s to activity setting that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a l f l r s to activity setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting lflrsToActivitySetting)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f l r s to activity setting with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException} if it could not be found.
    *
    * @param id the primary key of the l f l r s to activity setting
    * @return the l f l r s to activity setting
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a l f l r s to activity setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f l r s to activity setting with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f l r s to activity setting
    * @return the l f l r s to activity setting, or <code>null</code> if a l f l r s to activity setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f l r s to activity settings.
    *
    * @return the l f l r s to activity settings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f l r s to activity settings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f l r s to activity settings
    * @param end the upper bound of the range of l f l r s to activity settings (not inclusive)
    * @return the range of l f l r s to activity settings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f l r s to activity settings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f l r s to activity settings
    * @param end the upper bound of the range of l f l r s to activity settings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f l r s to activity settings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f l r s to activity settings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f l r s to activity settings.
    *
    * @return the number of l f l r s to activity settings
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
