/**
 * 
 */
package com.hp.servlet;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hp.service.ITempService;
import com.hp.service.impl.TempServiceImpl;
import com.hp.utils.JDBCUtil;

/**
 * @author  小熊熊
 *
 */
@MultipartConfig(location = "e://")
@WebServlet(name = "UploadServlet", urlPatterns = "/UploadServlet")
public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6147870190717874494L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ITempService iTempService = new TempServiceImpl();
		InputStream input = null;
		FileOutputStream output = null;
		try {
//			Part part = request.getPart("file");
//			part.write(part.getSubmittedFileName());
			
//			input = part.getInputStream();
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			List<String> data = new ArrayList<>();
			long start = System.currentTimeMillis();
			for (FileItem fileItem : list) {
				input = fileItem.getInputStream();
				GZIPInputStream ginput = new GZIPInputStream(input);
				BufferedReader reader = new BufferedReader(new InputStreamReader(ginput));
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (line.startsWith("STN---")) {
						continue;
					}
//					System.out.println(data.size());
//					System.out.println(line);
					System.out.println(line.substring(14, 22) + "##" + line.substring(103, 108) + "##" + line.substring(111, 116));
					data.add(UUID.randomUUID().toString().replaceAll("-", "") + "##" + line.substring(14, 22) + "##" + line.substring(103, 108) + "##" + line.substring(111, 116));
					//boolean b = iTempService.insertTempDate(UUID.randomUUID().toString().replaceAll("-", ""), line.substring(14, 22), line.substring(103, 108), line.substring(111, 116));
					//System.out.println("执行结果：" + b);
				}
			}
			boolean b = iTempService.insertTempDateBatch(data);
			long end = System.currentTimeMillis();
			System.out.println("执行结果：" + b + ", 耗时：" + (end - start) / 1000);
			request.getRequestDispatcher("/jsp/chart.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}	
	}
}
