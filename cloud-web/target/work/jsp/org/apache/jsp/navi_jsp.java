package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class navi_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/META-INF/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"col-2\">\n");
      out.write("\n");
      out.write("\t<h3>Cloud Resources</h3>\n");
      out.write("\t<ul class=\"submenu\">\n");
      out.write("\t\t<li><a href=\"\">Nodes</a></li>\n");
      out.write("\t\t<li><a href=\"\">Storage</a></li>\n");
      out.write("\t\t<li><a href=\"\">Status</a></li>\n");
      out.write("\t\t<li><a href=\"\">Return</a></li>\n");
      out.write("\t\t<li><a href=\"\">Monitoring</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("\t<h3 style=\"margin-top: 16px\">Storage Resources</h3>\n");
      out.write("\t<ul class=\"submenu\">\n");
      out.write("\t\t<li><a href='");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("'>Hadoop File Explorer</a></li>\n");
      out.write("\t\t<li><a href=\"\">Usage</a></li>\n");
      out.write("\t\t<li><a href=\"\">Real Time Import & Export</a></li>\n");
      out.write("\t\t<li><a href=\"\">Batch Import & Export</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("\t<h3 style=\"margin-top: 16px\">Jobs</h3>\n");
      out.write("\t<ul class=\"submenu\">\n");
      out.write("\t\t<li><a href=\"\">New Job</a></li>\n");
      out.write("\t\t<li><a href=\"\">Job List</a></li>\n");
      out.write("\t\t<li><a href=\"\">Running Jobs</a></li>\n");
      out.write("\t\t<li><a href=\"\">Retired Jobs</a></li>\n");
      out.write("\t\t<li><a href=\"\">Pending Jobs</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("\t<h3 style=\"margin-top: 16px\">Admin</h3>\n");
      out.write("\t<ul class=\"submenu\">\n");
      out.write("\t\t<li><a href=\"\">Account</a></li>\n");
      out.write("\t\t<li><a href=\"\">Settings</a></li>\n");
      out.write("\t\t<li><a href=\"\">Support</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("</div>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/hadoop/hdfs/info/index.jsp.oo?path=/");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }
}
