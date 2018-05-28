package com.showbook.pma.service;

import com.showbook.pma.model.Facility;
import com.showbook.pma.repository.FacilityRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    public Facility findOne(Long id){
        return facilityRepository.findOne(id);
    }

    public List<Facility> findAll(){
        return facilityRepository.findAll();
    }

    public Facility save(Facility facility){
        return facilityRepository.save(facility);
    }

    public void delete(Facility facility){
        facilityRepository.delete(facility);
    }

}
