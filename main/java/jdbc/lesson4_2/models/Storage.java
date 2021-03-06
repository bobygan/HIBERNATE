package jdbc.lesson4_2.models;
import jdbc.lesson4_2.IdEntity;
import java.util.Arrays;

public class Storage extends IdEntity {
    private Long id;
    private String [] formatsSupported;
    private String storageCountry;
    private Long storageMaxSize;

    public Storage(Long id, String[] formatsSupported, String storageCountry, Long storageMaxSize) {
        this.id = id;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageMaxSize = storageMaxSize;
    }

    public Long getId() {
        return id;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public Long getStorageMaxSize() {
        return storageMaxSize;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", formatsSupported=" + Arrays.toString(formatsSupported) +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageMaxSize=" + storageMaxSize +
                '}';
    }
}

