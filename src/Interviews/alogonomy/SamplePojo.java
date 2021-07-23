package Interviews.alogonomy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
class Pojo {
    public Pojo(String email, Date id){
        this.email = email;
        this.id = id;
    }
    private Date id;
    private String email;

    public Date getId(){
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }
}

public class SamplePojo {
    public static void main(String[] args) {
        Pojo pojo = new Pojo("test", new Date());
        int i = pojo.getId().getDay()+1;
    }
}



