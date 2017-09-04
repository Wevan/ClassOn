package bean;

/**
 * Created by Wean on 2017/8/30.
 */
public class ChzUser {
    private String chzuname;
    private String chzpwd;

    public String getChzuname() {
        return chzuname;
    }

    public ChzUser(String chzuname, String chzpwd) {
        this.chzuname = chzuname;
        this.chzpwd = chzpwd;
    }

    public void setChzuname(String chzuname) {
        this.chzuname = chzuname;
    }

    public String getChzpwd() {
        return chzpwd;
    }

    public void setChzpwd(String chzpwd) {
        this.chzpwd = chzpwd;
    }
}
