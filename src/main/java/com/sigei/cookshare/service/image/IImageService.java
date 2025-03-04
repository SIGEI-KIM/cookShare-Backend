package com.sigei.cookshare.service.image;

import com.sigei.cookshare.dto.ImageDto;
import com.sigei.cookshare.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    Image getImageById(Long imageId);
    void deleteImage(Long imageId);
    void updateImage(MultipartFile file, Long imageId);
    ImageDto saveImage(Long recipeId, MultipartFile file);
}
