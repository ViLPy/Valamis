package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan lrs attachment service. This utility wraps {@link LFTincanLrsAttachmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsAttachmentPersistence
 * @see LFTincanLrsAttachmentPersistenceImpl
 * @generated
 */
public class LFTincanLrsAttachmentUtil {
    private static LFTincanLrsAttachmentPersistence _persistence;

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
    public static void clearCache(LFTincanLrsAttachment lfTincanLrsAttachment) {
        getPersistence().clearCache(lfTincanLrsAttachment);
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
    public static List<LFTincanLrsAttachment> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanLrsAttachment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanLrsAttachment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTincanLrsAttachment update(
        LFTincanLrsAttachment lfTincanLrsAttachment) throws SystemException {
        return getPersistence().update(lfTincanLrsAttachment);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTincanLrsAttachment update(
        LFTincanLrsAttachment lfTincanLrsAttachment,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfTincanLrsAttachment, serviceContext);
    }

    /**
    * Returns all the l f tincan lrs attachments where parentID = &#63;.
    *
    * @param parentID the parent i d
    * @return the matching l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> findByParentID(
        java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentID(parentID);
    }

    /**
    * Returns a range of all the l f tincan lrs attachments where parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f tincan lrs attachments
    * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
    * @return the range of matching l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> findByParentID(
        java.lang.Integer parentID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentID(parentID, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs attachments where parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f tincan lrs attachments
    * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> findByParentID(
        java.lang.Integer parentID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByParentID(parentID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs attachment in the ordered set where parentID = &#63;.
    *
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs attachment
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a matching l f tincan lrs attachment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment findByParentID_First(
        java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentID_First(parentID, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs attachment in the ordered set where parentID = &#63;.
    *
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs attachment, or <code>null</code> if a matching l f tincan lrs attachment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment fetchByParentID_First(
        java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByParentID_First(parentID, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs attachment in the ordered set where parentID = &#63;.
    *
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs attachment
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a matching l f tincan lrs attachment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment findByParentID_Last(
        java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentID_Last(parentID, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs attachment in the ordered set where parentID = &#63;.
    *
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs attachment, or <code>null</code> if a matching l f tincan lrs attachment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment fetchByParentID_Last(
        java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByParentID_Last(parentID, orderByComparator);
    }

    /**
    * Returns the l f tincan lrs attachments before and after the current l f tincan lrs attachment in the ordered set where parentID = &#63;.
    *
    * @param id the primary key of the current l f tincan lrs attachment
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan lrs attachment
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a l f tincan lrs attachment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment[] findByParentID_PrevAndNext(
        long id, java.lang.Integer parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByParentID_PrevAndNext(id, parentID, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs attachments where parentID = &#63; from the database.
    *
    * @param parentID the parent i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByParentID(java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByParentID(parentID);
    }

    /**
    * Returns the number of l f tincan lrs attachments where parentID = &#63;.
    *
    * @param parentID the parent i d
    * @return the number of matching l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public static int countByParentID(java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByParentID(parentID);
    }

    /**
    * Caches the l f tincan lrs attachment in the entity cache if it is enabled.
    *
    * @param lfTincanLrsAttachment the l f tincan lrs attachment
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment lfTincanLrsAttachment) {
        getPersistence().cacheResult(lfTincanLrsAttachment);
    }

    /**
    * Caches the l f tincan lrs attachments in the entity cache if it is enabled.
    *
    * @param lfTincanLrsAttachments the l f tincan lrs attachments
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> lfTincanLrsAttachments) {
        getPersistence().cacheResult(lfTincanLrsAttachments);
    }

    /**
    * Creates a new l f tincan lrs attachment with the primary key. Does not add the l f tincan lrs attachment to the database.
    *
    * @param id the primary key for the new l f tincan lrs attachment
    * @return the new l f tincan lrs attachment
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan lrs attachment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs attachment
    * @return the l f tincan lrs attachment that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a l f tincan lrs attachment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment lfTincanLrsAttachment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanLrsAttachment);
    }

    /**
    * Returns the l f tincan lrs attachment with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs attachment
    * @return the l f tincan lrs attachment
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a l f tincan lrs attachment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs attachment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs attachment
    * @return the l f tincan lrs attachment, or <code>null</code> if a l f tincan lrs attachment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan lrs attachments.
    *
    * @return the l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan lrs attachments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs attachments
    * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
    * @return the range of l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs attachments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs attachments
    * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs attachments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan lrs attachments.
    *
    * @return the number of l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanLrsAttachmentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanLrsAttachmentPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanLrsAttachmentPersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanLrsAttachmentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTincanLrsAttachmentPersistence persistence) {
    }
}
