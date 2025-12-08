package vn.hoidanit.laptopshop.service;

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

        try {
            String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();

            // đường dẫn vật lý thực tế trong project (nơi chứa ảnh)
            String rootPath = servletContext.getRealPath("/resources/images/" + targetFolder);
            File dir = new File(rootPath);
            if (!dir.exists())
                dir.mkdirs();

            File serverFile = new File(dir, fileName);
            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                stream.write(file.getBytes());
            }

            // 🔹 chỉ trả về tên file để lưu trong DB
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
