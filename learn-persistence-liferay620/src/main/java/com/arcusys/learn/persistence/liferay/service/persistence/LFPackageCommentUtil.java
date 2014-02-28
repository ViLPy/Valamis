package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageComment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f package comment service. This utility wraps {@link LFPackageCommentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageCommentPersistence
 * @see LFPackageCommentPersistenceImpl
 * @generated
 */
public class LFPackageCommentUtil {
    private static LFPackageCommentPersistence _persistence;

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
    public static void clearCache(LFPackageComment lfPackageComment) {
        getPersistence().clearCache(lfPackageComment);
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
    public static List<LFPackageComment> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFPackageComment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFPackageComment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFPackageComment update(LFPackageComment lfPackageComment)
        throws SystemException {
        return getPersistence().update(lfPackageComment);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFPackageComment update(LFPackageComment lfPackageComment,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfPackageComment, serviceContext);
    }

    /**
    * Returns all the l f package comments where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @return the matching l f package comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageComment> findBySocialPackageID(
        java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySocialPackageID(socialPackageID);
    }

    /**
    * Returns a range of all the l f package comments where socialPackageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param socialPackageID the social package i d
    * @param start the lower bound of the range of l f package comments
    * @param end the upper bound of the range of l f package comments (not inclusive)
    * @return the range of matching l f package comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageComment> findBySocialPackageID(
        java.lang.Integer socialPackageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID(socialPackageID, start, end);
    }

    /**
    * Returns an ordered range of all the l f package comments where socialPackageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param socialPackageID the social package i d
    * @param start the lower bound of the range of l f package comments
    * @param end the upper bound of the range of l f package comments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f package comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageComment> findBySocialPackageID(
        java.lang.Integer socialPackageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID(socialPackageID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f package comment in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package comment
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a matching l f package comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment findBySocialPackageID_First(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID_First(socialPackageID,
            orderByComparator);
    }

    /**
    * Returns the first l f package comment in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package comment, or <code>null</code> if a matching l f package comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment fetchBySocialPackageID_First(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySocialPackageID_First(socialPackageID,
            orderByComparator);
    }

    /**
    * Returns the last l f package comment in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package comment
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a matching l f package comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment findBySocialPackageID_Last(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID_Last(socialPackageID,
            orderByComparator);
    }

    /**
    * Returns the last l f package comment in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package comment, or <code>null</code> if a matching l f package comment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment fetchBySocialPackageID_Last(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySocialPackageID_Last(socialPackageID,
            orderByComparator);
    }

    /**
    * Returns the l f package comments before and after the current l f package comment in the ordered set where socialPackageID = &#63;.
    *
    * @param id the primary key of the current l f package comment
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f package comment
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a l f package comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment[] findBySocialPackageID_PrevAndNext(
        long id, java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySocialPackageID_PrevAndNext(id, socialPackageID,
            orderByComparator);
    }

    /**
    * Removes all the l f package comments where socialPackageID = &#63; from the database.
    *
    * @param socialPackageID the social package i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySocialPackageID(
        java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySocialPackageID(socialPackageID);
    }

    /**
    * Returns the number of l f package comments where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @return the number of matching l f package comments
    * @throws SystemException if a system exception occurred
    */
    public static int countBySocialPackageID(java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySocialPackageID(socialPackageID);
    }

    /**
    * Caches the l f package comment in the entity cache if it is enabled.
    *
    * @param lfPackageComment the l f package comment
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFPackageComment lfPackageComment) {
        getPersistence().cacheResult(lfPackageComment);
    }

    /**
    * Caches the l f package comments in the entity cache if it is enabled.
    *
    * @param lfPackageComments the l f package comments
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageComment> lfPackageComments) {
        getPersistence().cacheResult(lfPackageComments);
    }

    /**
    * Creates a new l f package comment with the primary key. Does not add the l f package comment to the database.
    *
    * @param id the primary key for the new l f package comment
    * @return the new l f package comment
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f package comment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f package comment
    * @return the l f package comment that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a l f package comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageComment lfPackageComment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfPackageComment);
    }

    /**
    * Returns the l f package comment with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException} if it could not be found.
    *
    * @param id the primary key of the l f package comment
    * @return the l f package comment
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException if a l f package comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f package comment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f package comment
    * @return the l f package comment, or <code>null</code> if a l f package comment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageComment fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f package comments.
    *
    * @return the l f package comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageComment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f package comments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f package comments
    * @param end the upper bound of the range of l f package comments (not inclusive)
    * @return the range of l f package comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageComment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f package comments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f package comments
    * @param end the upper bound of the range of l f package comments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f package comments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageComment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f package comments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f package comments.
    *
    * @return the number of l f package comments
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFPackageCommentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFPackageCommentPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFPackageCommentPersistence.class.getName());

            ReferenceRegistry.registerReference(LFPackageCommentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFPackageCommentPersistence persistence) {
    }
}
