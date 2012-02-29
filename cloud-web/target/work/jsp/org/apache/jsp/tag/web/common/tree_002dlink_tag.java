package org.apache.jsp.tag.web.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class tree_002dlink_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/META-INF/c.tld");
  }

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String path;
  private java.lang.String link;

  public java.lang.String getPath() {
    return this.path;
  }

  public void setPath(java.lang.String path) {
    this.path = path;
  }

  public java.lang.String getLink() {
    return this.link;
  }

  public void setLink(java.lang.String link) {
    this.link = link;
  }

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    if( getPath() != null ) 
      _jspx_page_context.setAttribute("path", getPath());
    if( getLink() != null ) 
      _jspx_page_context.setAttribute("link", getLink());

    try {

String ctxPath = application.getContextPath();
String icon = null;
if(ctxPath.equals("/")) {
	icon = "/images/arrow_right_20.gif";
}
else {
	icon = ctxPath + "/images/right_arrow_16.gif";
}
String imgTag = "<img style='margin:3px 6px 3px 6px;' src='" + icon + "'/>";
if(link.startsWith("//")) {
    link = link.substring(1);
}
else if (link.startsWith("http")) {
}
else if (link.startsWith("/")) {
    link = ctxPath + link;
}
String[] items = path.split("/");
out.write("<div>");
for(int i=0; i<items.length; i++) { 
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<i; j++) {
                sb.append(items[j]).append("/");
        }
        sb.append(items[i]);
        String subpath = sb.toString();
        if(subpath.length()==0) {
            subpath = "/";
        }
        String href = link.replaceAll("__PATH__", subpath);
        String caption = items[i];
        if(caption.length() == 0)
                caption = "ROOT";
        if(i!=(items.length-1)) 
                out.write("<a style='text-decoration:none;' href='" + href + "'>" + caption + "</a>" + imgTag);
        else
                out.write(caption);
}
out.write("</div>");

    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
    }
  }
}
