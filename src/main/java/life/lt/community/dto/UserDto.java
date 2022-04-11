package life.lt.community.dto;

public class UserDto {
    private String login;
    private Long id;
    private String bio;

    public String getName() {
        return login;
    }

    public void setName(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
