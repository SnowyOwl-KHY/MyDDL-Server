package myddl.entity;

public class Image {
    private Long imageId;

    private byte[] data;

    public Image() {
    }

    public Image(Long imageId, byte[] data) {
        this.imageId = imageId;
        this.data = data;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}