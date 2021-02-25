package cn.java.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThUtils {
	private static TemplateEngine te;
	static {
		te = new TemplateEngine();
		ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
		r.setCharacterEncoding("UTF-8");
		te.setTemplateResolver(r);
	}
	public static void print(String fileName,Context context,
			HttpServletResponse response) throws IOException {
		//将页面和数据整合到一起的到一个新的html字符串
		String html = te.process(fileName, context);
		//把得到的新的html返回给浏览器   异常抛出
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.close();
	}
}




