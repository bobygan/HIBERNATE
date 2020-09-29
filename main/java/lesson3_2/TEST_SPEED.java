package lesson3_2;

public class TEST_SPEED {
    private Long id;
    private String some_string;
    private int some_number;

    public TEST_SPEED(Long id, String some_string, int some_number) {
        this.id = id;
        this.some_string = some_string;
        this.some_number = some_number;
    }

    public Long getId() {
        return id;
    }

    public String getSome_string() {
        return some_string;
    }

    public int getSome_number() {
        return some_number;
    }

    @Override
    public String toString() {
        return "TEST_SPEED{" +
                "id=" + id +
                ", some_string='" + some_string + '\'' +
                ", some_number=" + some_number +
                '}';
    }
}