package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2018/2/5 10:17</li>
 */
@Controller
public class FileDownloadController {

    @RequestMapping("/file/download")
    public void download ( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        request.setCharacterEncoding( "UTF-8" );
        String name = "test.xlsx";//获取要下载的文件名
        //第一步：设置响应类型
        response.setContentType( "application/octet-stream" );//应用程序强制下载
        System.out.print( this.getClass().getResource( "" ) );
        //第二读取文件
        String path = this.getClass().getClassLoader().getResource( name ).getPath();
        InputStream in = new FileInputStream( path );
        //设置响应头，对文件进行url编码
        name = URLEncoder.encode( name, "UTF-8" );
        response.setHeader( "Content-Disposition", "attachment;filename=" + name );
        response.setContentLength( in.available() );

        //第三步：老套路，开始copy
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while ( ( len = in.read( b ) ) != -1 ) {
            out.write( b, 0, len );
        }
        out.flush();
        out.close();
        in.close();
    }

}
