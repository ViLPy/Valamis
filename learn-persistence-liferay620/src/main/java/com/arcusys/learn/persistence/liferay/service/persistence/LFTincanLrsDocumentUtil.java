package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan lrs document service. This utility wraps {@link LFTincanLrsDocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsDocumentPersistence
 * @see LFTincanLrsDocumentPersistenceImpl
 * @generated
 */
public class LFTincanLrsDocumentUtil {
    private static LFTincanLrsDocumentPersistence _persistence;

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
    public static void clearCache(LFTincanLrsDocument lfTincanLrsDocument) {
        getPersistence().clearCache(lfTincanLrsDocument);
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
    public static List<LFTincanLrsDocument> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanLrsDocument> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanLrsDocument> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTincanLrsDocument update(
        LFTincanLrsDocument lfTincanLrsDocument) throws SystemException {
        return getPersistence().update(lfTincanLrsDocument);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTincanLrsDocument update(
        LFTincanLrsDocument lfTincanLrsDocument, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfTincanLrsDocument, serviceContext);
    }

    /**
    * Returns the l f tincan lrs document where documentId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException} if it could not be found.
    *
    * @param documentId the document ID
    * @return the matching l f tincan lrs document
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a matching l f tincan lrs document could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument findByDocumentId(
        java.lang.String documentId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDocumentId(documentId);
    }

    /**
    * Returns the l f tincan lrs document where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param documentId the document ID
    * @return the matching l f tincan lrs document, or <code>null</code> if a matching l f tincan lrs document could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument fetchByDocumentId(
        java.lang.String documentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByDocumentId(documentId);
    }

    /**
    * Returns the l f tincan lrs document where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param documentId the document ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan lrs document, or <code>null</code> if a matching l f tincan lrs document could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument fetchByDocumentId(
        java.lang.String documentId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByDocumentId(documentId, retrieveFromCache);
    }

    /**
    * Removes the l f tincan lrs document where documentId = &#63; from the database.
    *
    * @param documentId the document ID
    * @return the l f tincan lrs document that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument removeByDocumentId(
        java.lang.String documentId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByDocumentId(documentId);
    }

    /**
    * Returns the number of l f tincan lrs documents where documentId = &#63;.
    *
    * @param documentId the document ID
    * @return the number of matching l f tincan lrs documents
    * @throws SystemException if a system exception occurred
    */
    public static int countByDocumentId(java.lang.String documentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByDocumentId(documentId);
    }

    /**
    * Caches the l f tincan lrs document in the entity cache if it is enabled.
    *
    * @param lfTincanLrsDocument the l f tincan lrs document
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument lfTincanLrsDocument) {
        getPersistence().cacheResult(lfTincanLrsDocument);
    }

    /**
    * Caches the l f tincan lrs documents in the entity cache if it is enabled.
    *
    * @param lfTincanLrsDocuments the l f tincan lrs documents
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument> lfTincanLrsDocuments) {
        getPersistence().cacheResult(lfTincanLrsDocuments);
    }

    /**
    * Creates a new l f tincan lrs document with the primary key. Does not add the l f tincan lrs document to the database.
    *
    * @param id the primary key for the new l f tincan lrs document
    * @return the new l f tincan lrs document
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan lrs document with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs document
    * @return the l f tincan lrs document that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument lfTincanLrsDocument)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanLrsDocument);
    }

    /**
    * Returns the l f tincan lrs document with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs document
    * @return the l f tincan lrs document
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs document with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs document
    * @return the l f tincan lrs document, or <code>null</code> if a l f tincan lrs document with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan lrs documents.
    *
    * @return the l f tincan lrs documents
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan lrs documents.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs documents
    * @param end the upper bound of the range of l f tincan lrs documents (not inclusive)
    * @return the range of l f tincan lrs documents
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs documents.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs documents
    * @param end the upper bound of the range of l f tincan lrs documents (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs documents
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs documents from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan lrs documents.
    *
    * @return the number of l f tincan lrs documents
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanLrsDocumentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanLrsDocumentPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanLrsDocumentPersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanLrsDocumentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTincanLrsDocumentPersistence persistence) {
    }
}
