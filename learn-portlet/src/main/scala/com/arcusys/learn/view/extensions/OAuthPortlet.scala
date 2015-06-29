package com.arcusys.learn.view.extensions

import java.net.URL
import javax.portlet._
import com.arcusys.learn.utils.SessionKey
import com.arcusys.learn.view.liferay.LiferayHelpers
import com.arcusys.valamis.lrs.model.{EndpointInfo, OAuthParams}
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.lrs.tincan.AuthorizationScope
import com.arcusys.valamis.lrsEndpoint.model.InternalAuthorization
import com.liferay.portal.util.PortalUtil
import com.liferay.portlet.PortletURLFactoryUtil
import net.oauth.{OAuth, OAuthException}
import org.apache.http.client.RedirectException

object OAuthPortlet {
  private val lock: AnyRef = new Object()
}
abstract class OAuthPortlet extends GenericPortlet with ConfigurableView {

  protected lazy val lrsClientManager = inject[LrsClientManager]

  override def doDispatch(request: RenderRequest, response: RenderResponse) : Unit = {
    try {
      val session = request.getPortletSession

      if (!isLrsAuthConfigured(request)) {
        OAuthPortlet.lock.synchronized {

          if (!isLrsAuthConfigured(request)) {
            val newEndpointInfo = lrsClientManager.requestProxyLrsEndpointInfo(
              getOAuthParams(request),
              AuthorizationScope.All,
              PortalUtil.getPortalURL(request)
            )

            session.setAttribute(SessionKey.LrsEndpointInfo, newEndpointInfo, PortletSession.APPLICATION_SCOPE)
          }
        }
      }

      super.doDispatch(request, response)
    } catch {
      case e: NoSuchElementException =>
        response.getWriter.println(s"<h2>No such element found: ${e.getMessage}</h2>")

      case e: OAuthException =>
        response.getWriter.println(
          s"""<h1>Authorization failed</h1>
             |<p>${e.getMessage}</p>"""
            .stripMargin
        )

      case e: RedirectException =>
        val settings = lrsClientManager.getLrsSettings
        val url = settings.auth match {
          case _: InternalAuthorization => PortalUtil.getPortalURL(request) + new URL(e.getMessage).getFile
          case _ => e.getMessage
        }

        response.getWriter.println(
          s"""<script type="text/javascript">
             |jQueryValamis = null;
             |window.location.replace("$url");
             |</script>"""
            .stripMargin
        )
    }
  }

  private def getOAuthParams(implicit request: RenderRequest): OAuthParams = {
    // we need to read parameters from original request
    val baseRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request))

    val oauthToken = Option(baseRequest.getParameter(OAuth.OAUTH_TOKEN))
    val oauthVerifier = Option(baseRequest.getParameter(OAuth.OAUTH_VERIFIER))
    val portletUrl = Option(getPortletUrl(request))

    OAuthParams(portletUrl, oauthToken, oauthVerifier)
  }

  private def getPortletUrl(implicit request: RenderRequest) = {
    val portletId = PortalUtil.getPortletId(request)
    val httpRequest = PortalUtil.getOriginalServletRequest(
      PortalUtil.getHttpServletRequest(request)
    )
    val themeDisplay = LiferayHelpers.getThemeDisplay(request)
    val portletURL = PortletURLFactoryUtil.create(httpRequest, portletId, themeDisplay.getPlid, PortletRequest.RENDER_PHASE)

    portletURL.toString
  }

  private def isLrsAuthConfigured(implicit request: RenderRequest) : Boolean = {
    val session = request.getPortletSession
    val endpointInfo = session.getAttribute(SessionKey.LrsEndpointInfo, PortletSession.APPLICATION_SCOPE)

    // isInstanceOf to prevent classNotFoundException after redeploy
    endpointInfo != null && endpointInfo.isInstanceOf[EndpointInfo]
  }

  def getEndpointInfo(implicit request: RenderRequest) = {
    val session = request.getPortletSession

    session.getAttribute(SessionKey.LrsEndpointInfo, PortletSession.APPLICATION_SCOPE) match {
      case e: EndpointInfo => e
      case _ => throw new NoSuchElementException("Endpoint Data")
    }
  }
}
