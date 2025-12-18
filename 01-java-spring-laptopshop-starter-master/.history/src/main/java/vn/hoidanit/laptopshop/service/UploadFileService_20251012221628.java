package vn.Laptopshop.laptopshop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadFileService {

    private final ServletContext servletContext;

    public UploadFileService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        if (file.isEmpty())
            return "";
        String finalName = "";
        try {
            byte[] bytes = file.getBytes();

            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();

            // Tạo tên file duy nhất
            String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            finalName = dir.getAbsolutePath() + File.separator + fileName;

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(finalName));
            stream.write(bytes);
            stream.close();

            // Trả về tên file để lưu vào DB
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //
}
