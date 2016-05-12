package myddl.controller;

import myddl.dao.ImageMapper;
import myddl.entity.Image;
import myddl.returnobject.ReturnObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Resource
    ImageMapper imageMapper;

    @RequestMapping("/{imageId}")
    @ResponseBody
    public Object getImage(@PathVariable("imageId") Long imageId, HttpServletResponse response) throws IOException {
        Image image = imageMapper.selectByPrimaryKey(imageId);
        byte[] data = image.getData();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(data);
        return null;
    }

    @RequestMapping(value = "/{imageId}", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyImage(@PathVariable("imageId") Long imageId,
                              @RequestBody byte[] data) {
        imageMapper.updateByPrimaryKeySelective(new Image(imageId, data));
        return ReturnObject.EXECUTION_SUCCESS;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Object addImage(@RequestBody byte[] data) {
        Image image = new Image(null, data);
        imageMapper.insertSelective(image);
        HashMap<String, Long> result = new HashMap<>();
        result.put("imageId", image.getImageId());
        return ReturnObject.newOKReturnObject(result);
    }

    @RequestMapping(value = "/{imageId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteImage(@PathVariable("imageId") Long imageId) {
        imageMapper.deleteByPrimaryKey(imageId);
        return ReturnObject.EXECUTION_SUCCESS;
    }

}
