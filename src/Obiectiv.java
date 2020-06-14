import java.util.Date;

//ObjectTransfer
public class Obiectiv {
    private String numeObiectiv,description;
    private boolean done;
    private String date;

    public Obiectiv(String numeObiectiv,boolean done,String description,String date){
        this.numeObiectiv=numeObiectiv;
        this.date=date;
        this.description=description;
        this.done=done;
        this.date=date;
    }

    public void setNumeObiectiv(String numeObiectiv) {
        this.numeObiectiv = numeObiectiv;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumeObiectiv() {
        return numeObiectiv;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public String getDate() {
        return date;
    }

}
