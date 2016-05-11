package myddl.controller;

import myddl.dao.ImageMapper;
import myddl.entity.Image;
import myddl.returnobject.ReturnObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Resource
    ImageMapper imageMapper;

    @RequestMapping("/{imageId}")
    @ResponseBody
    public Object getImage(@PathVariable("imageId") Long imageId) {
        return ReturnObject.newOKReturnObject(imageMapper.selectByPrimaryKey(imageId));
    }

    @RequestMapping(value = "/{imageId}", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyImage(@PathVariable("imageId") Long imageId,
                              @RequestParam("data") byte[] data) {
        imageMapper.updateByPrimaryKeySelective(new Image(imageId, data));
        return ReturnObject.EXECUTION_SUCCESS;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Object addImage(@RequestParam("data") byte[] data) {
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
