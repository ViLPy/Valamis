package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageComment;
import com.arcusys.learn.persistence.liferay.model.LFPackageCommentModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* The base model implementation for the LFPackageComment service. Represents a row in the &quot;Learn_LFPackageComment&quot; database table, with each column mapped to a property of this class.
*
* <p>
    * This implementation and its corresponding interface {@link com.arcusys.learn.persistence.liferay.model.LFPackageCommentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFPackageCommentImpl}.
    * </p>
*
* @author Brian Wing Shun Chan
* @see LFPackageCommentImpl
* @see com.arcusys.learn.persistence.liferay.model.LFPackageComment
* @see com.arcusys.learn.persistence.liferay.model.LFPackageCommentModel
* @generated
*/
public class LFPackageCommentModelImpl extends BaseModelImpl<LFPackageComment>
    implements LFPackageCommentModel {
    /*
    * NOTE FOR DEVELOPERS:
    *
    * Never modify or reference this class directly. All methods that expect a l f package comment model instance should use the {@link com.arcusys.learn.persistence.liferay.model.LFPackageComment} interface instead.
    */
    public static final String TABLE_NAME = "Learn_LFPackageComment";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "socialPackageID", Types.INTEGER },
            { "authorID", Types.INTEGER },
            { "comment_", Types.VARCHAR },
            { "publishDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table Learn_LFPackageComment (id_ LONG not null primary key,socialPackageID INTEGER,authorID INTEGER,comment_ VARCHAR(75) null,publishDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table Learn_LFPackageComment";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFPackageComment"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arcusys.learn.persistence.liferay.model.LFPackageComment"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arcusys.learn.persistence.liferay.model.LFPackageComment"),
            true);
    public static long SOCIALPACKAGEID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arcusys.learn.persistence.liferay.model.LFPackageComment"));
    private static ClassLoader _classLoader = LFPackageComment.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            LFPackageComment.class
        };
    private long _id;
    private Integer _socialPackageID;
    private Integer _originalSocialPackageID;
    private boolean _setOriginalSocialPackageID;
    private Integer _authorID;
    private String _comment;
    private Date _publishDate;
    private long _columnBitmask;
    private LFPackageComment _escapedModelProxy;

    public LFPackageCommentModelImpl() {
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return LFPackageComment.class;
    }

    public String getModelClassName() {
        return LFPackageComment.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("authorID", getAuthorID());
        attributes.put("comment", getComment());
        attributes.put("publishDate", getPublishDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        Integer authorID = (Integer) attributes.get("authorID");

        if (authorID != null) {
            setAuthorID(authorID);
        }

        String comment = (String) attributes.get("comment");

        if (comment != null) {
            setComment(comment);
        }

        Date publishDate = (Date) attributes.get("publishDate");

        if (publishDate != null) {
            setPublishDate(publishDate);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getSocialPackageID() {
        return _socialPackageID;
    }

    public void setSocialPackageID(Integer socialPackageID) {
        _columnBitmask |= SOCIALPACKAGEID_COLUMN_BITMASK;

        if (!_setOriginalSocialPackageID) {
            _setOriginalSocialPackageID = true;

            _originalSocialPackageID = _socialPackageID;
        }

        _socialPackageID = socialPackageID;
    }

    public Integer getOriginalSocialPackageID() {
        return _originalSocialPackageID;
    }

    public Integer getAuthorID() {
        return _authorID;
    }

    public void setAuthorID(Integer authorID) {
        _authorID = authorID;
    }

    public String getComment() {
        if (_comment == null) {
            return StringPool.BLANK;
        } else {
            return _comment;
        }
    }

    public void setComment(String comment) {
        _comment = comment;
    }

    public Date getPublishDate() {
        return _publishDate;
    }

    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            LFPackageComment.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public LFPackageComment toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (LFPackageComment) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        LFPackageCommentImpl lfPackageCommentImpl = new LFPackageCommentImpl();

        lfPackageCommentImpl.setId(getId());
        lfPackageCommentImpl.setSocialPackageID(getSocialPackageID());
        lfPackageCommentImpl.setAuthorID(getAuthorID());
        lfPackageCommentImpl.setComment(getComment());
        lfPackageCommentImpl.setPublishDate(getPublishDate());

        lfPackageCommentImpl.resetOriginalValues();

        return lfPackageCommentImpl;
    }

    public int compareTo(LFPackageComment lfPackageComment) {
        long primaryKey = lfPackageComment.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFPackageComment lfPackageComment = null;

        try {
            lfPackageComment = (LFPackageComment) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfPackageComment.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        LFPackageCommentModelImpl lfPackageCommentModelImpl = this;

        lfPackageCommentModelImpl._originalSocialPackageID = lfPackageCommentModelImpl._socialPackageID;

        lfPackageCommentModelImpl._setOriginalSocialPackageID = false;

        lfPackageCommentModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<LFPackageComment> toCacheModel() {
        LFPackageCommentCacheModel lfPackageCommentCacheModel = new LFPackageCommentCacheModel();

        lfPackageCommentCacheModel.id = getId();

        lfPackageCommentCacheModel.socialPackageID = getSocialPackageID();

        lfPackageCommentCacheModel.authorID = getAuthorID();

        lfPackageCommentCacheModel.comment = getComment();

        String comment = lfPackageCommentCacheModel.comment;

        if ((comment != null) && (comment.length() == 0)) {
            lfPackageCommentCacheModel.comment = null;
        }

        Date publishDate = getPublishDate();

        if (publishDate != null) {
            lfPackageCommentCacheModel.publishDate = publishDate.getTime();
        } else {
            lfPackageCommentCacheModel.publishDate = Long.MIN_VALUE;
        }

        return lfPackageCommentCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", socialPackageID=");
        sb.append(getSocialPackageID());
        sb.append(", authorID=");
        sb.append(getAuthorID());
        sb.append(", comment=");
        sb.append(getComment());
        sb.append(", publishDate=");
        sb.append(getPublishDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFPackageComment");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>socialPackageID</column-name><column-value><![CDATA[");
        sb.append(getSocialPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorID</column-name><column-value><![CDATA[");
        sb.append(getAuthorID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>comment</column-name><column-value><![CDATA[");
        sb.append(getComment());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publishDate</column-name><column-value><![CDATA[");
        sb.append(getPublishDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
