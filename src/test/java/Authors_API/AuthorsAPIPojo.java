package Authors_API;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AuthorsAPIPojo {
    private String name;
    private Object bio;
    private String personal_name;
    private Date death_date;
    private List<String> alternate_names;
    private Date birth_date;
    private Object type;
    private Object remote_ids;
    private List<String> photos;
    private String key;
    private int latest_revision;
    private int revision;
    private Object created;
    private Object last_modified;
}