package cn.spike.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PageUtil {

    public static String uploadAnnex(HttpServletRequest request, CommonsMultipartFile file, String model, String model2) {
        String path = request.getRealPath("/upload/" + model + "/");
        String orginalFilename = file.getOriginalFilename();
        String suffix = orginalFilename.substring(orginalFilename.indexOf("."), orginalFilename.length());
        String fileName = model2 + suffix;
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path + fileName;
    }


    public static void showImg(String filePath, HttpServletResponse response) throws IOException {
        response.setContentType("image/*");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        OutputStream outputStream = response.getOutputStream();
        int len;
        byte[] bytes = new byte[1024 * 8];
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
            outputStream.flush();
        }
        fileInputStream.close();
        outputStream.close();
    }

    public static void showImg(InputStream inputStream, HttpServletResponse response) throws IOException {
        response.setContentType("image/*");
        OutputStream outputStream = response.getOutputStream();
        int len;
        byte[] bytes = new byte[1024 * 8];
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
    }

    public static boolean deleteFile(String filePath) throws IOException {
        File file = new File(filePath);
        return file.delete();
    }


    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static void downloadFile(String filePath, HttpServletResponse response) throws IOException {
        response.reset();
        String fileName = getFileNameByFilePath(filePath);
        String mimeType = URLConnection.guessContentTypeFromName(fileName);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(FileUtils.readFileToByteArray(new File(filePath)));
        outputStream.flush();
        outputStream.close();
    }

    public static String getFileNameByFilePath(String filepath){
        String string[] = filepath.split("\\\\");
        return string[string.length-1];
    }
}


