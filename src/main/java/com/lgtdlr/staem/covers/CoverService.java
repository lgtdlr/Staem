package com.lgtdlr.staem.covers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class CoverService {

    @Autowired
    CoverRepository coverRepository;

    public Long update(final Long id, final MultipartFile file) throws IOException {
        Optional<Cover> cover = this.coverRepository.findById(id);
        if (cover.isPresent()) {
            cover.get().setBlob(file.getBytes());
            cover.get().setContentLength(file.getSize());
            cover.get().setContentType(file.getContentType());
            return this.coverRepository.save(cover.get()).getId();
        }
        return add(file);
    }

    public Long add(final MultipartFile file) throws IOException {
        Cover cover = new Cover();
        cover.setBlob(file.getBytes());
        cover.setContentLength(file.getSize());
        cover.setContentType(file.getContentType());
        return this.coverRepository.save(cover).getId();
    }
}
